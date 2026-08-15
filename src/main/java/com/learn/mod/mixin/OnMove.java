package com.learn.mod.mixin;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec3;
// import net.minecraft.network.chat.Component;
// import net.minecraft.network.chat.MutableComponent;
// import net.minecraft.server.level.ServerPlayer;


// void move(MoverType moverType, Vec3 vec3)

@Mixin(Entity.class)
public class OnMove {
    // private static final Logger logger = LoggerFactory.getLogger(OnMove.class);
    @Inject(method = "move", at = @At("HEAD"), cancellable = true)
    private void onMove(MoverType moverType, Vec3 vec3, CallbackInfo ci) {
        // Entity _this = (Entity)(Object)this;
        // if (_this.level().isClientSide())
        //     return;
        // if (!(_this instanceof ServerPlayer)) 
        //     return;
        // double f = vec3.length()*20;
        // MutableComponent message = Component.literal("")
        //                            .append(((Entity)(Object)this).getName().copy())
        //                            .append(Component.literal("移动了，速度是"))
        //                            .append(Component.literal(String.valueOf(f)))
        //                            .append(Component.literal(""));
        // ((ServerPlayer)_this).sendSystemMessage(message);
        // logger.debug(message.getString());    
    }
}
