package com.ethercd.mysticalagriexpansion.crop;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.crafting.ReprocessorManager;
import com.ethercd.mysticalagriexpansion.crop.alloy.AlloyCrops;
import com.ethercd.mysticalagriexpansion.crop.nuclear.NuclearCrops;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.lib.ModMetaPart;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import com.ethercd.mysticalagriexpansion.recipes.ModRecipes;
import net.minecraft.item.ItemStack;

@SuppressWarnings({"unused", "CallToPrintStackTrace"})
public enum CropsRecipe {
    PROSPERITY_CROP(CommonCrop.PROSPERITY, ModRecipes.ShapeEssenceRecipe.RHOMBUS, ModParts.itemProsperityShard, ModParts.itemProsperityShard),
    MECHANICAL_CROP(CommonCrop.MECHANICAL, ModRecipes.ShapeEssenceRecipe.STAR, new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0), new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0)),
    BERYLLIUM_CROP(CommonCrop.BERYLLIUM, ModRecipes.ShapeEssenceRecipe.FULL, ModParts.itemBerylliumIngot, ModParts.itemBerylliumIngot),
    ZIRCONIUM_CROP(CommonCrop.ZIRCONIUM, ModRecipes.ShapeEssenceRecipe.FULL, ModParts.itemZirconiumIngot, ModParts.itemZirconiumIngot),
    PROTON_CROP(CommonCrop.PROTON, ModRecipes.ShapeEssenceRecipe.FULL, ModMetaPart.IU_PROTON, 0),
    THORIUM_CROP(CommonCrop.THORIUM, ModRecipes.ShapeEssenceRecipe.FULL, ModMetaPart.IU_THORIUM, 0),
    MICHALOV_CROP(CommonCrop.MICHALOV, ModRecipes.ShapeEssenceRecipe.FULL, ModMetaPart.IU_INGOTS, 0),
    VANADIUM_CROP(CommonCrop.VANADIUM, ModRecipes.ShapeEssenceRecipe.FULL, ModParts.itemIUVanadium, ModParts.itemIUVanadium),
    CARAVKY_CROP(CommonCrop.CARAVKY, ModRecipes.ShapeEssenceRecipe.FULL, ModMetaPart.IU_INGOTS, 5),
    CHROMIUM_CROP(CommonCrop.CHROMIUM, ModRecipes.ShapeEssenceRecipe.FULL, ModParts.itemIUChromium, ModParts.itemIUChromium),
    SPINEL_CROP(CommonCrop.SPINEL, ModRecipes.ShapeEssenceRecipe.FULL, ModParts.itemIUSpinel, ModParts.itemIUSpinel),
    GERMANIUM_CROP(CommonCrop.GERMANIUM, ModRecipes.ShapeEssenceRecipe.FULL, ModParts.itemIUGermanium, ModParts.itemIUGermanium),
    COBALT_IU_CROP(CommonCrop.COBALT_IU, ModRecipes.ShapeEssenceRecipe.FULL, ModMetaPart.IU_INGOTS, 6),
    ;

    private final CommonCrop crop;
    private final ModRecipes.ShapeEssenceRecipe shape;
    private ItemStack output;
    private ItemStack madeOf;
    private int meta = -1;
    private ModMetaPart made;

    CropsRecipe(CommonCrop crop,
                // Essence to something recipe
                ModRecipes.ShapeEssenceRecipe shape, ItemStack output,
                // Recipe to made seed
                ItemStack madeOf
    )
    {
        this.crop = crop;
        this.shape = shape;
        this.output = output;
        this.madeOf = madeOf;
    }

    CropsRecipe(CommonCrop crop,
                // Essence to something recipe
                ModRecipes.ShapeEssenceRecipe shape, ModMetaPart output,
                int meta
    )
    {
        this.crop = crop;
        this.shape = shape;
        this.made = output;
        this.meta = meta;
    }

    public void initRecipe() {
        if (crop.isEnabled() && output != null && madeOf != null) {
            ItemStack output;
            ItemStack madeOf;
            if (meta >= 0) {
                output = new ItemStack(made.getItem(), 1, meta);
                madeOf = new ItemStack(made.getItem(), 1, meta);
            } else {
                output = this.output;
                madeOf = this.madeOf;
            }

            RecipeHelper.addShapedRecipe(output,
                    shape.getShape()[0],
                    shape.getShape()[1],
                    shape.getShape()[2],
                    'E',
                    new ItemStack(crop.getCrop(),
                            1,
                            0));

            ItemStack tierInferiumEssence;
            ItemStack tierCraftingSeeds;

            switch (this.crop.getTier()) {
                default:
                case 1:
                    tierInferiumEssence = ModParts.itemTier1Essence;
                    tierCraftingSeeds = ModParts.itemTier1CraftingSeed;
                    break;
                case 2:
                    tierInferiumEssence = ModParts.itemTier2Essence;
                    tierCraftingSeeds = ModParts.itemTier2CraftingSeed;
                    break;
                case 3:
                    tierInferiumEssence = ModParts.itemTier3Essence;
                    tierCraftingSeeds = ModParts.itemTier3CraftingSeed;
                    break;
                case 4:
                    tierInferiumEssence = ModParts.itemTier4Essence;
                    tierCraftingSeeds = ModParts.itemTier4CraftingSeed;
                    break;
                case 5:
                    tierInferiumEssence = ModParts.itemTier5Essence;
                    tierCraftingSeeds = ModParts.itemTier5CraftingSeed;
                    break;
            }

            RecipeHelper.addShapedRecipe(new ItemStack(crop.getSeed(), 1, 0),
                    "PEP",
                    "ECE",
                    "PEP",
                    'P',
                    madeOf,
                    'E',
                    tierInferiumEssence,
                    'C',
                    tierCraftingSeeds);

            ReprocessorManager.addRecipe(new ItemStack(this.crop.getCrop(), 2, 0), new ItemStack(this.crop.getSeed(), 1, 0));
        }
    }

    public static void register() {
        for (CropsRecipe recipe : CropsRecipe.values()) {
            try {
                recipe.initRecipe();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            NuclearCrops.registerRecipes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            AlloyCrops.registerRecipes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
