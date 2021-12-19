package xyz.skidsdev.crystis.recipe;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import xyz.skidsdev.crystis.Crystis;
import xyz.skidsdev.crystis.registry.CrystisRecipes;

public class CrystalariumRecipe extends CrystisRecipe {

    private final Ingredient input;
    private final ItemStack output;

    public CrystalariumRecipe(Identifier id, Ingredient input, ItemStack output) {
        super(id, CrystisRecipes.CRYSTALARIUM);
        this.input = input;
        this.output = output;
    }

    @Override
    public ItemStack craft(Inventory inventory) { return this.output.copy(); }

    public Ingredient getInput() { return input; }

    @Override
    public ItemStack getOutput() { return output; }

    @Override
    public RecipeSerializer<?> getSerializer() { return CrystalariumRecipeSerializer.INSTANCE; }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return DefaultedList.copyOf(Ingredient.EMPTY, input);
    }
}
