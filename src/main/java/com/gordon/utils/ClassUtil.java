package com.gordon.utils;

public class ClassUtil {

    public static <T> T newInstance(Class<T> cls){
        try {
            return cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return (T) new RuntimeException();
        }
    }
}
