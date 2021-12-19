package xyz.skidsdev.crystis.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.skidsdev.crystis.Crystis;
import xyz.skidsdev.crystis.entity.CrystalariumBlockEntity;

public class CrystisEntities {
    public static BlockEntityType<CrystalariumBlockEntity> CRYSTALARIUM_BLOCK_ENTITY;

    private static BlockEntityType registerBlockEntity(String name, Block block, FabricBlockEntityTypeBuilder.Factory<? extends BlockEntity> factory) {
        return Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(Crystis.MODID, name),
            FabricBlockEntityTypeBuilder
                .create(factory, block)
                .build(null));
    }

    public static void registerAll() {
        CRYSTALARIUM_BLOCK_ENTITY = registerBlockEntity("crystalarium_block_entity", CrystisBlocks.CRYSTALARIUM, CrystalariumBlockEntity::new);
    }
}
