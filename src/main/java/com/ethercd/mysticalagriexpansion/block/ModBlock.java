package com.ethercd.mysticalagriexpansion.block;

import com.ethercd.mysticalagriexpansion.MACreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

@SuppressWarnings({ "unused" })
public class ModBlock extends Block {
    public ModBlock(String name, Material material, SoundType sound, float hardness, float resistance) {
        super(material);
        setCreativeTab(MACreativeTabs.CREATIVE_TAB);
        setSoundType(sound);
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(hardness);
        setResistance(resistance);
    }

    public ModBlock(String name, Material material, SoundType sound, float hardness, float resistance, String tool, int level) {
        this(name, material, sound, hardness, resistance);
        setHarvestLevel(tool, level);
    }
}
