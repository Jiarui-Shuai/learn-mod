package com.learn.mod.cmds;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class DebugCommand {
    public static int execute(CommandContext<CommandSourceStack> context) throws CommandSyntaxException{
        Entity entity = EntityArgument.getEntity(context, "entity");
        context.getSource().sendSuccess(
            () -> net.minecraft.network.chat.Component.literal(run(entity)), 
            false
        );
        run(entity);
        return 1;
    };

    private static String run(Entity entity){
        Vec3 xyz = entity.position();
        Vec3 velocity = entity.getDeltaMovement();
        StringBuilder sb = new StringBuilder();
        sb.append("XYZ = ")
          .append("(%.2lf, %.2lf, %.2lf)".formatted(xyz.x, xyz.y, xyz.z))
          .append("\n")
          .append("Motion = ")
          .append("(%.2lf, %.2lf, %.2lf)".formatted(velocity.x, velocity.y, velocity.z));
        return sb.toString();
    }
}



