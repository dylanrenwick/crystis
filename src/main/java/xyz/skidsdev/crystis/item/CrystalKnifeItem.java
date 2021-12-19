package xyz.skidsdev.crystis.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.skidsdev.crystis.registry.CrystisItems;

public class CrystalKnifeItem extends ToolItem {
    public CrystalKnifeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockState blockState = context.getWorld().getBlockState(context.getBlockPos());
        if (context.getPlayer() != null && blockState.isOf(Blocks.AMETHYST_CLUSTER)) {
            return cutAmethyst(context);
        }
        return ActionResult.PASS;
    }

    private ActionResult cutAmethyst(ItemUsageContext context) {
        if (itemIsBroken(context.getStack())) return ActionResult.FAIL;

        World world = context.getWorld();
        world.breakBlock(context.getBlockPos(), false, context.getPlayer());
        world.spawnEntity(createDropEntity(world, context.getBlockPos()));
        context.getStack().damage(1, context.getPlayer(), null);

        return ActionResult.PASS;
    }

    private boolean itemIsBroken(ItemStack itemStack) {
        return itemStack.getDamage() >= itemStack.getMaxDamage();
    }

    private ItemEntity createDropEntity(World world, BlockPos pos) {
        int dropCount = world.getRandom().nextInt(1, 4);
        ItemStack itemStack = new ItemStack(CrystisItems.CUT_AMETHYST, dropCount);
        return new ItemEntity(
            world,
            pos.getX() + 0.5,
            pos.getY() + 0.5,
            pos.getZ() + 0.5,
            itemStack
        );
    }
}
