package com.gordon.framework.config;

import java.util.List;

public class FrameworkConfigBean {
    private List<String> facadePackageList;
    private String  dataSourcePath;
    private String  globalValuePath;
    private String  logContextPath;
    private String  observerPath;
    private String  sqlPath;
    private String  csvPath;

    public List<String> getFacadePackageList() {
        return facadePackageList;
    }

    public void setFacadePackageList(List<String> facadePackageList) {
        this.facadePackageList = facadePackageList;
    }

    public String getDataSourcePath() {
        return dataSourcePath;
    }

    public void setDataSourcePath(String dataSourcePath) {
        this.dataSourcePath = dataSourcePath;
    }

    public String getGlobalValuePath() {
        return globalValuePath;
    }

    public void setGlobalValuePath(String globalValuePath) {
        this.globalValuePath = globalValuePath;
    }

    public String getLogContextPath() {
        return logContextPath;
    }

    public void setLogContextPath(String logContextPath) {
        this.logContextPath = logContextPath;
    }

    public String getObserverPath() {
        return observerPath;
    }

    public void setObserverPath(String observerPath) {
        this.observerPath = observerPath;
    }

    public String getSqlPath() {
        return sqlPath;
    }

    public void setSqlPath(String sqlPath) {
        this.sqlPath = sqlPath;
    }

    public String getCsvPath() {
        return csvPath;
    }

    public void setCsvPath(String csvPath) {
        this.csvPath = csvPath;
    }

    @Override
    public String toString() {
        return "FrameworkConfigBean{" +
                "facadePackageList=" + facadePackageList +
                ", dataSourcePath='" + dataSourcePath + '\'' +
                ", globalValuePath='" + globalValuePath + '\'' +
                ", logContextPath='" + logContextPath + '\'' +
                ", observerPath='" + observerPath + '\'' +
                ", sqlPath='" + sqlPath + '\'' +
                ", csvPath='" + csvPath + '\'' +
                '}';
    }
}
