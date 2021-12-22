package xyz.skidsdev.crystis.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.LightningRodBlock;
import net.minecraft.block.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.skidsdev.crystis.Crystis;
import xyz.skidsdev.crystis.recipe.CrystisRecipeType;
import xyz.skidsdev.crystis.registry.CrystisEntities;
import xyz.skidsdev.crystis.registry.CrystisRecipes;

import java.util.Optional;

public class CrystalariumBlockEntity
extends BlockEntity
implements Inventory {
    protected DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    protected CrystisRecipeType recipeType;
    protected boolean completedCraft;

    public CrystalariumBlockEntity(BlockPos pos, BlockState state) {
        super(CrystisEntities.CRYSTALARIUM_BLOCK_ENTITY, pos, state);
        this.recipeType = CrystisRecipes.CRYSTALARIUM;
    }

    public boolean hasCompletedCraft() { return completedCraft; }

    @Override
    public int size() { return inventory.size(); }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : inventory) {
            if (itemStack.isEmpty()) continue;
            return false;
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) { return inventory.get(slot); }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        completedCraft = false;
        return Inventories.splitStack(inventory, slot, amount);
    }

    @Override
    public ItemStack removeStack(int slot) {
        completedCraft = false;
        return Inventories.removeStack(inventory, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        completedCraft = false;
        stack.setCount(1);
        this.inventory.set(slot, stack);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) { return true;  }

    @Override
    public void clear() { this.inventory.clear(); }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        return slot >= 0 && slot < size() && (stack.isEmpty() || stack.getCount() == 1);
    }

    public void tryCraft(World world, BlockState rod) {
        Crystis.LOGGER.info("Has completed " + hasCompletedCraft());
        Crystis.LOGGER.info("Is powered " + rod.get(LightningRodBlock.POWERED));
        if (hasCompletedCraft() || !rod.get(LightningRodBlock.POWERED)) return;

        ItemStack itemStack = getStack(0);

        Crystis.LOGGER.info("Trying to craft crystalarium recipe from " + itemStack.getItem().getName().toString());
        if (!itemStack.isEmpty()) {
            Crystis.LOGGER.info("Crystalarium is not empty");
            Optional<? extends Recipe<Inventory>> recipeOption = world.getRecipeManager().getFirstMatch(recipeType, this, world);
            if (recipeOption.isEmpty()) return;
            Crystis.LOGGER.info("Found recipe");
            Recipe<Inventory> recipe = (Recipe)recipeOption.get();
            setStack(0, recipe.craft(this));
            completedCraft = true;
        }
    }
}
