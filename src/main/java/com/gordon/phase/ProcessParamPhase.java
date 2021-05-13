package com.gordon.phase;

import com.alibaba.fastjson.JSONObject;
import com.gordon.bean.TestCase;
import com.gordon.framework.constant.Constant;
import com.gordon.framework.context.GlobalTestContext;
import com.gordon.framework.function.Function;
import com.gordon.utils.FunctionUtil;
import com.gordon.utils.JSONUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;

/**
 * 替换参数
 */
public class ProcessParamPhase extends AbstractPhase {

    public synchronized void replaceParemterizedRequest(TestCase testCase){

        String tag =testCase.getTestId();
        String requestParam = testCase.getRequestParam();
        Map<String, Object> requestMap = JSONUtil.json2ObjectMap(requestParam);
        replaceGlobalValue(tag,requestMap);
        replaceFunction(tag,requestMap);
        saveRequst(testCase,requestMap);
    }

    private void saveRequst(TestCase testCase, Map<String, Object> requestMap) {
    }

    private void replaceFunction(String tag, Map<String, Object> requestMap) {
        for (Map.Entry<String,Object> entry :requestMap.entrySet()){
            if(entry.getValue() instanceof String){
                String value = (String) entry.getValue();
                if(value==null){
                    continue;
                }
                Matcher matcher = Constant.FUNCTION_PATTERN.matcher(value);
                while (matcher.find()){
                    String funcName = matcher.group(1);
                    String innerAgr = matcher.group(2);
                    if(FunctionUtil.isFunction(funcName)){
                        String result;
                        if(StringUtils.isNotEmpty(innerAgr)){
                            String[] split = innerAgr.trim().split(",");
                            result=FunctionUtil.getResult(funcName,split);
                        }else {
                           result= FunctionUtil.getResult(funcName,null);
                        }
                        requestMap.put(entry.getKey(),result);
                    }
                }

            }else if (entry.getValue() instanceof JSONObject){
                Map<String, Object> stringObjectMap = JSONUtil.bean2ObjectMap(entry.getValue());
                replaceFunction(tag,stringObjectMap);
                requestMap.put(entry.getKey(),new JSONObject(stringObjectMap));
            }
        }
    }

    private void replaceGlobalValue(String tag, Map<String, Object> requestMap) {
        for(Map.Entry<String ,Object> entry:requestMap.entrySet()){
            if(entry.getValue() instanceof String){
                String value = (String) entry.getValue();
                if(value==null){
                   continue;
                }
                Matcher matcher = Constant.GLOBAL_VALUE_PATTERN.matcher(value);
                while(matcher.find()){
                    String key = matcher.group(1);
                    GlobalTestContext.getString(key);
                }
            }else if(entry.getValue() instanceof JSONObject){

            }
        }
    }
}
