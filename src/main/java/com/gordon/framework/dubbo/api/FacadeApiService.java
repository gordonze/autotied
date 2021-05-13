package com.gordon.framework.dubbo.api;

import com.gordon.bean.TestCase;
import com.gordon.framework.dubbo.DubboRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FacadeApiService extends FacadeAPI {

    public DubboRequest buildDubboRequest(Object request, TestCase testCase){
        String requestParamtType = testCase.getRequestParamtType();
        List<String> paramType = new ArrayList<>();
        List<Object> paramValue= new ArrayList<>();
        DubboRequest dubboRequest = super.buildBaseRequest();

        dubboRequest.setInterFaceName(testCase.getInterFaceName());
        dubboRequest.setMethodName(testCase.getMethodNama());
        if(StringUtils.isNotEmpty(requestParamtType)){
            paramType.add(requestParamtType);
            dubboRequest.setParamTypes(paramType);
            paramValue.add(request);
            dubboRequest.setParamValues(paramValue);
        }
        return dubboRequest;
    }
}
