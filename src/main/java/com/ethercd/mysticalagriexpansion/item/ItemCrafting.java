package com.ethercd.mysticalagriexpansion.item;

import com.ethercd.mysticalagriexpansion.config.ModConfig;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;

@SuppressWarnings({"unused"})
public enum ItemCrafting {
    INSANIUM_THEORETICAL_WATER("insanium_theoretical_water", "", ModConfig.integrationMysticalAgradditions && ModChecker.INSANIUM),
    INSANIUM_FERT_CORE("insanium_fert_core", "", ModConfig.integrationMysticalAgradditions &&  ModChecker.INSANIUM),
    EXEMPLARY_GEAR("exemplary_gear", "gearExemplary", true),

    ELECTRONIC_SEEDS("electronic_seeds", "seedsElectronic", true),
    NUCLEAR_SEEDS("nuclear_seeds", "seedsNuclear", true),
    ALLOY_SEEDS("alloy_seeds", "seedsAlloy", true),

    TIER_1_ELECTRONIC_SEEDS("tier_1_electronic_seeds", "", true),
    TIER_1_NUCLEAR_SEEDS("tier_1_nuclear_seeds", "", true),
    TIER_1_ALLOY_SEEDS("tier_1_alloy_seeds", "", true),
    TIER_2_ELECTRONIC_SEEDS("tier_2_electronic_seeds", "", true),
    TIER_2_NUCLEAR_SEEDS("tier_2_nuclear_seeds", "", true),
    TIER_2_ALLOY_SEEDS("tier_2_alloy_seeds", "", true),
    TIER_3_ELECTRONIC_SEEDS("tier_3_electronic_seeds", "", true),
    TIER_3_NUCLEAR_SEEDS("tier_3_nuclear_seeds", "", true),
    TIER_3_ALLOY_SEEDS("tier_3_alloy_seeds", "", true),
    TIER_4_ELECTRONIC_SEEDS("tier_4_electronic_seeds", "", true),
    TIER_4_NUCLEAR_SEEDS("tier_4_nuclear_seeds", "", true),
    TIER_4_ALLOY_SEEDS("tier_4_alloy_seeds", "", true),
    TIER_5_ELECTRONIC_SEEDS("tier_5_electronic_seeds", "", true),
    TIER_5_NUCLEAR_SEEDS("tier_5_nuclear_seeds", "", true),
    TIER_5_ALLOY_SEEDS("tier_5_alloy_seeds", "", true),
    TIER_6_ELECTRONIC_SEEDS("tier_6_electronic_seeds", "", ModConfig.integrationMysticalAgradditions && ModChecker.INSANIUM),
    TIER_6_NUCLEAR_SEEDS("tier_6_nuclear_seeds", "", ModConfig.integrationMysticalAgradditions && ModChecker.INSANIUM),
    TIER_6_ALLOY_SEEDS("tier_6_alloy_seeds", "", ModConfig.integrationMysticalAgradditions && ModChecker.INSANIUM),

    MUTAGENESIS_CORE("mutagenesis_core", "", true),
    ;

    private final ModItem item;
    private final Boolean active;
    private final String name;

    ItemCrafting(String name, String ore, Boolean active) {
        this.item = new ModItem(name);
        this.active = active;
        this.name = name;
    }

    public ModItem getItem() {
        return item;
    }

    public static void register() {
        for (ItemCrafting item : ItemCrafting.values()) {
            if (item.active) {
                ModItems.add(item.item, item.name);
            }
        }
    }
}
