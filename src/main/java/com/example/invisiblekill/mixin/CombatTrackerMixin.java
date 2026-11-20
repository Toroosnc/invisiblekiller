package com.example.invisiblekill.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.CombatTracker;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CombatTracker.class)
public abstract class CombatTrackerMixin {
    @Shadow
    @Final
    private LivingEntity mob;

    @Shadow
    public abstract LivingEntity getKiller();

    @Inject(method = "getDeathMessage", at = @At("RETURN"), cancellable = true)
    private void invisiblekill$hideInvisibleKiller(
            CallbackInfoReturnable<Component> cir
    ) {
        LivingEntity killer = getKiller();

        if (killer instanceof ServerPlayer player
                && player.hasEffect(MobEffects.INVISIBILITY)) {
            // Return a plain literal so no killer name or hover data survives.
            cir.setReturnValue(Component.literal(mob.getDisplayName().getString() + " was slain"));
        }
    }
}
