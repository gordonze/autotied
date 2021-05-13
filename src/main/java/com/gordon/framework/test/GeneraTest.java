package com.gordon.framework.test;

import com.gordon.bean.TestCase;
import com.gordon.framework.dubbo.DubboRequest;
import com.gordon.framework.test.abs.AbstractTest;
import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GeneraTest extends AbstractTest {

    @Test(dataProvider = "ItemData")
    public void runTest(TestCase testCase, ITestContext testContext) throws Throwable {


        //执行前置案例
        if (StringUtils.isNotBlank(testCase.getPreTestId())) {
            processPreviousTestPhase.runTest(testCase);
        }

        //执行前置方法
        if (StringUtils.isNotBlank(testCase.getPreTestId())) {
            processPreviousMethodPhase.runPreMthod(testCase);
        }
        //替换参数
        processParamPhase.replaceParemterizedRequest(testCase);
        //开始执行案例
        Object req = buildRequestPhase.buildRequest(testCase);
        DubboRequest dubboRequest = buildRequestPhase.buildDubboRequest(req, testCase);
        dubboRequest.invoke();
        //执行后置案例
        //执行后置方法
    }
}
