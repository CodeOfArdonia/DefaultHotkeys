package com.iafenvoy.dhks.impl;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class LoaderPlatform {
    @ExpectPlatform
    public static boolean isModLoaded(String modId){
        throw new AssertionError("This method should be replaced by Architectury.");
    }
}
