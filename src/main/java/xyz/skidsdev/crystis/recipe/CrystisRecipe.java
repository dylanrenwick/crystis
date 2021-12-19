package xyz.skidsdev.crystis.recipe;

import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import xyz.skidsdev.crystis.registry.CrystisRecipes;

public abstract class CrystisRecipe implements Recipe<Inventory> {
    private final Identifier id;
    private final CrystisRecipeType type;

    CrystisRecipe(Identifier id, CrystisRecipeType type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public boolean matches(Inventory inventory, World world) { return false; }

    @Override
    public boolean fits(int width, int height) { return true; }

    @Override
    public Identifier getId() { return id; }

    @Override
    public RecipeType<?> getType() { return type; }
}
