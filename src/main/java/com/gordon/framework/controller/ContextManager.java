package com.gordon.framework.controller;

import org.testng.ITestContext;
import org.testng.xml.XmlTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ContextManager {
    private static Context  suitContext;
    private static ThreadLocal<Context> threadLevelContext = new ThreadLocal<>();
    private static Map<String,Context> testLevelCOntext = Collections.synchronizedMap(new HashMap<>());
    public static void initSuitContext(ITestContext context) {
        suitContext=new Context(context);

    }

    public static void iniThreadContext(ITestContext testNGCintext, XmlTest xmlTest) {
        Context context=(Context) testNGCintext;
        if (xmlTest==null){
            Map<String, String> testParameters = xmlTest.getAllParameters();
            Iterator<Map.Entry<String, String>> iterator = testParameters.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                context.setFieldValue(next.getKey(),next.getValue());
            }

        }
        threadLevelContext.set(context);
    }

    public static void initTestLevelContext(ITestContext iTestContext, XmlTest xmlTest) {
        Context context = (Context) iTestContext;
        if(xmlTest!=null){
            Map<String,String> map = xmlTest.getTestParameters();
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                context.setFieldValue(next.getKey(),next.getValue());
            }
        }

        testLevelCOntext.put(xmlTest.getName(),context);
    }



    public static void initThreadContext(ITestContext testContext, XmlTest xmlTest) {
        Context context = (Context) testContext;
        if(xmlTest!=null){
            Map<String, String> parameters = xmlTest.getTestParameters();
            Iterator<Map.Entry<String, String>> iterator = parameters.entrySet().iterator();

            while(iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                if(System.getProperty(next.getKey())==null){
                    context.setFieldValue(next.getKey(),next.getValue());
                }
            }
        }
        threadLevelContext.set(context);
    }

    public static Context getThreadContext() {
        if(threadLevelContext==null){
            iniThreadContext(getSuitContext().getTestNContext(),(XmlTest)null);
        }

        return threadLevelContext.get();

    }

    public static Context getSuitContext() {
        if(suitContext==null){
            initSuitContext(new BettytestContext());
        }
        return suitContext;
    }
}
