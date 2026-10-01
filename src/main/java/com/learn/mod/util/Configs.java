package com.learn.mod.util;

public class Configs {


    public volatile static boolean enabledHurtInfo= true;

    public static void setEnabledHurtInfo(){
        enabledHurtInfo = true;
    }

    public static void setDisabledHurtInfo(){
        enabledHurtInfo = false;
    }

    public static void setEnabledHurtInfo(boolean b) {
        enabledHurtInfo = b;
    }
}
