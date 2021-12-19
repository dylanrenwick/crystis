package xyz.skidsdev.crystis.recipe;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;

public class CrystalariumRecipeSerializer implements RecipeSerializer<CrystalariumRecipe> {
    public static final CrystalariumRecipeSerializer INSTANCE = new CrystalariumRecipeSerializer();

    @Override
    public CrystalariumRecipe read(Identifier id, JsonObject json) {
        Ingredient input = Ingredient.fromJson(json.get("input"));
        ItemStack output = ShapedRecipe.outputFromJson(json.getAsJsonObject("output"));
        return new CrystalariumRecipe(id, input, output);
    }

    @Override
    public CrystalariumRecipe read(Identifier id, PacketByteBuf buf) {
        Ingredient input = Ingredient.fromPacket(buf);
        ItemStack output = buf.readItemStack();
        return new CrystalariumRecipe(id, input, output);
    }

    @Override
    public void write(PacketByteBuf buf, CrystalariumRecipe recipe) {
        recipe.getInput().write(buf);
        buf.writeItemStack(recipe.getOutput());
    }
}
