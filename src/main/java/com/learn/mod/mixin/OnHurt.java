package com.learn.mod.mixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;


// hurtServer(ServerLevel serverLevel, DamageSource damageSource, float f);

@Mixin(LivingEntity.class)
public class OnHurt {
    private static final Logger logger = LoggerFactory.getLogger(OnHurt.class);
    @Inject(method = "hurtServer", at = @At("HEAD"), cancellable = true)
    private void onHurt(ServerLevel serverLevel, DamageSource damageSource, float f, CallbackInfoReturnable<Boolean> ci) {
        // 这段代码将在 net.minecraft.world.entity.LivingEntity.hurtServer() 被调用之前执行。
        logger.info("哦不，%s 受伤了".formatted(
            ((LivingEntity)(Object)this).getName().getString()
        ));
        MinecraftServer server = serverLevel.getServer();
        MutableComponent message = Component.literal("哦! ")
                                   .append(((LivingEntity)(Object)this).getName().copy())
                                   .append(Component.literal("受伤了，伤害高达"))
                                   .append(Component.literal(String.valueOf(f)));
        // double d = Math.random();
        // double cancel = 0.5;
        // boolean b = (d < cancel);
        // if (b){
        //     message.append("但是他运气贼好，所以免伤");
        // }
        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            player.sendSystemMessage(message);
        }
        // if (b) {
        //     ci.cancel();
        // }
    }
}
