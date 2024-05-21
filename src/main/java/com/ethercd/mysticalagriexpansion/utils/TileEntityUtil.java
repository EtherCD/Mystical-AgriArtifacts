package com.ethercd.mysticalagriexpansion.utils;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

@SuppressWarnings("NullableProblems")
public abstract class TileEntityUtil extends TileEntity {
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag);
        writeCustomNBT(tag);
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag){
        super.readFromNBT(tag);
        readCustomNBT(tag);
    }

    public abstract void writeCustomNBT(NBTTagCompound tag);
    public abstract void readCustomNBT(NBTTagCompound tag);

    @Override
    public SPacketUpdateTileEntity getUpdatePacket(){
        NBTTagCompound tag = new NBTTagCompound();
        writeCustomNBT(tag);
        return new SPacketUpdateTileEntity(pos, -1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet){
        readCustomNBT(packet.getNbtCompound());
    }
}
