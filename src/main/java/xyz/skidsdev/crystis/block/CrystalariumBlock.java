package xyz.skidsdev.crystis.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import xyz.skidsdev.crystis.Crystis;
import xyz.skidsdev.crystis.entity.CrystalariumBlockEntity;

import java.util.List;
import java.util.Random;

public class CrystalariumBlock extends Block implements BlockEntityProvider {
    public CrystalariumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("block.crystis.crystalarium.tooltip_1").formatted(Formatting.GRAY));
        tooltip.add(new TranslatableText("block.crystis.crystalarium.tooltip_2").formatted(Formatting.GRAY));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrystalariumBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        CrystalariumBlockEntity blockEntity = (CrystalariumBlockEntity) world.getBlockEntity(pos);

        ItemStack heldStack = player.getStackInHand(hand);
        if (heldStack.isOf(Items.LIGHTNING_ROD)) return ActionResult.PASS;

        boolean hasRod = hasLightningRod(world, pos);

        if (!hasRod) {
            player.sendMessage(new TranslatableText("block." + Crystis.MODID + ".crystalarium.no_rod"), true);
        }

        if (blockEntity.hasCompletedCraft() || (!blockEntity.isEmpty() && (heldStack.isEmpty() || !hasRod))) {
            ItemStack itemStack = blockEntity.removeStack(0);
            if (!player.getInventory().insertStack(itemStack)) {
                spawnItemEntity(itemStack, world, pos);
            }
            return ActionResult.CONSUME;
        } else if (blockEntity.isEmpty() && !heldStack.isEmpty()) {
            blockEntity.setStack(0, heldStack.copy());
            heldStack.decrement(1);
            return ActionResult.CONSUME;
        }

        return ActionResult.PASS;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

    }

    private static void spawnItemEntity(ItemStack stack, World world, BlockPos pos) {
        ItemEntity entity = new ItemEntity(world, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, stack);
        world.spawnEntity(entity);
    }

    private boolean hasLightningRod(World world, BlockPos pos) {
        BlockPos rodPos = pos.add(0, 1, 0);
        BlockState rodState = world.getBlockState(rodPos);
        return rodState.isOf(Blocks.LIGHTNING_ROD);
    }
}
