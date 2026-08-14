package com.learn.mod.util;

import net.minecraft.world.level.Level;

public class Explode {
    public Level level;
    public double x, y, z;
    public float power;
    public Level.ExplosionInteraction explosionInteraction;

    public Explode(Level level, double x, double y, double z, float power, Level.ExplosionInteraction explosionInteraction, boolean explodeNow) {
        this.level = level;
        this.x = x;
        this.y = y;
        this.z = z;
        this.power = power;
        this.explosionInteraction = explosionInteraction;
        if (explodeNow) 
            this.explode();

    }

    public void explode() {
        level.explode(null, x, y, z, power, false, explosionInteraction);
    }

    public static void explode(Level level, double x, double y, double z, float power, Level.ExplosionInteraction explosionInteraction) {
        level.explode(null, x, y, z, power, false, explosionInteraction);

    }

    public void setLevel(Level level) {this.level = level; }
    public void setX(double x) {this.x = x; }
    public void setY(double y) {this.y = y; }
    public void setZ(double z) {this.z = z; }
    public void setPower(float power) {this.power = power; }
    public void setExplosionInteraction(Level.ExplosionInteraction explosionInteraction) {this.explosionInteraction = explosionInteraction; }
}
