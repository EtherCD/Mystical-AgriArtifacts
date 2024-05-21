package com.ethercd.mysticalagriexpansion.config;

import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ModConfig {
    public static Configuration config;
    public static ModConfig instance;

    public static boolean nuclearCropsActive;
    public static boolean alloyCropsActive;
//    public static boolean electricalCropsActive;

    public static boolean integrationIndustrialUpgrade;
    public static boolean integrationNuclearCraft;
    public static boolean integrationIndustrialCraft2;
    public static boolean integrationMysticalAgradditions;

    public static boolean integrationRadiationFromNuclearCraft;

    public static boolean growthAcceleratorsActive;

    public static boolean growthAcceleratorTier2;
    public static boolean growthAcceleratorTier3;
    public static boolean growthAcceleratorTier4;
    public static boolean growthAcceleratorTier5;
    public static boolean growthAcceleratorTier6;

    public static int growthAcceleratorTier2Coef;
    public static int growthAcceleratorTier3Coef;
    public static int growthAcceleratorTier4Coef;
    public static int growthAcceleratorTier5Coef;
    public static int growthAcceleratorTier6Coef;

    public static boolean mutagenesisProcessors;

    public static boolean mutagenesisProcessorTier1;
    public static boolean mutagenesisProcessorTier2;
    public static boolean mutagenesisProcessorTier3;
    public static boolean mutagenesisProcessorTier4;
    public static boolean mutagenesisProcessorTier5;
    public static boolean mutagenesisProcessorTier6;

    public static int mutagenesisProcessorTier1OperationTime;
    public static int mutagenesisProcessorTier2OperationTime;
    public static int mutagenesisProcessorTier3OperationTime;
    public static int mutagenesisProcessorTier4OperationTime;
    public static int mutagenesisProcessorTier5OperationTime;
    public static int mutagenesisProcessorTier6OperationTime;

    public static float mutagenesisProcessorTier1ChanceMultiplier;
    public static float mutagenesisProcessorTier2ChanceMultiplier;
    public static float mutagenesisProcessorTier3ChanceMultiplier;
    public static float mutagenesisProcessorTier4ChanceMultiplier;
    public static float mutagenesisProcessorTier5ChanceMultiplier;
    public static float mutagenesisProcessorTier6ChanceMultiplier;


    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(MysticalAgriexpansion.MOD_ID)) {
            ModConfig.syncConfig();
        }
    }

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {
        String category;

        category = "Integrations";
        config.addCustomCategoryComment(category, "Controlling all mod integrations");
        integrationMysticalAgradditions = config.getBoolean("integration_mystical_agradditions", category, true, "Integration with modification 'Mystical Agradditions'");
        integrationIndustrialUpgrade = config.getBoolean("integration_industrial_upgrade", category, true, "Integration with modification 'Industrial Upgrade'");
        integrationIndustrialCraft2 = config.getBoolean("integration_industrial_craft_2", category, true, "Integration with modification 'Industrial Craft 2'");
        integrationNuclearCraft = config.getBoolean("integration_nuclear_craft", category, true, "Integration with modification 'Nuclear Craft'");
        integrationRadiationFromNuclearCraft = config.getBoolean("integration_radiation_nuclear_craft", category, false, "Integration with radiation from modification 'Nuclear Craft'");

        category = "Growth Accelerators";
        growthAcceleratorTier2 = config.getBoolean("growth_accelerator_tier_2", category, true, "Enables growth accelerator tier 2 (prudentium)");
        growthAcceleratorTier3 = config.getBoolean("growth_accelerator_tier_3", category, true, "Enables growth accelerator tier 3 (intermedium)");
        growthAcceleratorTier4 = config.getBoolean("growth_accelerator_tier_4", category, true, "Enables growth accelerator tier 4 (superium)");
        growthAcceleratorTier5 = config.getBoolean("growth_accelerator_tier_5", category, true, "Enables growth accelerator tier 5 (supremium)");
        growthAcceleratorTier6 = config.getBoolean("growth_accelerator_tier_6", category, true, "Enables growth accelerator tier 6 (insanium). Is not working without 'Mystical Agradditions'");

        growthAcceleratorTier2Coef = config.getInt("growth_accelerator_tier_2_coef", category, 150, 100, 1000,"Coef of accelerate growth for tier 2 (prudentium, normal value 150)");
        growthAcceleratorTier3Coef = config.getInt("growth_accelerator_tier_3_coef", category, 200, 100, 1000,"Coef of accelerate growth for tier 3 (intermedium, normal value 200)");
        growthAcceleratorTier4Coef = config.getInt("growth_accelerator_tier_4_coef", category, 250, 100, 1000,"Coef of accelerate growth for tier 3 (superium, normal value 250)");
        growthAcceleratorTier5Coef = config.getInt("growth_accelerator_tier_5_coef", category, 300, 100, 1000,"Coef of accelerate growth for tier 3 (supremium, normal value 300)");
        growthAcceleratorTier6Coef = config.getInt("growth_accelerator_tier_6_coef", category, 500, 100, 1000,"Coef of accelerate growth for tier 3 (insanium, normal value 500)");

        category = "Mutagenesis Processors";
        mutagenesisProcessors = config.getBoolean("mutagenesis_processors", category, true, "Enables mutagenesis processors");

        mutagenesisProcessorTier1 = config.getBoolean("mutagenesis_processor_tier_1", category, true, "Enables mutagenesis processor tier 1 (inferium)");
        mutagenesisProcessorTier2 = config.getBoolean("mutagenesis_processor_tier_2", category, true, "Coef of accelerate growth for tier 2 (prudentium)");
        mutagenesisProcessorTier3 = config.getBoolean("mutagenesis_processor_tier_3", category, true, "Coef of accelerate growth for tier 3 (intermedium)");
        mutagenesisProcessorTier4 = config.getBoolean("mutagenesis_processor_tier_4", category, true, "Coef of accelerate growth for tier 4 (superium)");
        mutagenesisProcessorTier5 = config.getBoolean("mutagenesis_processor_tier_5", category, true, "Coef of accelerate growth for tier 5 (supremium)");
        mutagenesisProcessorTier6 = config.getBoolean("mutagenesis_processor_tier_6", category, true, "Coef of accelerate growth for tier 6 (insanium). Is not working without 'Mystical Agradditions'");

        mutagenesisProcessorTier1OperationTime = config.getInt("mutagenesis_processor_tier_1_operation_time", category, 1000, 1, 100000, "Time during which the process will be completed (1000 default)");
        mutagenesisProcessorTier2OperationTime = config.getInt("mutagenesis_processor_tier_2_operation_time", category, 850, 1, 100000, "Time during which the process will be completed (850 default)");
        mutagenesisProcessorTier3OperationTime = config.getInt("mutagenesis_processor_tier_3_operation_time", category, 650, 1, 100000, "Time during which the process will be completed (650 default)");
        mutagenesisProcessorTier4OperationTime = config.getInt("mutagenesis_processor_tier_4_operation_time", category, 350, 1, 100000, "Time during which the process will be completed (350 default)");
        mutagenesisProcessorTier5OperationTime = config.getInt("mutagenesis_processor_tier_5_operation_time", category, 150, 1, 100000, "Time during which the process will be completed (150 default)");
        mutagenesisProcessorTier6OperationTime = config.getInt("mutagenesis_processor_tier_6_operation_time", category, 75, 1, 100000, "Time during which the process will be completed (75 default)");

        mutagenesisProcessorTier1ChanceMultiplier = config.getFloat("mutagenesis_processor_tier_1_chance_multiplier", category, 1.0f, 0.1f, 100.f, "Chance multiplier for which the process will end with the creation of new seeds (1.0 default)");
        mutagenesisProcessorTier2ChanceMultiplier = config.getFloat("mutagenesis_processor_tier_2_chance_multiplier", category, 1.25f, 0.1f, 100.f, "Chance multiplier for which the process will end with the creation of new seeds (1.25 default)");
        mutagenesisProcessorTier3ChanceMultiplier = config.getFloat("mutagenesis_processor_tier_3_chance_multiplier", category, 1.5f, 0.1f, 100.f, "Chance multiplier for which the process will end with the creation of new seeds (1.5 default)");
        mutagenesisProcessorTier4ChanceMultiplier = config.getFloat("mutagenesis_processor_tier_4_chance_multiplier", category, 1.75f, 0.1f, 100.f, "Chance multiplier for which the process will end with the creation of new seeds (1.75 default)");
        mutagenesisProcessorTier5ChanceMultiplier = config.getFloat("mutagenesis_processor_tier_5_chance_multiplier", category, 2f, 0.1f, 100.f, "Chance multiplier for which the process will end with the creation of new seeds (2.0 default)");
        mutagenesisProcessorTier6ChanceMultiplier = config.getFloat("mutagenesis_processor_tier_6_chance_multiplier", category, 3f, 0.1f, 100.f, "Chance multiplier for which the process will end with the creation of new seeds (3.0 default)");

        if (config.hasChanged()) {
            config.save();
        }
    }

}
