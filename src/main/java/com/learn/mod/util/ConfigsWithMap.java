package com.learn.mod.util;

import java.util.Map;

import com.google.common.annotations.Beta;

import java.util.HashMap;

@Beta
public class ConfigsWithMap {
    private static volatile Map<String, Object> configs = new HashMap<>();

    // 如果这里崩了，请先检查下调用堆栈上一层的其它代码，而不是吐槽这里，正常用绝对不会崩。作者是个人开发者，没心思管那些

    public static boolean getBoolean(String K) { return Boolean.TRUE.equals(configs.get(K)); }
    public static void setBoolean(String K, boolean B){ configs.put(K, Boolean.valueOf(B)); }

    public static byte getByte(String K){ return (Byte)configs.get(K); }
    public static void setByte(String K, byte n){ configs.put(K, Byte.valueOf(n)); }

    public static short getShort(String K){ return (Short)configs.get(K); }
    public static void setShort(String K, short n){ configs.put(K, Short.valueOf(n)); }

    public static int getInt(String K){ return (Integer)configs.get(K); }
    public static void setInt(String K, int n){ configs.put(K, Integer.valueOf(n)); }

    public static long getLong(String K){ return (Long)configs.get(K); }
    public static void setLong(String K, long n){ configs.put(K, Long.valueOf(n)); }

    public static float getFloat(String K){ return (Float)configs.get(K); }
    public static void setFloat(String K, float n){ configs.put(K, Float.valueOf(n)); }

    public static double getDouble(String K){ return (Double)configs.get(K); }
    public static void setDouble(String K, double n){ configs.put(K, Double.valueOf(n)); }
    
    public static String getString(String K){ return (String)configs.get(K); }
    public static void setString(String K, String V) { configs.put(K, V); }

    public static void remove (String K) { configs.remove(K); }
    public static void clear () { configs.clear(); }
}
