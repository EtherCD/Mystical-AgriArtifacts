package com.ethercd.mysticalagriexpansion.lib;

import com.blakebr0.mysticalagriculture.blocks.BlockStorage;
import com.blakebr0.mysticalagriculture.blocks.ModBlocks;
import com.blakebr0.mysticalagriculture.blocks.reprocessor.BlockInferiumReprocessor;
import com.blakebr0.mysticalagriculture.items.ItemCrafting;
import com.blakebr0.mysticalagriculture.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;


/**
 * This class contains all resources from other mods
 */
@SuppressWarnings({"unused", "CallToPrintStackTrace"})
public class ModParts {
    // Mystical Agriculture
    public static ItemStack itemProsperityShard = ItemCrafting.itemProsperityShard;
    public static ItemStack itemTier1Essence = ItemCrafting.itemInferiumEssence;
    public static ItemStack itemTier2Essence = ItemCrafting.itemPrudentiumEssence;
    public static ItemStack itemTier3Essence = ItemCrafting.itemIntermediumEssence;
    public static ItemStack itemTier4Essence = ItemCrafting.itemSuperiumEssence;
    public static ItemStack itemTier5Essence = ItemCrafting.itemSupremiumEssence;
    public static ItemStack itemTier1CraftingSeed = ItemCrafting.itemTier1CraftingSeed;
    public static ItemStack itemTier2CraftingSeed = ItemCrafting.itemTier2CraftingSeed;
    public static ItemStack itemTier3CraftingSeed = ItemCrafting.itemTier3CraftingSeed;
    public static ItemStack itemTier4CraftingSeed = ItemCrafting.itemTier4CraftingSeed;
    public static ItemStack itemTier5CraftingSeed = ItemCrafting.itemTier5CraftingSeed;
    public static ItemStack itemTier1Ingot = ItemCrafting.itemInferiumIngot;
    public static ItemStack itemTier2Ingot = ItemCrafting.itemPrudentiumIngot;
    public static ItemStack itemTier3Ingot = ItemCrafting.itemIntermediumIngot;
    public static ItemStack itemTier4Ingot = ItemCrafting.itemSuperiumIngot;
    public static ItemStack itemTier5Ingot = ItemCrafting.itemSupremiumIngot;
    public static ItemStack itemSupremiumFertCore = ItemCrafting.itemSupremiumFertCore;
    public static ItemStack itemTheoreticalWater = ItemCrafting.itemTheoreticalWater;
    public static BlockInferiumReprocessor blockInferiumSeedReprocessor = ModBlocks.INFERIUM_REPROCESSOR;
    public static Block blockGrowthAccelerator = ModBlocks.blockGrowthAccelerator;
    public static ItemStack blockEssenceTier2;
    public static ItemStack blockEssenceTier3;
    public static ItemStack blockEssenceTier4;
    public static ItemStack blockEssenceTier5;
    public static ItemStack blockEssenceTier6;


    public static ItemStack itemFertilizedEssence;

    // Mystical Agradditions
    public static ItemStack itemInsaniumIngot;
    public static ItemStack itemInsaniumNugget;
    public static ItemStack itemInsaniumEssence;

    // Industrial Parts
    public static ItemStack itemIUMichalov;
    public static ItemStack itemIUVanadium;
    public static ItemStack itemIUCaravky;
    public static ItemStack itemIUChromium;
    public static ItemStack itemIUSpinel;
    public static ItemStack itemIUGermanium;

    // Nuclear Craft
    public static ItemStack itemBerylliumIngot;
    public static ItemStack itemZirconiumIngot;

    private static ItemStack getItemFromOre(String ore) {
        try {
            return OreDictionary.getOres(ore, false).get(0);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return ItemStack.EMPTY;
    }

    public static void init() {
        itemFertilizedEssence = new ItemStack(ModItems.itemFertilizedEssence, 1, 0);

        ModMetaPart.init();

        if (ModChecker.GERMANIUM)
            itemIUGermanium = getItemFromOre("ingotGermanium");
        if (ModChecker.SPINEL)
            itemIUSpinel = getItemFromOre("ingotSpinel");
        if (ModChecker.CHROMIUM)
            itemIUChromium = getItemFromOre("ingotChromium");
        if (ModChecker.CARAVKY)
            itemIUCaravky = getItemFromOre("ingotCaravky");
        if (ModChecker.VANADIUM)
            itemIUVanadium = getItemFromOre("ingotVanadium");
        if (ModChecker.MICHALOV)
            itemIUMichalov = getItemFromOre("ingotMichalovm");
        if (ModChecker.BERYLLIUM)
            itemBerylliumIngot = getItemFromOre("ingotBeryllium");
        if (ModChecker.ZIRCONIUM)
            itemZirconiumIngot = getItemFromOre("ingotZirconium");

        blockEssenceTier2 = getItemFromOre("blockPrudentiumEssence");
        blockEssenceTier3 = getItemFromOre("blockIntermediumEssence");
        blockEssenceTier4 = getItemFromOre("blockSuperiumEssence");
        blockEssenceTier5 = getItemFromOre("blockSupremiumEssence");

        if (ModChecker.INSANIUM) {
            itemInsaniumIngot = getItemFromOre("ingotInsanium");
            itemInsaniumNugget = getItemFromOre("nuggetInsanium");
            itemInsaniumEssence = getItemFromOre("essenceInsanium");
            blockEssenceTier6 = getItemFromOre("blockInsaniumEssence");
        }
    }
}