package com.ethercd.mysticalagriexpansion.recipes;

import com.blakebr0.cucumber.helper.StackHelper;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.Random;

/**
 * Mutagenesis mechanism recipe manager
 */
@SuppressWarnings({"unused"})
public class MutagenesisRecipesManager {
    private static final Table<ItemStack, ItemStack, MutagenesisResult> recipesList = HashBasedTable.create();

    /**
     * Adds recipe to Mutagenesis Processor.
     * @param input1 Input first seeds
     * @param input2 Input second seeds
     * @param output Output seeds
     * @param chance Chance of successful mutation
     */
    public static void addRecipe(Item input1, Item input2, Item output, int chance) {
        ItemStack input1Stack = new ItemStack(input1, 1);
        ItemStack input2Stack = new ItemStack(input2, 1);
        ItemStack outputStack = new ItemStack(output, 1);
        if (getResult(input1Stack, input2Stack).getItem() != ItemStack.EMPTY) return;
        MutagenesisResult recipeResult = new MutagenesisResult(outputStack, chance);
        recipesList.put(input1Stack, input2Stack, recipeResult);
    }

    /**
     * Adds recipe to Mutagenesis Processor.
     * @param input1 Input first seeds
     * @param input2 Input second seeds
     * @param output Output seeds
     * @param chance Chance of successful mutation
     */
    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack output, int chance) {
        if (getResult(input1, input2).getItem() != ItemStack.EMPTY) return;
        recipesList.put(input1, input2, new MutagenesisResult(output, chance));
    }

    /**
     * Returns result from recipe
     * @param input1 Recipe input first slot
     * @param input2 Recipe inputs second slot
     * @return Result or ItemStack.EMPTY
     */
    public static MutagenesisResult getResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry<ItemStack, Map<ItemStack, MutagenesisResult>> entry : recipesList.columnMap().entrySet()) {
            if (input1.isItemEqual(entry.getKey()))
                for (Map.Entry<ItemStack, MutagenesisResult> ent : entry.getValue().entrySet())
                    if (input2.isItemEqual(ent.getKey()))
                        return ent.getValue();
            if (input2.isItemEqual(entry.getKey()))
                for (Map.Entry<ItemStack, MutagenesisResult> ent : entry.getValue().entrySet())
                    if (input1.isItemEqual(ent.getKey()))
                        return ent.getValue();
        }

        return new MutagenesisResult(ItemStack.EMPTY, 0);
    }

    /**
     * Getting ItemStack without meta
     * @param stack Stack
     * @return Result
     */
    public static ItemStack getStackWithoutMeta(ItemStack stack) {
        return new ItemStack(stack.getItem(), stack.getCount(), 0);
    }

    /**
     * Only for JEI Compat
     * @param input1, Recipe input stack
     * @param input2, Recipe input stack
     * @return Int chance of mutation
     */
    public static int getChance(ItemStack input1, ItemStack input2) {
        return getResult(input1, input2).getChance();
    }

    /**
     * Only for JEI Compat
     * @return All recipes
     */
    public static Table<ItemStack, ItemStack, MutagenesisResult> getRecipesList() {
        return recipesList;
    }
}
