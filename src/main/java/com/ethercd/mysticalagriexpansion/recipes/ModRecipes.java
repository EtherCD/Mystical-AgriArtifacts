package com.ethercd.mysticalagriexpansion.recipes;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.lib.CropType;
import com.ethercd.mysticalagriexpansion.block.BlockGrowthAccelerator;
import com.ethercd.mysticalagriexpansion.block.ModBlocks;
import com.ethercd.mysticalagriexpansion.config.ModConfig;
import com.ethercd.mysticalagriexpansion.crop.CommonCrop;
import com.ethercd.mysticalagriexpansion.crop.CropsRecipe;
import com.ethercd.mysticalagriexpansion.crop.ModCrops;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModMetaPart;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

@SuppressWarnings({"unused", "super"})
public class ModRecipes {
    public static void register() {
        if (ModConfig.integrationMysticalAgradditions && ModChecker.INSANIUM) {
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.INSANIUM_THEORETICAL_WATER.getItem(), 1, 0), "NTN", "TTT", "NTN", 'N', ModParts.itemInsaniumNugget, 'T', ModParts.itemTheoreticalWater);
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.INSANIUM_FERT_CORE.getItem(), 1, 0), "ETE", "FSF", "EFE", 'F', ModParts.itemFertilizedEssence, 'E', ModParts.itemInsaniumEssence, 'S', ModParts.itemSupremiumFertCore, 'T', Blocks.DRAGON_EGG);
            RecipeHelper.addShapedRecipe(new ItemStack(ModItems.itemInstaiumWateringCan, 1, 0), "IF ", "ITI", " I ", 'I', ModParts.itemInsaniumIngot, 'T', ItemCrafting.INSANIUM_FERT_CORE.getItem(), 'F', ItemCrafting.INSANIUM_THEORETICAL_WATER.getItem());
        }

        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0), " I ", "ISI", " I ", 'I', Items.IRON_INGOT, 'S', Items.STICK);

        CropsRecipe.register();

        initMachinesRecipes();

        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_1_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier1Essence, 'Y', ModParts.itemTier1Ingot, 'P', ItemCrafting.ALLOY_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_2_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier2Essence, 'Y', ModParts.itemTier2Ingot, 'P', ItemCrafting.TIER_1_ALLOY_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_3_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier3Essence, 'Y', ModParts.itemTier3Ingot, 'P', ItemCrafting.TIER_2_ALLOY_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_4_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier4Essence, 'Y', ModParts.itemTier4Ingot, 'P', ItemCrafting.TIER_3_ALLOY_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_5_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier5Essence, 'Y', ModParts.itemTier5Ingot, 'P', ItemCrafting.TIER_4_ALLOY_SEEDS.getItem());

        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_1_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier1Essence, 'Y', ModParts.itemTier1Ingot, 'P', ItemCrafting.NUCLEAR_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_2_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier2Essence, 'Y', ModParts.itemTier2Ingot, 'P', ItemCrafting.TIER_1_NUCLEAR_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_3_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier3Essence, 'Y', ModParts.itemTier3Ingot, 'P', ItemCrafting.TIER_2_NUCLEAR_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_4_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier4Essence, 'Y', ModParts.itemTier4Ingot, 'P', ItemCrafting.TIER_3_NUCLEAR_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_5_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier5Essence, 'Y', ModParts.itemTier5Ingot, 'P', ItemCrafting.TIER_4_NUCLEAR_SEEDS.getItem());

        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_1_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier1Essence, 'Y', ModParts.itemTier1Ingot, 'P', ItemCrafting.ELECTRONIC_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_2_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier2Essence, 'Y', ModParts.itemTier2Ingot, 'P', ItemCrafting.TIER_1_ELECTRONIC_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_3_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier3Essence, 'Y', ModParts.itemTier3Ingot, 'P', ItemCrafting.TIER_2_ELECTRONIC_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_4_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier4Essence, 'Y', ModParts.itemTier4Ingot, 'P', ItemCrafting.TIER_3_ELECTRONIC_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_5_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier5Essence, 'Y', ModParts.itemTier5Ingot, 'P', ItemCrafting.TIER_4_ELECTRONIC_SEEDS.getItem());

        if (ModConfig.integrationMysticalAgradditions && ModChecker.INSANIUM) {
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_6_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemInsaniumEssence, 'Y', ModParts.itemInsaniumIngot, 'P', ItemCrafting.TIER_5_ALLOY_SEEDS.getItem());
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_6_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemInsaniumEssence, 'Y', ModParts.itemInsaniumIngot, 'P', ItemCrafting.TIER_5_NUCLEAR_SEEDS.getItem());
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_6_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemInsaniumEssence, 'Y', ModParts.itemInsaniumIngot, 'P', ItemCrafting.TIER_5_ELECTRONIC_SEEDS.getItem());
        }

        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.MUTAGENESIS_CORE.getItem(), 1, 0), "EFE", "GWG", "EFE", 'E', CommonCrop.MECHANICAL.getCrop(), 'F', Blocks.HOPPER, 'G', ItemCrafting.EXEMPLARY_GEAR.getItem(), 'W', ModParts.itemTheoreticalWater);
        RecipeHelper.addShapedRecipe(new ItemStack(ModBlocks.blockInferniumMutagenesisProcessor, 1, 0), "BFB", "GEG", "BFB", 'B', new ItemStack(ModMetaPart.MA_STORAGE.getItem(), 1, 0), 'F', ItemCrafting.MUTAGENESIS_CORE.getItem(), 'G', ModParts.itemTier1Ingot, 'E', ModParts.blockInferiumSeedReprocessor);

        RecipeHelper.addShapedRecipe(new ItemStack(BlockGrowthAccelerator.TIER2.getBlock(), 1, 0), "PGP", "GAG", "PGP", 'P', ModParts.blockEssenceTier2, 'G', Items.DIAMOND, 'A', ModParts.blockGrowthAccelerator);
        RecipeHelper.addShapedRecipe(new ItemStack(BlockGrowthAccelerator.TIER3.getBlock(), 1, 0), "PGP", "GAG", "PGP", 'P', ModParts.blockEssenceTier3, 'G', Items.DIAMOND, 'A', BlockGrowthAccelerator.TIER2.getBlock());
        RecipeHelper.addShapedRecipe(new ItemStack(BlockGrowthAccelerator.TIER4.getBlock(), 1, 0), "PGP", "GAG", "PGP", 'P', ModParts.blockEssenceTier4, 'G', Blocks.DIAMOND_BLOCK, 'A', BlockGrowthAccelerator.TIER3.getBlock());
        RecipeHelper.addShapedRecipe(new ItemStack(BlockGrowthAccelerator.TIER5.getBlock(), 1, 0), "PBP", "GAG", "PBP", 'P', ModParts.blockEssenceTier5, 'B', Blocks.DIAMOND_BLOCK, 'G', Items.NETHER_STAR, 'A', BlockGrowthAccelerator.TIER4.getBlock());
        if (ModConfig.integrationMysticalAgradditions && ModChecker.INSANIUM)
            RecipeHelper.addShapedRecipe(new ItemStack(BlockGrowthAccelerator.TIER6.getBlock(), 1, 0), "PGP", "BAB", "PGP", 'P', ModParts.blockEssenceTier6, 'B', Blocks.DRAGON_EGG, 'G', Items.NETHER_STAR, 'A', BlockGrowthAccelerator.TIER5.getBlock());
    }

    private static void initMachinesRecipes() {
        MutagenesisRecipesManager.addRecipe(CropType.Type.THORIUM.getSeed(), CropType.Type.URANIUM.getSeed(), ItemCrafting.NUCLEAR_SEEDS.getItem(), 6);
        MutagenesisRecipesManager.addRecipe(CropType.Type.THORIUM.getSeed(), CropType.Type.URANIUM_238.getSeed(), ItemCrafting.NUCLEAR_SEEDS.getItem(), 12);
        MutagenesisRecipesManager.addRecipe(CropType.Type.URANIUM.getSeed(), CropType.Type.URANIUM_238.getSeed(), ItemCrafting.NUCLEAR_SEEDS.getItem(), 16);

        MutagenesisRecipesManager.addRecipe(CropType.Type.BRONZE.getSeed(), CropType.Type.INVAR.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
        MutagenesisRecipesManager.addRecipe(CropType.Type.BRONZE.getSeed(), CropType.Type.ELECTRUM.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
        MutagenesisRecipesManager.addRecipe(CropType.Type.BRONZE.getSeed(), CropType.Type.CONSTANTAN.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.CONDUCTIVE_IRON.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 16);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.DARK_STEEL.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 16);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.PULSATING_IRON.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.ENERGETIC_ALLOY.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 16);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.VIBRANT_ALLOY.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.END_STEEL.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
    }


    public enum ShapeEssenceRecipe {
        RHOMBUS(" E ", "E E", " E "),
        FULL("EEE", "EEE", "EEE"),
        CENTER("   ", " E ", "   "),
        STAR(" E ", "EEE", " E ")
        ;

        private final String[] shape;

        ShapeEssenceRecipe(String top, String center, String bottom) {
            shape = new String[] {top,center,bottom};
        }

        public String[] getShape() {
            return shape;
        }
    }
}
