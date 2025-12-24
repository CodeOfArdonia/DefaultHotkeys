package com.iafenvoy.dhks.mixin;

import com.iafenvoy.dhks.KeyConfig;
import net.minecraft.client.KeyMapping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(KeyMapping.class)
public class KeyMappingMixin {
    @Unique
    private static String defaultHotkeys$currentTranslation;

    //? >=1.21.9 {
    /*@ModifyVariable(method = "<init>(Ljava/lang/String;Lcom/mojang/blaze3d/platform/InputConstants$Type;ILnet/minecraft/client/KeyMapping$Category;)V", at = @At("HEAD"), ordinal = 0, argsOnly = true)
     *///?} else {
    @ModifyVariable(method = "<init>(Ljava/lang/String;Lcom/mojang/blaze3d/platform/InputConstants$Type;ILjava/lang/String;)V", at = @At("HEAD"), ordinal = 0, argsOnly = true)
            //?}
    private static String beforeInit(String translation) {
        defaultHotkeys$currentTranslation = translation;
        return translation;
    }

    //? >=1.21.9 {
    /*@ModifyVariable(method = "<init>(Ljava/lang/String;Lcom/mojang/blaze3d/platform/InputConstants$Type;ILnet/minecraft/client/KeyMapping$Category;)V", at = @At("HEAD"), ordinal = 0, argsOnly = true)
     *///?} else {
    @ModifyVariable(method = "<init>(Ljava/lang/String;Lcom/mojang/blaze3d/platform/InputConstants$Type;ILjava/lang/String;)V", at = @At("HEAD"), ordinal = 0, argsOnly = true)
            //?}
    private static int beforeInit(int code) {
        return KeyConfig.find(defaultHotkeys$currentTranslation, code, "");
    }
}
