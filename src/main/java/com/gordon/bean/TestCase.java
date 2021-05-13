package com.gordon.bean;

public class TestCase {
    //案例是否可执行 true false
    private boolean enable;
    //系统id
    private String systemId;
    //案例id
    private String testId;
    //案例名称
    private String testName;
    //案例描述
    private String testMemo;
    //前置案例
    private  String preTestId;
    //前置方法
    private String preMethod;
    //被测试类
    private String interFaceName;
    //被测试类方法
    private String methodNama;
    //请求参数类型
    private String requestParamtType;
    //请求参数
    private String requestParam;
    //响应参数类型
    private String responseParamType;
    //响应数据保存
    private String saveResponse;
    //期望响应
    private String expectResponse;
    //数据库校验
    private String sql4Verify;
    //期望数据库信息
    private String expectDataBase;
    //期望日志信息
    private String  expectedLog;
    //后置方法
    private String postMethod;
    //后置案例
    private String postTestId;

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestMemo() {
        return testMemo;
    }

    public void setTestMemo(String testMemo) {
        this.testMemo = testMemo;
    }

    public String getPreTestId() {
        return preTestId;
    }

    public void setPreTestId(String preTestId) {
        this.preTestId = preTestId;
    }

    public String getPreMethod() {
        return preMethod;
    }

    public void setPreMethod(String preMethod) {
        this.preMethod = preMethod;
    }

    public String getInterFaceName() {
        return interFaceName;
    }

    public void setInterFaceName(String interFaceName) {
        this.interFaceName = interFaceName;
    }

    public String getMethodNama() {
        return methodNama;
    }

    public void setMethodNama(String methodNama) {
        this.methodNama = methodNama;
    }

    public String getRequestParamtType() {
        return requestParamtType;
    }

    public void setRequestParamtType(String requestParamtType) {
        this.requestParamtType = requestParamtType;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getResponseParamType() {
        return responseParamType;
    }

    public void setResponseParamType(String responseParamType) {
        this.responseParamType = responseParamType;
    }

    public String getSaveResponse() {
        return saveResponse;
    }

    public void setSaveResponse(String saveResponse) {
        this.saveResponse = saveResponse;
    }

    public String getExpectResponse() {
        return expectResponse;
    }

    public void setExpectResponse(String expectResponse) {
        this.expectResponse = expectResponse;
    }

    public String getSql4Verify() {
        return sql4Verify;
    }

    public void setSql4Verify(String sql4Verify) {
        this.sql4Verify = sql4Verify;
    }

    public String getExpectDataBase() {
        return expectDataBase;
    }

    public void setExpectDataBase(String expectDataBase) {
        this.expectDataBase = expectDataBase;
    }

    public String getExpectedLog() {
        return expectedLog;
    }

    public void setExpectedLog(String expectedLog) {
        this.expectedLog = expectedLog;
    }

    public String getPostMethod() {
        return postMethod;
    }

    public void setPostMethod(String postMethod) {
        this.postMethod = postMethod;
    }

    public String getPostTestId() {
        return postTestId;
    }

    public void setPostTestId(String postTestId) {
        this.postTestId = postTestId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "enable=" + enable +
                ", systemId='" + systemId + '\'' +
                ", testId='" + testId + '\'' +
                ", testName='" + testName + '\'' +
                ", testMemo='" + testMemo + '\'' +
                ", preTestId='" + preTestId + '\'' +
                ", preMethod='" + preMethod + '\'' +
                ", interFaceName='" + interFaceName + '\'' +
                ", methodNama='" + methodNama + '\'' +
                ", requestParamtType='" + requestParamtType + '\'' +
                ", requestParam='" + requestParam + '\'' +
                ", responseParamType='" + responseParamType + '\'' +
                ", saveResponse='" + saveResponse + '\'' +
                ", expectResponse='" + expectResponse + '\'' +
                ", sql4Verify='" + sql4Verify + '\'' +
                ", expectDataBase='" + expectDataBase + '\'' +
                ", expectedLog='" + expectedLog + '\'' +
                ", postMethod='" + postMethod + '\'' +
                ", postTestId='" + postTestId + '\'' +
                '}';
    }
}
