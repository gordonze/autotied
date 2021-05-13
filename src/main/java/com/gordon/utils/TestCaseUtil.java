package com.gordon.utils;

import com.gordon.bean.RuntimeTestCase;
import com.gordon.bean.TestCase;
import com.gordon.framework.listener.RuntimeTestFastFailListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.Arrays;
import java.util.Map;

public class TestCaseUtil {
    public static RuntimeTestCase createRuntimeTestByTestId(TestCase testCase, String testIdString){
        String[] testInfo = testIdString.split("\\.");
        if(testInfo.length==1){
            String[] ids = testInfo[0].split("_");
            return  new RuntimeTestCase(testCase.getSystemId()+"/"+ids[0],testInfo[0]);
        }else if (testInfo.length==2){
            return  new RuntimeTestCase(testCase.getSystemId()+"/"+testInfo[0],testInfo[1]);

        } else if (testInfo.length==3){
            return  new RuntimeTestCase(testCase.getSystemId()+"/"+testInfo[1],testInfo[2]);

        }else {
            return  null;
        }
    }

    public static void runTestProgrammatically(String testName, Class<TestCase> testCaseClass, Map<String, String> map) {
        XmlSuite suite = new XmlSuite();
        suite.addListener(RuntimeTestFastFailListener.class.getName());
        XmlTest test = new XmlTest();
        XmlClass xmlClass = new XmlClass(testCaseClass);
        test.setName(testName);
        test.setParameters(map);
        test.setXmlClasses(Arrays.asList(xmlClass));

        TestNG  testNG = new TestNG();
        testNG.setXmlSuites(Arrays.asList(suite));
        testNG.run();
    }
}
