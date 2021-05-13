package com.gordon.framework.context;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalTestContext  implements ApplicationListener {

    private final static ThreadLocal<Map<String,Object>> CLOBAL_DATA_THREAS_LOCAL=ThreadLocal.withInitial(ConcurrentHashMap::new);
    private static Map<String,Object> PROPERTY_MAP;
    public static String  getString(String key) {
        return getData(key,String.class);
    }
    public final static Map<String,String> FACADE_INTERFACE_NAME_MAP= new HashMap<>();
    private static <T> T getData(String key, Class<T> cls) {
        CLOBAL_DATA_THREAS_LOCAL.get().putAll(PROPERTY_MAP);
        return (T) CLOBAL_DATA_THREAS_LOCAL.get().get(key);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

    }
}
