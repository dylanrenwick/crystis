package xyz.skidsdev.crystis.registry;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.skidsdev.crystis.Crystis;
import xyz.skidsdev.crystis.recipe.CrystalariumRecipeSerializer;
import xyz.skidsdev.crystis.recipe.CrystisRecipeType;

public class CrystisRecipes {
    public static final CrystisRecipeType CRYSTALARIUM = new CrystisRecipeType(new Identifier(Crystis.MODID, "crystalarium"));

    public static void registerAll() {
        registerRecipeType(new Identifier(Crystis.MODID, "crystalarium"), CRYSTALARIUM, CrystalariumRecipeSerializer.INSTANCE);
    }

    private static void registerRecipeType(Identifier id, RecipeType<?> recipeType, RecipeSerializer<?> recipeSerializer) {
        Registry.register(Registry.RECIPE_SERIALIZER, id, recipeSerializer);
        Registry.register(Registry.RECIPE_TYPE, id, recipeType);
    }
}
