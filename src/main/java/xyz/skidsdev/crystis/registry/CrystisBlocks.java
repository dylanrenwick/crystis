package xyz.skidsdev.crystis.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import xyz.skidsdev.crystis.Crystis;
import xyz.skidsdev.crystis.block.CrystalariumBlock;

public class CrystisBlocks {
    public static final CrystalariumBlock CRYSTALARIUM = new CrystalariumBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f));

    private static void registerBlock(Block block, String name, Rarity rarity) {
        Registry.register(Registry.BLOCK, new Identifier(Crystis.MODID, name), block);
        Item blockItem = new BlockItem(block, new FabricItemSettings().group(ItemGroup.DECORATIONS).rarity(rarity));
        Registry.register(Registry.ITEM, new Identifier(Crystis.MODID, name), blockItem);
    }

    public static void registerAll() {
        registerBlock(CRYSTALARIUM, "crystalarium", Rarity.UNCOMMON);
    }
}
