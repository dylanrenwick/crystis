package xyz.skidsdev.crystis.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.LightningEntity;

import java.util.List;

public class LightningRodItem extends Item {
    public LightningRodItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        boolean isCosmetic = !context.getPlayer().isSneaking();
        causeLightning(context.getWorld(), pos, isCosmetic);
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.crystis.lightning_wand.tooltip_1").formatted(Formatting.GRAY));
        tooltip.add(new TranslatableText("item.crystis.lightning_wand.tooltip_2").formatted(Formatting.GRAY));
        tooltip.add(new TranslatableText("item.crystis.lightning_wand.tooltip_3").formatted(Formatting.GRAY));
    }

    private static void causeLightning(World world, BlockPos pos, boolean cosmetic) {
        LightningEntity bolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        bolt.setPos(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
        bolt.setCosmetic(cosmetic);
        world.spawnEntity(bolt);
    }
}
