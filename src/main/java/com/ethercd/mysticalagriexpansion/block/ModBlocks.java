package com.ethercd.mysticalagriexpansion.block;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriexpansion.Mod;
import com.ethercd.mysticalagriexpansion.crop.ModCommonCrop;
import com.ethercd.mysticalagriexpansion.crop.ModNuclearCrops;
import com.ethercd.mysticalagriexpansion.crop.NuclearCrop;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS_MODEL_REGISTER = new ArrayList<>();

    public static void init() {
        final ModRegistry registry = Mod.REGISTRY;

        BlockGrowthAccelerator.init(registry);

        for (ModCommonCrop type : ModCommonCrop.values()) {
            if (type.isEnabled()) {
                registry.register(type.getPlant(), type.getName() + "_crop");
            }
        }
        for (NuclearCrop crop : ModNuclearCrops.NUCLEAR_CROPS_LIST) {
            if (crop.isEnabled()) {
                registry.register(crop.getPlant(), crop.getName() + "_crop");
            }
        }
    }
}