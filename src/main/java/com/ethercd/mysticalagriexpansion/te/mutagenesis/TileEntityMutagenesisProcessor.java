package com.ethercd.mysticalagriexpansion.te.mutagenesis;


import com.blakebr0.cucumber.helper.StackHelper;
import com.blakebr0.cucumber.util.VanillaPacketDispatcher;
import com.ethercd.mysticalagriexpansion.recipes.MutagenesisRecipesManager;
import com.ethercd.mysticalagriexpansion.recipes.MutagenesisResult;
import com.ethercd.mysticalagriexpansion.utils.TileEntityUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.util.ITickable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

@SuppressWarnings({"NullableProblems", "unchecked"})
public abstract class TileEntityMutagenesisProcessor extends TileEntityUtil implements ISidedInventory, ITickable, ICapabilityProvider {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(5, ItemStack.EMPTY);
    private int progress;

    @Override
    public void writeCustomNBT(NBTTagCompound tag) {
        tag.setInteger("Progress", this.progress);

        ItemStackHelper.saveAllItems(tag, this.inventory);
    }

    @Override
    public void readCustomNBT(NBTTagCompound tag) {
        this.progress = tag.getInteger("Progress");

        ItemStackHelper.loadAllItems(tag, this.inventory);
    }

    private ItemStack copyItemStack(ItemStack stack) {
        ItemStack stack1 = stack.copy();
        stack1.setCount(1);
        return stack1;
    }

    @Override
    public void update() {
        if (getWorld().isRemote)
            return;

        boolean mark = false;

        ItemStack input1 = getStackInSlot(0);
        ItemStack input2 = getStackInSlot(1);
        ItemStack output1 = getStackInSlot(2);
        ItemStack output2 = getStackInSlot(3);
        ItemStack output3 = getStackInSlot(4);

        if (!input1.isEmpty() && !input2.isEmpty()) {
            MutagenesisResult recipeOutput = MutagenesisRecipesManager.getResult(input1, input2);

            if (!recipeOutput.getItem().isEmpty()
                    && (output1.isEmpty() || StackHelper.canCombineStacks(output1, recipeOutput.getItem()))
                    && (output2.isEmpty() || StackHelper.canCombineStacks(output2, copyItemStack(input1)))
                    && (output3.isEmpty() || StackHelper.canCombineStacks(output3, copyItemStack(input2)))) {
                progress++;
                if (progress >= getOperationTime()) {
                    if (recipeOutput.getSuccess(getChanceMultiplier())) {
                        if (output1.isEmpty()) {
                            setInventorySlotContents(2, recipeOutput.getItem().copy());
                        } else {
                            output1.grow(recipeOutput.getItem().getCount());
                        }
                    }
                    if (output2.isEmpty()) {
                        setInventorySlotContents(3, copyItemStack(input1));
                    } else {
                        output2.grow(1);
                    }
                    if (output3.isEmpty()) {
                        setInventorySlotContents(4, copyItemStack(input2));
                    } else {
                        output3.grow(1);
                    }
                    decrStackSize(0, 1);
                    decrStackSize(1, 1);
                    progress = 0;
                }
                mark = true;
            }
        } else {
            if (progress > 0) {
                progress = 0;
                mark = true;
            }
        }

        if (mark) {
            markDirty();
        }
    }

    @Override
    public void markDirty() {
        super.markDirty();
        VanillaPacketDispatcher.dispatchTEToNearbyPlayers(this);
    }

    @Override
    public int getSizeInventory() {
        return 5;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory.get(slot);
    }
    @Override
    public ItemStack decrStackSize(int slot, int decrement) {
        return ItemStackHelper.getAndSplit(inventory, slot, decrement);
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(getPos()) == this && player.getDistanceSq(getPos().add(0.5D, 0.5D, 0.5D)) <= 64.0D;
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 2) {
            return false;
        } else return index != 1;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.inventory.set(index, stack);

        if (stack.getCount() > getInventoryStackLimit()) {
            stack.setCount(getInventoryStackLimit());
        }
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(inventory, index);
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.UP ? new int[] { 0 } : side == EnumFacing.DOWN ? new int[] { 2 } : new int[] { 1 };
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, EnumFacing facing) {
        return this.isItemValidForSlot(index, stack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing facing) {
        return index == 2;
    }

    @Override
    public boolean isEmpty() {
        return !inventory.stream().anyMatch(s -> !s.isEmpty());
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing side) {
        return getCapability(capability, side) != null;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return (T) new SidedInvWrapper(this, facing);
        }

        return super.getCapability(capability, facing);
    }

    public abstract int getOperationTime();
    public abstract float getChanceMultiplier();

    public int getProgress() {
        return progress;
    }
}
