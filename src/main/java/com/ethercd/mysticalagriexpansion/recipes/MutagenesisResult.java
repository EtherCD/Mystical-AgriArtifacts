package com.ethercd.mysticalagriexpansion.recipes;

import net.minecraft.item.ItemStack;

import java.util.Random;

public class MutagenesisResult {
    private final ItemStack item;
    private final int chance;
    private final Random random;

    public MutagenesisResult(ItemStack item, int chance) {
        this.item = item;
        this.chance = chance;
        this.random = new Random();
    }

    public boolean getSuccess(float chanceMultiplier) {
        return random.nextInt(100) < 100 - Math.round(chance * chanceMultiplier);
    }

    public int getChance() {
        return chance;
    }

    public ItemStack getItem() {
        return item;
    }

}
