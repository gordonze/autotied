package com.gordon.framework.test.abs;

import com.gordon.phase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractTest extends AbsractSpringContextBaseTest {
    @Autowired
    private ProcessTestCasePhase processTestCasePhase;
    //前置案例
    @Autowired
    protected ProcessPreviousTestPhase processPreviousTestPhase;

    @Autowired
    protected ProcessPreviousMethodPhase processPreviousMethodPhase;

    @Autowired
    protected ProcessParamPhase processParamPhase;

    @Autowired
    protected BuildRequestPhase buildRequestPhase;

    protected AbstractTest() {
    }

    @DataProvider(name = "ItemData", parallel = false)
    public Iterator<Object[]> getItemData(Method m, ITestContext testContext) throws Exception {
        List<Object[]> list;
        Map<String, String> map = testContext.getCurrentXmlTest().getAllParameters();
        String csvName = map.get("csvName");
        String caseId = map.get("caseId");

        list = processTestCasePhase.processFromCSV(csvName, caseId, testContext);

        return list.iterator();
    }
}
