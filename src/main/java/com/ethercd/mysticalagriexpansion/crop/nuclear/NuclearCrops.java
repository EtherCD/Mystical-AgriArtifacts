package com.ethercd.mysticalagriexpansion.crop.nuclear;

import com.ethercd.mysticalagriexpansion.config.ModConfig;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModMetaPart;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "CallToPrintStackTrace"})
public class NuclearCrops {
    public static NuclearCrop cropPlutoniumGem;
    public static NuclearCrop cropAmericiumGem;
    public static NuclearCrop cropNeptuniumGem;
    public static NuclearCrop cropCuriumGem;
    public static NuclearCrop cropCaliforniumGem;
    public static NuclearCrop cropMendeleviumGem;
    public static NuclearCrop cropBerkeliumGem;
    public static NuclearCrop cropEinsteiniumGem;
    public static NuclearCrop cropPlutonium;
    public static NuclearCrop cropUranium235;
    public static NuclearCrop cropUranium233;
    public static NuclearCrop cropThorium230;
    public static NuclearCrop cropThorium232;
    public static NuclearCrop cropPlutonium238;
    public static NuclearCrop cropPlutonium239;
    public static NuclearCrop cropPlutonium241;
    public static NuclearCrop cropPlutonium242;
    public static NuclearCrop cropNeptunium236;
    public static NuclearCrop cropNeptunium237;
    public static NuclearCrop cropAmericium241;
    public static NuclearCrop cropAmericium242;
    public static NuclearCrop cropAmericium243;
    public static NuclearCrop cropCurium243;
    public static NuclearCrop cropCurium245;
    public static NuclearCrop cropCurium246;
    public static NuclearCrop cropCurium247;
    public static NuclearCrop cropBerkelium247;
    public static NuclearCrop cropBerkelium248;
    public static NuclearCrop cropCalifornium249;
    public static NuclearCrop cropCalifornium250;
    public static NuclearCrop cropCalifornium251;
    public static NuclearCrop cropCalifornium252;

    public static final List<NuclearCrop> NUCLEAR_CROP_LIST = new ArrayList<>();

    static {
        cropAmericiumGem    = new NuclearCrop("americium_gem", 4, 0, 0, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropNeptuniumGem    = new NuclearCrop("neptunium_gem", 4, 1, 1, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropCuriumGem       = new NuclearCrop("curium_gem", 5, 2, 2, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropCaliforniumGem  = new NuclearCrop("californium_gem", 5, 3, 3, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropMendeleviumGem  = new NuclearCrop("mendelevium_gem", 5, 5, 5, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropBerkeliumGem    = new NuclearCrop("berkelium_gem", 4, 6, 6, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropEinsteiniumGem  = new NuclearCrop("einsteinium_gem", 5, 7, 7, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropPlutonium       = new NuclearCrop("plutonium", 4, 3, 7, ModConfig.integrationIndustrialCraft2 && ModChecker.INDUSTRIAL_CRAFT_2, ModMetaPart.IC2_NUCLEAR);
        if (!ModChecker.NUCLEAR_CRAFT)
            cropUranium235  = new NuclearCrop("uranium_235", 3, 1, 5, ModConfig.integrationIndustrialCraft2 && ModChecker.INDUSTRIAL_CRAFT_2, ModMetaPart.IC2_NUCLEAR);
        else
            cropUranium235  = new NuclearCrop("uranium_235", 3, 4, 6, ModConfig.integrationNuclearCraft, ModMetaPart.NC_URANIUM);
        cropUranium233      = new NuclearCrop("uranium_233", 4, 0, 2, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_URANIUM);
        cropThorium230      = new NuclearCrop("thorium_230", 4, 0, 2, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_THROIUM);
        cropThorium232      = new NuclearCrop("thorium_232", 2, 4, 6, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_THROIUM);
        cropPlutonium238    = new NuclearCrop("plutonium_238", 5, 0, 2, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_PLUTONIUM);
        cropPlutonium239    = new NuclearCrop("plutonium_239", 4, 4, 6, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_PLUTONIUM);
        cropPlutonium241    = new NuclearCrop("plutonium_241", 5, 8, 10, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_PLUTONIUM);
        cropPlutonium242    = new NuclearCrop("plutonium_242", 3, 12, 14, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_PLUTONIUM);
        cropNeptunium236    = new NuclearCrop("neptunium_236", 4, 0, 2, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_NEPTUNIUM);
        cropNeptunium237    = new NuclearCrop("neptunium_237", 3, 4, 6, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_NEPTUNIUM);
        cropAmericium241    = new NuclearCrop("americium_241", 4, 0, 2, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_AMERICIUM);
        cropAmericium242    = new NuclearCrop("americium_242", 5, 4, 6, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_AMERICIUM);
        cropAmericium243    = new NuclearCrop("americium_243", 4, 8, 10, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_AMERICIUM);
        cropCurium243       = new NuclearCrop("curium_243", 5, 0, 2, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CURIUM);
        cropCurium245       = new NuclearCrop("curium_245", 4, 4, 6, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CURIUM);
        cropCurium246       = new NuclearCrop("curium_246", 4, 8, 10, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CURIUM);
        cropCurium247       = new NuclearCrop("curium_247", 3, 12, 14, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CURIUM);
        cropBerkelium247    = new NuclearCrop("berkelium_247", 4, 0, 2, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_BERKELIUM);
        cropBerkelium248    = new NuclearCrop("berkelium_248", 4, 4, 6, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_BERKELIUM);
        cropCalifornium249  = new NuclearCrop("californium_249", 4, 0, 2, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CALIFORNIUM);
        cropCalifornium250  = new NuclearCrop("californium_250", 5, 4, 6, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CALIFORNIUM);
        cropCalifornium251  = new NuclearCrop("californium_251", 4, 8, 10, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CALIFORNIUM);
        cropCalifornium252  = new NuclearCrop("californium_252", 5, 12, 14, ModConfig.integrationNuclearCraft && ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CALIFORNIUM);
    }

    public static void register() {
        if (ModConfig.nuclearCropsActive)
            for (NuclearCrop crop : NuclearCrops.NUCLEAR_CROP_LIST) {
                crop.init();
            }
    }

    public static void registerRecipes() {
        if (ModConfig.nuclearCropsActive)
            for (NuclearCrop crop : NuclearCrops.NUCLEAR_CROP_LIST) {
                try {
                    crop.initRecipe();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
}