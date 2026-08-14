package com.learn.mod.util;

public class AnsiColors {
    // ANSI转义字符 (ASCII 27)
    public static final char ESC = 27;
    
    // 颜色代码
    public static final String RESET = ESC + "[0m";
    public static final String BLACK = ESC + "[30m";
    public static final String RED = ESC + "[31m";
    public static final String GREEN = ESC + "[32m";
    public static final String YELLOW = ESC + "[33m";
    public static final String BLUE = ESC + "[34m";
    public static final String PURPLE = ESC + "[35m";
    public static final String CYAN = ESC + "[36m";
    public static final String WHITE = ESC + "[37m";
    
    // 背景色
    public static final String BG_BLACK = ESC + "[40m";
    public static final String BG_RED = ESC + "[41m";
    public static final String BG_GREEN = ESC + "[42m";
    public static final String BG_YELLOW = ESC + "[43m";
    public static final String BG_BLUE = ESC + "[44m";
    public static final String BG_PURPLE = ESC + "[45m";
    public static final String BG_CYAN = ESC + "[46m";
    public static final String BG_WHITE = ESC + "[47m";
    
    // 样式
    public static final String BOLD = ESC + "[1m";
    public static final String ITALIC = ESC + "[3m";
    public static final String UNDERLINE = ESC + "[4m";
    public static final String BLINK = ESC + "[5m";
    public static final String REVERSE = ESC + "[7m";
    
    /**
     * 创建彩色文本
     */
    public static String colorize(String text, String color) {
        return color + text + RESET;
    }
    
    /**
     * 创建彩虹文本
     */
    public static String rainbow(String text) {
        StringBuilder sb = new StringBuilder();
        String[] colors = {RED, YELLOW, GREEN, CYAN, BLUE, PURPLE};
        
        for (int i = 0; i < text.length(); i++) {
            String color = colors[i % colors.length];
            sb.append(color).append(text.charAt(i));
        }
        
        sb.append(RESET);
        return sb.toString();
    }
    
    /**
     * 创建成功消息
     */
    public static String success(String message) {
        return GREEN + "✓ " + message + RESET;
    }
    
    /**
     * 创建错误消息
     */
    public static String error(String message) {
        return RED + "✗ " + message + RESET;
    }
    
    /**
     * 创建警告消息
     */
    public static String warning(String message) {
        return YELLOW + "⚠ " + message + RESET;
    }
    
    /**
     * 创建信息消息
     */
    public static String info(String message) {
        return CYAN + "ℹ " + message + RESET;
    }
}