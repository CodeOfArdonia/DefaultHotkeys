package com.iafenvoy.dhks.mixin;

import com.iafenvoy.dhks.KeyConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Environment(EnvType.CLIENT)
@Mixin(KeyBinding.class)
public class KeyBindingMixin {
    @Unique
    private static String defaultHotkeys$currentTranslation;

    @ModifyVariable(method = "<init>(Ljava/lang/String;Lnet/minecraft/client/util/InputUtil$Type;ILjava/lang/String;)V", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static String beforeInit(String translation) {
        defaultHotkeys$currentTranslation = translation;
        return translation;
    }

    @ModifyVariable(method = "<init>(Ljava/lang/String;Lnet/minecraft/client/util/InputUtil$Type;ILjava/lang/String;)V", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static int beforeInit(int code) {
        return KeyConfig.find(defaultHotkeys$currentTranslation, code, "");
    }
}
