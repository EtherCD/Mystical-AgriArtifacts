package com.ethercd.mysticalagriexpansion.item;

import com.ethercd.mysticalagriexpansion.MACreativeTabs;
import net.minecraft.item.Item;

@SuppressWarnings({"unused"})
public class ModItem extends Item {
    private final String name;

    public ModItem(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MACreativeTabs.CREATIVE_TAB);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
