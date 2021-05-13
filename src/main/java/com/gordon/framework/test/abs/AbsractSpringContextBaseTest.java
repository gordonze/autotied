package com.gordon.framework.test.abs;

import com.gordon.framework.controller.ContextManager;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

public abstract class AbsractSpringContextBaseTest extends AbstractTestNGSpringContextTests {

    @BeforeSuite(alwaysRun = true)
    public  void beforeTestSuite(ITestContext context){
        ContextManager.initSuitContext(context);
        ContextManager.iniThreadContext(context,null);
    }
    @BeforeTest(alwaysRun = true)
    public void beforeTest(ITestContext iTestContext, XmlTest xmlTest){
        ContextManager.initTestLevelContext(iTestContext,xmlTest);

    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method,ITestContext testContext,XmlTest xmlTest){
        ContextManager.initThreadContext(testContext,xmlTest);
    }
    @AfterMethod (alwaysRun =true)
    public void afterMetod(){

    }
    @AfterSuite(alwaysRun = true)
    public void afterSuit(){

    }
}
