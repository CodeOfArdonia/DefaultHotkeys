package com.iafenvoy.dhks.impl.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class LoaderPlatformImpl {
    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
