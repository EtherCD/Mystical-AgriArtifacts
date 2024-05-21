package com.ethercd.mysticalagriexpansion.proxy;


import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import com.ethercd.mysticalagriexpansion.block.ModBlocks;
import com.ethercd.mysticalagriexpansion.config.ModConfig;
import com.ethercd.mysticalagriexpansion.crop.ModCrops;
import com.ethercd.mysticalagriexpansion.gui.GuiHandler;
import com.ethercd.mysticalagriexpansion.integration.nc.ModRadSources;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import com.ethercd.mysticalagriexpansion.recipes.ModRecipes;
import com.ethercd.mysticalagriexpansion.te.ModTileEntities;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.io.File;

@SuppressWarnings({"unused", "super"})
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        ModConfig.init(new File(event.getModConfigurationDirectory(), "mysticalagriexpansion.cfg"));
        NetworkRegistry.INSTANCE.registerGuiHandler(MysticalAgriexpansion.instance, new GuiHandler());

        ModCrops.register();
        ModItems.register();
        ModBlocks.register();
    }

    public void init(FMLInitializationEvent event) {
        ModTileEntities.init();
        ModParts.init();
        ModRecipes.register();
        if (ModChecker.NUCLEAR_CRAFT && ModConfig.integrationRadiationFromNuclearCraft)
            ModRadSources.init();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
