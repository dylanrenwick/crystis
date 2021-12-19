package xyz.skidsdev.crystis;

import net.fabricmc.api.ModInitializer;
import xyz.skidsdev.crystis.registry.*;

public class Crystis implements ModInitializer {
    public static final String MODID = "crystis";

    @Override
    public void onInitialize() {
        CrystisItems.registerAll();
        CrystisBlocks.registerAll();
        CrystisEntities.registerAll();
    }
}
