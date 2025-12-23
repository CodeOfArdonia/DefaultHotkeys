package com.iafenvoy.dhks.mixin;

import com.iafenvoy.dhks.KeyConfig;
import net.minecraft.server.packs.resources.ReloadInstance;
import net.minecraft.server.packs.resources.SimpleReloadInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SimpleReloadInstance.class)
public class SimpleReloadInstanceMixin {
    @Inject(method = "create", at = @At("RETURN"))
    private static void afterReload(CallbackInfoReturnable<ReloadInstance> cir) {
        KeyConfig.save();
    }
}
