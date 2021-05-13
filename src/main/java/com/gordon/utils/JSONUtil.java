package com.gordon.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.Map;

public class JSONUtil {

    public static <T> T ObjectMap2Bean(Map<String, Object> map, Class<?> cls) {

        JSONObject jsonObject = new JSONObject(map);

        return (T) JSON.parseObject(jsonObject.toJSONString(), cls);
    }

    public static Map<String, Object> json2ObjectMap(String requestParam) {
        return JSON.parseObject(requestParam, new TypeReference<Map<String, Object>>() {
        });
    }

    public static Map<String, Object> bean2ObjectMap(Object value) {
        return (Map<String, Object>) JSON.toJSON(value);
    }

    public static <T> T json2Object(String request, Class<?> cls) {
        Object parse = JSON.parseObject(request, cls);
        return (T) parse;
    }
}
