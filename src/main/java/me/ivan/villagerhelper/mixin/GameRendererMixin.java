package me.ivan.villagerhelper.mixin;

import me.ivan.villagerhelper.VillagerHelper;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    // just like onRenderWorldLast in malilib
    @Inject(
            method = "renderCenter",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/client/render/GameRenderer;renderHand:Z"
            )
    )
    private void render(float tickDelta, long endTime, CallbackInfo ci) {
        VillagerHelper.getInstance().renderVillagerInfo(tickDelta);
    }
}
