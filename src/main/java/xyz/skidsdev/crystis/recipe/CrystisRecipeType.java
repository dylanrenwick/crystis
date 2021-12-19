package xyz.skidsdev.crystis.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;

public class CrystisRecipeType implements RecipeType<CrystisRecipe> {
    private final Identifier id;

    public CrystisRecipeType(Identifier id) {
        this.id = id;
    }
}
