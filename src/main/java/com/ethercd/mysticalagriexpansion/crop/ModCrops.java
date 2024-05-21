package com.ethercd.mysticalagriexpansion.crop;

import com.ethercd.mysticalagriexpansion.config.ModConfig;
import com.ethercd.mysticalagriexpansion.crop.alloy.AlloyCrops;
import com.ethercd.mysticalagriexpansion.crop.nuclear.NuclearCrops;

public class ModCrops {
    public static void register() {
        CommonCrop.register();
        if (ModConfig.nuclearCropsActive)
            NuclearCrops.register();
        if (ModConfig.alloyCropsActive)
            AlloyCrops.register();
    }
}
