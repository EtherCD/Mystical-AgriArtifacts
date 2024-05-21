package com.ethercd.mysticalagriexpansion.block;

import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagriculture.config.ModConfig;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

import java.util.Random;

@SuppressWarnings({"unused", "RedundantMethodOverride", "NullableProblems"})
public class BlockCrop extends BlockCrops {
    private static final AxisAlignedBB CROPS_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);
    private Item seed;
    private Item crop;

    public BlockCrop(String name){
        super();
        setUnlocalizedName(name);
        setHardness(0.0F);
        setSoundType(SoundType.PLANT);
        disableStats();
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand){
        checkAndDropBlock(world, pos, state);
        int i = getAge(state);
        if(world.getLightFromNeighbors(pos.up()) >= 9){
            if(i < getMaxAge()){
                float f = getGrowthChance(this, world, pos);
                if(rand.nextInt((int)(35.0F / f) + 1) == 0) {
                    world.setBlockState(pos, withAge(i + 1), 2);
                }
            }
        }
    }

    @Override
    protected boolean canSustainBush(IBlockState state){
        return state.getBlock() == Blocks.FARMLAND;
    }

    @Override
    public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state){
        return false;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Crop;
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return CROPS_AABB;
    }

    public void setSeed(Item seed){
        this.seed = seed;
    }

    @Override
    public Item getSeed(){
        return seed;
    }

    public BlockCrop setCrop(Item crop){
        this.crop = crop;
        return this;
    }

    @Override
    public Item getCrop() {
        return crop;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        int age = state.getValue(AGE);
        Random rand = Utils.rand;

        int essence = 0;
        int fertilizer = 0;

        if (age == 7) {
            if (ModConfig.confFertilizedEssenceChance > 0) {
                if (!(rand.nextInt(100 / ModConfig.confFertilizedEssenceChance) > 0)) {
                    fertilizer = 1;
                }
            }
        }

        if (age == 7) {
            if (ModConfig.confEssenceChance > 0) {
                if (rand.nextInt(100 / ModConfig.confEssenceChance) > 0) {
                    essence = 1;
                } else {
                    essence = 2;
                }
            } else
                essence = 1;
        }

        drops.add(new ItemStack(getSeed(), 1, 0));
        if (essence > 0) {
            drops.add(new ItemStack(getCrop(), essence, 0));
        }
        if (fertilizer > 0) {
            drops.add(ModParts.itemFertilizedEssence);
        }
    }
}
