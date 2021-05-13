package com.gordon.database;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlConnector extends BaseConnector implements Connector{
    public MysqlConnector(String url, String ueseName, String passWord) {
        super(url,ueseName,passWord);
    }


}
