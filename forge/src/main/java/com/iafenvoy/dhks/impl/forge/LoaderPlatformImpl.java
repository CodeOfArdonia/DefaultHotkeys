package com.iafenvoy.dhks.impl.forge;

import net.minecraftforge.fml.ModList;

public class LoaderPlatformImpl {
    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}
