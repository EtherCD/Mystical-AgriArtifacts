package com.ethercd.mysticalagriexpansion.te.mutagenesis;

import com.blakebr0.cucumber.util.VanillaPacketDispatcher;
import com.ethercd.mysticalagriexpansion.config.ModConfig;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;

@SuppressWarnings("NullableProblems")
public class TileIntermediumMutagenesisProcessor extends TileEntityMutagenesisProcessor{
    @Override
    public int getOperationTime() {
        return ModConfig.mutagenesisProcessorTier3OperationTime;
    }

    @Override
    public float getChanceMultiplier() {
        return ModConfig.mutagenesisProcessorTier3ChanceMultiplier;
    }

    @Override
    public void markDirty() {
        super.markDirty();
        VanillaPacketDispatcher.dispatchTEToNearbyPlayers(this);
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(getPos(), -1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager manager, SPacketUpdateTileEntity packet) {
        readFromNBT(packet.getNbtCompound());
    }

    @Override
    public final NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }
}
