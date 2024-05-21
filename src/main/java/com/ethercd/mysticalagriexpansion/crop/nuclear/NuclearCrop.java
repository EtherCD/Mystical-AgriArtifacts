package com.ethercd.mysticalagriexpansion.crop.nuclear;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.crafting.ReprocessorManager;
import com.ethercd.mysticalagriexpansion.MACreativeTabs;
import com.ethercd.mysticalagriexpansion.block.BlockCrop;
import com.ethercd.mysticalagriexpansion.block.ModBlocks;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.item.ItemSeed;
import com.ethercd.mysticalagriexpansion.item.ModItem;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.lib.ModMetaPart;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@SuppressWarnings({"unused"})
public class NuclearCrop {
    private final String name;
    private final boolean enabled;
    private final BlockCrop plant;
    private final int tier;
    private final ModItem crop;
    private final ItemSeed seed;

    private final int ingotMeta;
    private final int nuggetMeta;
    private final ModMetaPart metaItem;

    NuclearCrop(String name, int tier, int ingotMeta, int nuggetMeta, boolean enabled, ModMetaPart metaItem) {
        this.name = name;
        this.enabled = enabled;
        plant = new BlockCrop(getName() + "_crop");
        this.tier = tier;
        crop = (ModItem) new ModItem(getName() + "_essence")
                .setCreativeTab(MACreativeTabs.CREATIVE_TAB);
        seed = (ItemSeed) new ItemSeed(getName() + "_seeds", getPlant(), getTier())
                .setCreativeTab(MACreativeTabs.CREATIVE_TAB);
        if (this.enabled) {
            plant.setCrop(crop);
            plant.setSeed(seed);
            NuclearCrops.NUCLEAR_CROP_LIST.add(this);
        }
        this.ingotMeta = ingotMeta;
        this.nuggetMeta = nuggetMeta;
        this.metaItem = metaItem;
    }

    public ItemSeed getSeed() {
        return seed;
    }

    public ModItem getCrop() {
        return crop;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

    public BlockCrop getPlant() {
        return plant;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void init() {
        if (enabled) {
            ModItems.add(seed, getName() + "_seeds");
            ModItems.add(crop, getName() + "_essence");
            ModBlocks.add(plant, getName() + "_crop");
        }
    }

    public void initRecipe() {
        if (enabled && metaItem.isLoaded()) {
            Item metaItem = this.metaItem.getItem();

            ItemStack materialIn = new ItemStack(metaItem, 1, ingotMeta);
            ItemStack materialOut = new ItemStack(metaItem, 1, nuggetMeta);

            RecipeHelper.addShapedRecipe(materialOut,
                    "EEE",
                    "EEE",
                    "EEE",
                    'E',
                    new ItemStack(crop,
                            1,
                            0));

            ItemStack tierInferiumEssence;
            ItemStack tierCraftingSeeds;

            switch (this.tier) {
                default:
                case 1:
                    tierInferiumEssence = ModParts.itemTier1Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_1_NUCLEAR_SEEDS.getItem(), 1, 0);
                    break;
                case 2:
                    tierInferiumEssence = ModParts.itemTier2Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_2_NUCLEAR_SEEDS.getItem(), 1, 0);
                    break;
                case 3:
                    tierInferiumEssence = ModParts.itemTier3Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_3_NUCLEAR_SEEDS.getItem(), 1, 0);
                    break;
                case 4:
                    tierInferiumEssence = ModParts.itemTier4Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_4_NUCLEAR_SEEDS.getItem(), 1, 0);
                    break;
                case 5:
                    tierInferiumEssence = ModParts.itemTier5Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_5_NUCLEAR_SEEDS.getItem(), 1, 0);
                    break;
            }

            RecipeHelper.addShapedRecipe(new ItemStack(seed, 1, 0),
                    "PEP",
                    "ECE",
                    "PEP",
                    'P',
                    materialIn,
                    'E',
                    tierInferiumEssence,
                    'C',
                    tierCraftingSeeds);
            ReprocessorManager.addRecipe(new ItemStack(crop, 2, 0), new ItemStack(seed, 1, 0));
        }
    }
}