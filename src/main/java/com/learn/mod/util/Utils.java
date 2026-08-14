package com.learn.mod.util;

import net.minecraft.world.entity.Entity;

public class Utils {

    public Utils() {
    }

    public boolean addVelocity(Entity entity, double x, double y, double z) {
        if (entity == null)
            return false; 
        entity.setDeltaMovement(entity.getDeltaMovement().add(x, y, z));
        return true; 
    }
}
