package com.ethercd.mysticalagriexpansion.crop;

import com.ethercd.mysticalagriexpansion.block.BlockCrop;
import com.ethercd.mysticalagriexpansion.block.ModBlocks;
import com.ethercd.mysticalagriexpansion.config.ModConfig;
import com.ethercd.mysticalagriexpansion.item.ItemSeed;
import com.ethercd.mysticalagriexpansion.item.ModItem;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import net.minecraft.util.IStringSerializable;

@SuppressWarnings({"unused", "NullableProblems"})
public enum CommonCrop implements IStringSerializable {
    PROSPERITY("prosperity", 5, true),
    MECHANICAL("mechanical", 5, true),
    BERYLLIUM("beryllium", 4, ModChecker.BERYLLIUM),
    ZIRCONIUM("zirconium", 4, ModChecker.ZIRCONIUM),
    PROTON("proton", 5, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE),
    THORIUM("thorium_gem", 4, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE),
    MICHALOV("michalov", 4, ModConfig.integrationIndustrialUpgrade &&  ModChecker.INDUSTRIAL_UPGRADE),
    VANADIUM("vanadium", 4, ModChecker.VANADIUM),
    CARAVKY("caravky", 5, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE),
    CHROMIUM("chromium", 5, ModChecker.CHROMIUM),
    SPINEL("spinel", 4, ModChecker.SPINEL),
    GERMANIUM("germanium", 4, ModChecker.GERMANIUM),
    COBALT_IU("cobalt", 5, ModConfig.integrationIndustrialUpgrade && ModChecker.INDUSTRIAL_UPGRADE),
    ;

    private final String name;
    private final boolean enabled;
    private final BlockCrop plant;
    private final int tier;
    private final ModItem crop;
    private final ItemSeed seed;

    CommonCrop(String name, int tier, boolean enabled) {
        this.name = name;
        this.enabled = enabled;
        plant = new BlockCrop(getName() + "_crop");
        this.tier = tier;
        crop = new ModItem(getName() + "_essence");
        seed = new ItemSeed(getName() + "_seeds", getPlant(), getTier());
        if (this.enabled) {
            plant.setCrop(crop);
            plant.setSeed(seed);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public BlockCrop getPlant() {
        return plant;
    }

    public ModItem getCrop() {
        return crop;
    }

    public ItemSeed getSeed() {
        return seed;
    }

    public void init() {
        if (this.enabled) {
            ModItems.add(seed, getName() + "_seeds");
            ModItems.add(crop, getName() + "_essence");
            ModBlocks.add(plant, getName() + "_crop");
        }
    }

    public static void register() {
        for (CommonCrop crop : CommonCrop.values()) {
            crop.init();
        }
    }
}
