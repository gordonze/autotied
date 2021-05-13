package com.gordon.phase;

import com.gordon.bean.RuntimeTestCase;
import com.gordon.bean.TestCase;
import com.gordon.utils.TestCaseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 前置案例
 */
@Service
public class ProcessPreviousTestPhase extends AbstractPhase{

    public void runTest(TestCase testCase){
        RuntimeTestCase previousTest = TestCaseUtil.createRuntimeTestByTestId(testCase, testCase.getPreTestId());
        System.setProperty("env", StringUtils.isEmpty(System.getenv("env"))?"stg2":System.getenv("env"));
        Map<String,String> map = new HashMap<>(4);
        map.put("csvName",previousTest.getCsvName());
        map.put("caseId",previousTest.getTestId());

        TestCaseUtil.runTestProgrammatically("Previous test",TestCase.class,map);
    }
}
