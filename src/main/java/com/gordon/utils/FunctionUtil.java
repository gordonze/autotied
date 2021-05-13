package com.gordon.utils;

import com.gordon.framework.function.Function;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FunctionUtil {
    private static final Map<String, Function> FUN_MAP =new ConcurrentHashMap<>();
    public static boolean isFunction(String name){
        return FUN_MAP.containsKey(name);
    }

    public static String getResult(String funcName, String[] split) {
        return FUN_MAP.get(funcName).execute(split);
    }
}
