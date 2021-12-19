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

public class CrystalariumRecipe implements Recipe<Inventory> {
    public static final Identifier TYPE_ID = new Identifier(Crystis.MODID, "crystalarium");
    public static final RecipeType<CrystalariumRecipe> TYPE = RecipeType.register(TYPE_ID.toString());

    private final Identifier id;

    private final Ingredient input;
    private final ItemStack output;

    public CrystalariumRecipe(Identifier id, Ingredient input, ItemStack output) {
        this.id = id;
        this.input = input;
        this.output = output;
    }

    @Override
    public boolean matches(Inventory inventory, World world) { return false; }

    @Override
    public ItemStack craft(Inventory inventory) { return this.output.copy(); }

    @Override
    public boolean fits(int width, int height) { return true; }

    public Ingredient getInput() { return input; }

    @Override
    public ItemStack getOutput() { return output; }

    @Override
    public Identifier getId() { return id; }

    @Override
    public RecipeSerializer<?> getSerializer() { return CrystalariumRecipeSerializer.INSTANCE; }

    @Override
    public RecipeType<?> getType() { return TYPE; }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return DefaultedList.copyOf(Ingredient.EMPTY, input);
    }
}
