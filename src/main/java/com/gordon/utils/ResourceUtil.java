package com.gordon.utils;

import java.io.InputStream;

public class ResourceUtil {
    public static InputStream getRecsourceStream(String path, Class<?> cls) {

        InputStream in=cls.getResourceAsStream(path);
        if (in ==null){
            return null;
        }else{
            return in;
        }

    }
}
