package xyz.skidsdev.crystis.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FlintToolMaterial implements ToolMaterial {
    public static final FlintToolMaterial INSTANCE = new FlintToolMaterial();

    @Override
    public int getDurability() {
        return 10;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 1.2F;
    }

    @Override
    public float getAttackDamage() {
        return 2;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 8;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.FLINT);
    }
}
