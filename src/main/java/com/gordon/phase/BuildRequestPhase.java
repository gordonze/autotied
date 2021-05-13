package com.gordon.phase;

import com.gordon.bean.TestCase;
import com.gordon.framework.dubbo.DubboRequest;
import com.gordon.framework.dubbo.api.FacadeApiService;
import com.gordon.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildRequestPhase extends AbstractPhase {
    @Autowired
    private FacadeApiService facadeApiService;

    public DubboRequest buildDubboRequest(Object request, TestCase testCase) {
        DubboRequest dubboRequest = null;
        dubboRequest = facadeApiService.buildDubboRequest(request, testCase);
        return dubboRequest;
    }

    public <T> T buildRequest(TestCase testCase) {

        try {
            return (T) JSONUtil.json2Object(testCase.getRequestParam(), Class.forName(testCase.getRequestParamtType()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
