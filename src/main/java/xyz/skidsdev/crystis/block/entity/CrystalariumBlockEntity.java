package xyz.skidsdev.crystis.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Overwrite;
import xyz.skidsdev.crystis.registry.CrystisEntities;

public class CrystalariumBlockEntity
extends BlockEntity
implements Inventory {
    protected DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    protected boolean completedCraft;

    public CrystalariumBlockEntity(BlockPos pos, BlockState state) {
        super(CrystisEntities.CRYSTALARIUM_BLOCK_ENTITY, pos, state);
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
    public ItemStack removeStack(int slot, int amount) { return Inventories.splitStack(inventory, slot, amount); }

    @Override
    public ItemStack removeStack(int slot) { return Inventories.removeStack(inventory, slot); }

    @Override
    public void setStack(int slot, ItemStack stack) {
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
}
