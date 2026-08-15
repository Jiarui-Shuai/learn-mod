package com.learn.mod.cmds;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.commands.CommandSourceStack;

public class TestCommand {
    public static int execute(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        context.getSource().sendSuccess(
            () -> net.minecraft.network.chat.Component.literal("""
                
                /\\___/\\
                ( o   o )
                (  =^=  )
                (        )
                (         )
                (          )))))))))))
                
                COMMAND RUNS ACTIVATED!
                NOT CRASHED!!!!!!!!!!!!
                """),
            false
        );
        return 1;
    }
}
