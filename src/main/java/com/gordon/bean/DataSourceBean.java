package com.gordon.bean;

public class DataSourceBean {
    private String url;
    private String userName;
    private String passWord;
    private String env;
    private String connectorProfile;
    public DataSourceBean() {
    }

    public DataSourceBean(String url, String userName, String passWord, String env, String connectorProfile) {
        this.url = url;
        this.userName = userName;
        this.passWord = passWord;
        this.env = env;
        this.connectorProfile = connectorProfile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getConnectorProfile() {
        return connectorProfile;
    }

    public void setConnectorProfile(String connectorProfile) {
        this.connectorProfile = connectorProfile;
    }
}
