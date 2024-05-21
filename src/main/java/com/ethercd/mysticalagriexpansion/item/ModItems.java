package com.ethercd.mysticalagriexpansion.item;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import com.ethercd.mysticalagriexpansion.config.ModConfig;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.utils.RegisteredObject;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<RegisteredObject<Item>> ITEMS = new ArrayList<>();

    public static final ItemWateringCan itemInstaiumWateringCan = new ItemWateringCan("insanium", 13, 6, 0.5f);

    public static void add(Item item, String name) {
        ITEMS.add(new RegisteredObject<>(item, name));
    }

    public static void register() {
        ModRegistry registry = MysticalAgriexpansion.REGISTRY;

        ItemCrafting.register();

        if (ModConfig.integrationMysticalAgradditions && ModChecker.INSANIUM) {
            itemInstaiumWateringCan.register();
        }

        for (RegisteredObject<Item> elem : ITEMS) {
            registry.register(elem.getObject(), elem.getName());
        }
    }
}
