package xyz.skidsdev.crystis.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.LightningRodBlock;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import xyz.skidsdev.crystis.Crystis;
import xyz.skidsdev.crystis.item.*;

public class CrystisItems {
    public static final Item COPPER_ROD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item CUT_AMETHYST = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item LARGE_AMETHYST = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    public static final Item FLINT_CUTTING_KNIFE = new CrystalKnifeItem(FlintToolMaterial.INSTANCE, new FabricItemSettings().group(ItemGroup.TOOLS));

    public static final Item FINE_AMETHYST_AXE = new CrystisAxeItem(FineAmethystToolMaterial.INSTANCE, 5, -3F, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final Item FINE_AMETHYST_PICKAXE = new CrystisPickaxeItem(FineAmethystToolMaterial.INSTANCE, 0, -2.6F, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final Item FINE_AMETHYST_SHOVEL = new ShovelItem(FineAmethystToolMaterial.INSTANCE, 0.5F, -2.8F, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final Item FINE_AMETHYST_SWORD = new SwordItem(FineAmethystToolMaterial.INSTANCE, 2, -2.2F, new FabricItemSettings().group(ItemGroup.COMBAT));

    public static final Item LIGHTNING_WAND = new LightningRodItem(new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.EPIC));

    private static void registerItem(Item item, String name) {
        Registry.register(Registry.ITEM, new Identifier(Crystis.MODID, name), item);
    }

    public static void registerAll() {
        registerItem(COPPER_ROD, "copper_rod");
        registerItem(CUT_AMETHYST, "cut_amethyst");
        registerItem(LARGE_AMETHYST, "large_amethyst");

        registerItem(FLINT_CUTTING_KNIFE, "flint_cutting_knife");
        registerItem(FINE_AMETHYST_AXE, "fine_amethyst_axe");
        registerItem(FINE_AMETHYST_PICKAXE, "fine_amethyst_pickaxe");
        registerItem(FINE_AMETHYST_SHOVEL, "fine_amethyst_shovel");
        registerItem(FINE_AMETHYST_SWORD, "fine_amethyst_sword");

        registerItem(LIGHTNING_WAND, "lightning_wand");
    }
}
