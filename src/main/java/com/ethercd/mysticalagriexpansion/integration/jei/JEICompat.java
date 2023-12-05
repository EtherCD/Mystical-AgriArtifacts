package com.ethercd.mysticalagriexpansion.integration.jei;

import com.ethercd.mysticalagriexpansion.gui.ContainerMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.gui.GuiMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.integration.jei.mutagenesis.MutagenesisRecipeCategory;
import com.ethercd.mysticalagriexpansion.integration.jei.mutagenesis.MutagenesisRecipeMaker;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IIngredientFilter;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.util.text.translation.I18n;

import java.util.IllegalFormatException;

@JEIPlugin
public class JEICompat implements IModPlugin {
    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        final IJeiHelpers helpers = registry.getJeiHelpers();
        final IGuiHelper gui = helpers.getGuiHelper();

        registry.addRecipeCategories(new MutagenesisRecipeCategory(gui));
    }

    @Override
    public void register(IModRegistry registry) {
        final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();

        registry.addRecipes(MutagenesisRecipeMaker.getRecipes(jeiHelpers), RecipeCategories.MUTAGENESIS);
        registry.addRecipeClickArea(GuiMutagenesisProcessor.class, 77, 42, 22, 15, RecipeCategories.MUTAGENESIS);
        recipeTransfer.addRecipeTransferHandler(ContainerMutagenesisProcessor.class, RecipeCategories.MUTAGENESIS, 0, 1, 2, 36);
    }

    public static String translateToLocal(String key) {
        if (I18n.canTranslate(key)) return I18n.translateToLocal(key);
        else return I18n.translateToFallback(key);
    }

    public static String translateToLocalFormatted(String key, Object... format) {
        String s =translateToLocal(key);
        try {
            return String.format(s, format);
        } catch (IllegalFormatException e) {
            return "Format error: "+e;
        }
    }
}
