package com.gordon.database;

import org.apache.commons.lang3.StringUtils;

/**
 *  gordon edit
 */
public class ConnectorFactory {
    public ConnectorFactory() {
    }

    public static Connector CreateConnector(String url, String userName, String passWord) {
        if(StringUtils.equalsIgnoreCase(url,"jdbc:mysql")){
            return new  MysqlConnector(url.trim(),userName.trim(),passWord.trim());
        }else if(StringUtils.equalsIgnoreCase(url,"jdbc:oracle")){
            return (Connector) new  OracleConnector(url.trim(),userName.trim(),passWord.trim());
        }else{
            return  null;
        }
    }
}
