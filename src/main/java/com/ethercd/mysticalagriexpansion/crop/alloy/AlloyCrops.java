package com.ethercd.mysticalagriexpansion.crop.alloy;

import com.ethercd.mysticalagriexpansion.config.ModConfig;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModMetaPart;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "CallToPrintStackTrace"})
public class AlloyCrops {
    public static AlloyCrop cropTough;
    public static AlloyCrop cropHardCarbon;
    public static AlloyCrop cropMagnesiumDiboride;
    public static AlloyCrop cropManganeseDioxide;
    public static AlloyCrop cropHslaSteel;
    public static AlloyCrop cropFerroboron;
    public static AlloyCrop cropShibuichi;
    public static AlloyCrop cropTinSilver;
    public static AlloyCrop cropExtreme;
    public static AlloyCrop cropThermoconducting;
    public static AlloyCrop cropZircaloy;
    public static AlloyCrop cropSiliconCarbide;
    public static AlloyCrop cropAluminumBronze;
    public static AlloyCrop cropTitaniumAluminide;
    public static AlloyCrop cropRedBrass;
    public static AlloyCrop cropMuntzMetal;
    public static AlloyCrop cropNichrome;
    public static AlloyCrop cropAlcald;
    public static AlloyCrop cropVanadiumAluminum;
    public static AlloyCrop cropVitallium;
    public static AlloyCrop cropDuralumin;
    public static AlloyCrop cropFerromanganese;

    public static final List<AlloyCrop> ALLOY_CROP_LIST = new ArrayList<>();

    static {
        cropTough               = new AlloyCrop("tough", 5, 1, 1, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropHardCarbon          = new AlloyCrop("hard_carbon", 5, 2, 2, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropMagnesiumDiboride   = new AlloyCrop("magnesium_diboride", 5, 3, 3, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropManganeseDioxide    = new AlloyCrop("manganese_dioxide", 5, 4, 4, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropHslaSteel           = new AlloyCrop("hsla_steel", 5, 5, 5, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropFerroboron          = new AlloyCrop("ferroboron", 5, 6, 6, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropShibuichi           = new AlloyCrop("shibuichi", 5, 7, 7, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropTinSilver           = new AlloyCrop("tin_silver", 5, 8, 8, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropExtreme             = new AlloyCrop("extreme", 5, 10, 10, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropThermoconducting    = new AlloyCrop("thermoconducting", 5, 11, 11, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropZircaloy            = new AlloyCrop("zircaloy", 5, 12, 12, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropSiliconCarbide      = new AlloyCrop("silicon_carbide", 5, 13, 13, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_ALLOY);
        cropAluminumBronze      = new AlloyCrop("aluminum_bronze", 5, 0, 0, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_ALLOY);
        cropTitaniumAluminide   = new AlloyCrop("titanium_aluminide", 5, 1, 1, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_ALLOY);
        cropRedBrass            = new AlloyCrop("red_brass", 5, 2, 2, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_ALLOY);
        cropMuntzMetal          = new AlloyCrop("muntz_metal", 5, 3, 3, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_ALLOY);
        cropNichrome            = new AlloyCrop("nichrome", 5, 4, 4, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_ALLOY);
        cropAlcald              = new AlloyCrop("alcald", 5, 5, 5, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_ALLOY);
        cropVanadiumAluminum    = new AlloyCrop("vanadium_aluminum", 5, 6, 6, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_ALLOY);
        cropVitallium           = new AlloyCrop("vitallium", 5, 7, 7, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_ALLOY);
        cropDuralumin           = new AlloyCrop("duralumin", 5, 8, 8, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_ALLOY);
        cropFerromanganese      = new AlloyCrop("ferromanganese", 5, 9, 9, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_ALLOY);
    }

    public static void register() {
        if (ModConfig.alloyCropsActive)
            for (AlloyCrop crop : AlloyCrops.ALLOY_CROP_LIST) {
                crop.init();
            }
    }

    public static void registerRecipes() {
        if (ModConfig.alloyCropsActive)
            for (AlloyCrop crop : AlloyCrops.ALLOY_CROP_LIST) {
                try {
                    crop.initRecipe();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
}
