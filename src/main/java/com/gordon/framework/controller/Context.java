package com.gordon.framework.controller;

import org.testng.ITestContext;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Context {
    public static final String POOL="pool";
    public static final String DOMAIN="domain";
    public static final String site="site";
    public static final String SECRET_CONFIF_FILE_PATH="secretConfigFilePath";
    public static final String OPEN_ERPORT_IN_BROWSER="openReportInBeowser";
    public static final String TEST_OUTPUT_DIRECTORY="outputDirectory";
    public static final String URL_OUTPUT_CLASS="utlConverterClass";
    public static final String ZK_URL_CONVERTER_CLASS="zkUelConverterClass";
    public static final String DB_URL_CONVERTER_CLASS="dbUelConverterClass";
    public static final String mq_URL_CONVERTER_CLASS="mqUelConverterClass";
    public static final String ENV="env";
    public static final String ZK_URL="ZKUrl";
    public static final String GROUP_ID="groupId";
    public static final String DB_URL_PREL="dbUrlPre";
    public static final String COVERCAGE_SERVER="covercageServer";
    public static final String JMETER_HOME="JMETER_HOME";
    public static final String JMETER_OUTPUT_DIRECTORY="jmeterOutputDirectory";
    public static final String REGISTRY_ADDRESS="registryAddress";
    public static final String DB_CAPABLILITY="dbCapability";
    private Map<String,Object> contextFieldsMap = Collections.synchronizedMap(new HashMap<>());
    private ITestContext testNGContext= null;

    public Context(ITestContext testNGContext){
        this.testNGContext=testNGContext;
        this.setContextField("pool",System.getProperty("pool"),testNGContext,"pinganfu");
        this.setContextField("domain",System.getProperty("domain"),testNGContext,"pinganfu.com");
        this.setContextField("groupId",System.getProperty("groupId"),testNGContext,null);
        this.setContextField("site",System.getProperty("site"),testNGContext,"CN");
        this.setContextField("openReportInBeowser",System.getProperty("openReportInBeowser"),testNGContext,null);
        this.setContextField("outputDirectory",System.getProperty("outputDirectory"),testNGContext,null);
        this.setContextField("secretConfigFilePath",System.getProperty("secretConfigFilePath"),testNGContext,null);
        this.setContextField("utlConverterClass",System.getProperty("utlConverterClass"),testNGContext,null);
        this.setContextField("ZK_URL_CONVERTER_CLASS",System.getProperty("ZK_URL_CONVERTER_CLASS"),testNGContext,null);
        this.setContextField("dbUelConverterClass",System.getProperty("dbUelConverterClass"),testNGContext,null);
        this.setContextField("mqUelConverterClass",System.getProperty("mqUelConverterClass"),testNGContext,null);
        this.setContextField("env",System.getProperty("env"),testNGContext,null);
        this.setContextField("ZKUrl",System.getProperty("ZKUrl"),testNGContext,null);
        this.setContextField("dbUrlPre",System.getProperty("dbUrlPre"),testNGContext,null);
        this.setContextField("covercageServer",System.getProperty("covercageServer"),testNGContext,null);
        this.setContextField("JMETER_HOME",System.getProperty("JMETER_HOME"),testNGContext,null);
        this.setContextField("jmeterOutputDirectory",System.getProperty("jmeterOutputDirectory"),testNGContext,null);
        this.setContextField("registryAddress",System.getProperty("registryAddress"),testNGContext,null);
        this.setContextField("dbCapability",System.getProperty("dbCapability"),testNGContext,null);
        this.setContextField("groupId",System.getProperty("groupId"),testNGContext,null);
        this.setContextFields(testNGContext);

    }

    private void setContextFields(ITestContext testNGContext) {
        if(testNGContext!=null&&testNGContext.getSuite().getXmlSuite()!=null){
            Map<String, String> suitParameters = testNGContext.getSuite().getXmlSuite().getParameters();
            Iterator<Map.Entry<String, String>> iterator = suitParameters.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
                String key = entry.getKey();
                if(contextFieldsMap.get(key)==null){
                    String property = System.getProperty(key);
                    this.setContextField(key,property,(String)((String)entry.getValue()),null);
                }
            }
        }
    }
    private void setContextField(String key, String sysPropertyValue, String suiteValue, String defaultValue){

        this.contextFieldsMap.put(key,sysPropertyValue!=null?sysPropertyValue:(suiteValue!=null?suiteValue:defaultValue));
    }
    private void setContextField(String key, String sysPropertyValue, ITestContext testNGContext, String defaultValue){
        String suiteValue =null;
        if(testNGContext==null){
            suiteValue=this.getSuiteParameter(key);
        }
        this.contextFieldsMap.put(key,sysPropertyValue!=null?sysPropertyValue:(suiteValue!=null?suiteValue:defaultValue));
    }

    private String getSuiteParameter(String key) {
        return this.geTestNGContext().getSuite().getParameter(key);
    }
    private  ITestContext geTestNGContext(){
        return testNGContext;
    }

    public void setFieldValue(String key, String value) {
        this.contextFieldsMap.put(key,value);
    }

    public ITestContext getTestNContext() {
        return this.testNGContext;
    }

    public String getZkUrl() {
        return (String)this.getFieldValue();
    }
    public String getEnv() {
        return (String)this.getFieldValue();
    }
    public String getPool() {
        return (String)this.getFieldValue();
    }
    public String getDomain() {
        return (String)this.getFieldValue();
    }
    public String getUrlConverterClass() {
        return (String)this.getFieldValue();
    }
    public String getDbUrlPre() {
        return (String)this.getFieldValue();
    }
    public String getDbCapablility() {
        return (String)this.getFieldValue();
    }
    public String getGroupId() {
        return (String)this.getFieldValue();
    }
    public String getZkUrlConverterClass() {
        return (String)this.getFieldValue();
    }
    public String getDbUrlConverterClass() {
        return (String)this.getFieldValue();
    }
    public String getMqUrlConverterClass() {
        return (String)this.getFieldValue();
    }
    public String getSecretConfifFilePath() {
        return (String)this.getFieldValue();
    }
    public String getAttribute() {
        return (String)this.getFieldValue();
    }

    private Object getFieldValue() {
        Object obj = this.contextFieldsMap.get("evn");
        return obj;
    }
}
