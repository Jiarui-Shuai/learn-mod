package com.learn.mod.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.learn.mod.util.AnsiColors;

@Mixin(MinecraftServer.class)
public class ExampleMixin {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleMixin.class);
	@Inject(at = @At("HEAD"), method = "loadLevel")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadLevel()
		logger.info(AnsiColors.GREEN +        """
           /\\___/\\
          ( o   o )
          (  =^=  )
          (        )
          (         )
          (          )))))))))))
        
          MIXIN ACTIVATED!
        """+AnsiColors.RESET);
	}
}