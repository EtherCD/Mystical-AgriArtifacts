package com.ethercd.mysticalagriexpansion.integration.nc;

import com.ethercd.mysticalagriexpansion.crop.nuclear.NuclearCrop;
import com.ethercd.mysticalagriexpansion.crop.nuclear.NuclearCrops;
import nc.radiation.RadSources;

public class ModRadSources {
    public static void addNuclearCrop(double radiation, NuclearCrop nc) {
        RadSources.put(radiation / 9D, nc.getPlant());
        RadSources.put(radiation / 9D, nc.getSeed());
        RadSources.put(radiation / 9D, nc.getCrop());
    }

    public static void init() {
        try {
            addNuclearCrop(RadSources.URANIUM_235, NuclearCrops.cropUranium235);
            addNuclearCrop(RadSources.URANIUM_233, NuclearCrops.cropUranium233);
//            addNuclearCrop(RadSources.THORIUM, NuclearCrops.cropThorium230);
//            addNuclearCrop(RadSources.THORIUM_232, NuclearCrops.cropThorium232);
            addNuclearCrop(RadSources.PLUTONIUM_238, NuclearCrops.cropPlutonium238);
            addNuclearCrop(RadSources.PLUTONIUM_239, NuclearCrops.cropPlutonium239);
            addNuclearCrop(RadSources.PLUTONIUM_241, NuclearCrops.cropPlutonium241);
            addNuclearCrop(RadSources.PLUTONIUM_242, NuclearCrops.cropPlutonium242);
            addNuclearCrop(RadSources.NEPTUNIUM_236, NuclearCrops.cropNeptunium236);
            addNuclearCrop(RadSources.NEPTUNIUM_237, NuclearCrops.cropNeptunium237);
            addNuclearCrop(RadSources.AMERICIUM_241, NuclearCrops.cropAmericium241);
            addNuclearCrop(RadSources.AMERICIUM_242, NuclearCrops.cropAmericium242);
            addNuclearCrop(RadSources.AMERICIUM_243, NuclearCrops.cropAmericium243);
            addNuclearCrop(RadSources.CURIUM_243, NuclearCrops.cropCurium243);
            addNuclearCrop(RadSources.CURIUM_245, NuclearCrops.cropCurium245);
            addNuclearCrop(RadSources.CURIUM_246, NuclearCrops.cropCurium246);
            addNuclearCrop(RadSources.CURIUM_247, NuclearCrops.cropCurium247);
            addNuclearCrop(RadSources.BERKELIUM_247, NuclearCrops.cropBerkelium247);
            addNuclearCrop(RadSources.BERKELIUM_248, NuclearCrops.cropBerkelium248);
            addNuclearCrop(RadSources.CALIFORNIUM_249, NuclearCrops.cropCalifornium249);
            addNuclearCrop(RadSources.CALIFORNIUM_250, NuclearCrops.cropCalifornium250);
            addNuclearCrop(RadSources.CALIFORNIUM_251, NuclearCrops.cropCalifornium251);
            addNuclearCrop(RadSources.CALIFORNIUM_252, NuclearCrops.cropCalifornium252);
            addNuclearCrop(RadSources.PLUTONIUM, NuclearCrops.cropPlutonium);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
