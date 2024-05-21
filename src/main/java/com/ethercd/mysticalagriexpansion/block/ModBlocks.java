package com.ethercd.mysticalagriexpansion.block;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import com.ethercd.mysticalagriexpansion.block.mutagenesis.BlockInferiumMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.block.mutagenesis.BlockInsaniumMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.block.mutagenesis.BlockIntermediumMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.block.mutagenesis.BlockMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.block.mutagenesis.BlockPrudentiumMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.block.mutagenesis.BlockSuperiumMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.block.mutagenesis.BlockSupremiumMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.config.ModConfig;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.utils.RegisteredObject;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<RegisteredObject<Block>> BLOCKS = new ArrayList<>();

    public static void add(Block item, String name) {
        BLOCKS.add(new RegisteredObject<>(item, name));
    }

    public static BlockMutagenesisProcessor blockInferniumMutagenesisProcessor = new BlockInferiumMutagenesisProcessor();
    public static BlockMutagenesisProcessor blockPrudentiumMutagenesisProcessor = new BlockPrudentiumMutagenesisProcessor();
    public static BlockMutagenesisProcessor blockIntermediumMutagenesisProcessor = new BlockIntermediumMutagenesisProcessor();
    public static BlockMutagenesisProcessor blockSuperiumMutagenesisProcessor = new BlockSuperiumMutagenesisProcessor();
    public static BlockMutagenesisProcessor blockSupremiumMutagenesisProcessor = new BlockSupremiumMutagenesisProcessor();
    public static BlockMutagenesisProcessor blockInsaniumMutagenesisProcessor = new BlockInsaniumMutagenesisProcessor();

    public static void register() {
        ModRegistry registry = MysticalAgriexpansion.REGISTRY;

        if (ModConfig.growthAcceleratorsActive)
            BlockGrowthAccelerator.init();
        if (ModConfig.mutagenesisProcessors) {
            if (ModConfig.mutagenesisProcessorTier1)
                registry.register(blockInferniumMutagenesisProcessor, "inferium_mutagenesis_processor");
            if (ModConfig.mutagenesisProcessorTier2)
                registry.register(blockPrudentiumMutagenesisProcessor, "prudentium_mutagenesis_processor");
            if (ModConfig.mutagenesisProcessorTier3)
                registry.register(blockIntermediumMutagenesisProcessor, "intermedium_mutagenesis_processor");
            if (ModConfig.mutagenesisProcessorTier4)
                registry.register(blockSuperiumMutagenesisProcessor, "superium_mutagenesis_processor");
            if (ModConfig.mutagenesisProcessorTier5)
                registry.register(blockSupremiumMutagenesisProcessor, "supremium_mutagenesis_processor");
            if (ModConfig.integrationMysticalAgradditions && ModConfig.mutagenesisProcessorTier6 && ModChecker.INSANIUM)
                registry.register(blockInsaniumMutagenesisProcessor, "insanium_mutagenesis_processor");
        }

        for (RegisteredObject<Block> elem : BLOCKS) {
            registry.register(elem.getObject(), elem.getName(), true);
        }
    }
}
