package xyz.skidsdev.crystis;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.skidsdev.crystis.registry.*;

public class Crystis implements ModInitializer {
    public static final String MODID = "crystis";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @Override
    public void onInitialize() {
        CrystisItems.registerAll();
        CrystisBlocks.registerAll();
        CrystisEntities.registerAll();
        CrystisRecipes.registerAll();
    }
}
