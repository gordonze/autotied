package com.gordon.database;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseConnector implements Connector{
    private Connection connection;
    private String url;
    private String ueseName;
    private String passWord;


    public BaseConnector(String url, String ueseName, String passWord) {
        this.url = url;
        this.ueseName = ueseName;
        this.passWord = passWord;
    }

    @Override
    public boolean connect() throws SQLException {
        
        return this.isConnected();
    }

    @Override
    public boolean reConnect() throws SQLException {
        return false;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public void commit() throws SQLException {

    }

    @Override
    public boolean isAutoCommit() throws SQLException {
        return false;
    }

    @Override
    public void enableAutoCommit() throws SQLException {

    }

    @Override
    public void disableAutoCommit() throws SQLException {

    }

    @Override
    public boolean isConnected() throws SQLException {
        return false;
    }

    @Override
    public void close() throws SQLException {

    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUeseName() {
        return ueseName;
    }

    public void setUeseName(String ueseName) {
        this.ueseName = ueseName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
