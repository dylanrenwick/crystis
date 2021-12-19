package xyz.skidsdev.crystis.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import xyz.skidsdev.crystis.registry.CrystisItems;

public class FineAmethystToolMaterial implements ToolMaterial {
    public static final FineAmethystToolMaterial INSTANCE = new FineAmethystToolMaterial();

    @Override
    public int getDurability() {
        return 200;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6F;
    }

    @Override
    public float getAttackDamage() {
        return 3.5F;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(CrystisItems.LARGE_AMETHYST);
    }
}
