package com.learn.mod.cmds;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class ModCommands implements CommandRegistrationCallback {
    @Override
    public void register(CommandDispatcher<CommandSourceStack> dispatcher,
                         CommandBuildContext registryAccess,
                         Commands.CommandSelection environment) {
        dispatcher.register(
            Commands.literal("test")
                .executes(context -> {
                    context.getSource().sendSuccess(
                        () -> net.minecraft.network.chat.Component.literal("Hello!"),
                        false
                    );
                    return 1;
                })
        );
    }
    
    // 注册
    public static void initialize() {
        CommandRegistrationCallback.EVENT.register(new ModCommands());
    }
}