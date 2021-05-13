package com.gordon.bean;

public class RuntimeTestCase {
    private String csvName;
    private String testId;
    private String failed;
    private Throwable throwable ;

    public RuntimeTestCase(String csvName, String testId) {
        this.csvName = csvName;
        this.testId = testId;
    }

    public String getCsvName() {
        return csvName;
    }

    public void setCsvName(String csvName) {
        this.csvName = csvName;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getFailed() {
        return failed;
    }

    public void setFailed(String failed) {
        this.failed = failed;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String toString() {
        return "RuntimeTestCase{" +
                "csvName='" + csvName + '\'' +
                ", testId='" + testId + '\'' +
                ", failed='" + failed + '\'' +
                ", throwable=" + throwable +
                '}';
    }
}
