package com.gordon.database.impl;

import com.google.inject.internal.cglib.core.$ReflectUtils;
import com.gordon.bean.DBResult;
import com.gordon.bean.DataSourceBean;
import com.gordon.database.Connector;
import com.gordon.database.ConnectorFactory;
import com.gordon.database.Operator;
import com.gordon.framework.utility.EnvManager;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.security.auth.login.CredentialNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Iterator;


public class DBCapability implements Operator<DBResult> {
    private Connector connector;

    private String connectorProfile;

    public DBCapability(String connectorProfile) {
        this.connectorProfile = connectorProfile;
        init();
    }

    private void init() {
        String env = EnvManager.getEnv();
        String url="";
        String userName="";
        String passWord="";

        String path;
        DataSourceBean dataSourceBean;

        try {
            path="defaultConfig/datasource.xml";
            dataSourceBean=this.DataSourceXmlToBean(path);

        }catch ( Exception e){

        }

        try {
            path="datasource.xml";
            dataSourceBean=this.DataSourceXmlToBean(path);

        }catch (Exception e){

        }
        this.connector= ConnectorFactory.CreateConnector(url,userName,passWord);
    }

    private DataSourceBean DataSourceXmlToBean(String filePath) {
        String env = EnvManager.getEnv();

        try {
            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
            Document parse = Jsoup.parse(resourceAsStream, "UTF-8", "");
            Elements elements = parse.getElementsByTag("DataSourceBean");
            Iterator<Element> var6 = elements.iterator();

            Element element;
            String xmlCp;
            String xnlEnv;

            do {
                if(!var6.hasNext()){
                    return  null;
                }
                element=var6.next();
                xmlCp=element.getElementsByTag("connectorProfile").text();
                xnlEnv=element.getElementsByTag("env").text();

            }while((!StringUtils.isEmpty(this.connectorProfile)||
                    !StringUtils.equalsIgnoreCase("default",xmlCp)||
                    !StringUtils.equalsIgnoreCase(env,xnlEnv))&&
                    (!StringUtils.equalsIgnoreCase(this.connectorProfile,xmlCp) ||
                            !StringUtils.equalsIgnoreCase(env,xnlEnv)));
            String url = element.getElementsByTag("url").text();
            String userName = element.getElementsByTag("userName").text();
            String passWord = element.getElementsByTag("passWord").text();
            DataSourceBean dataSourceBean =new DataSourceBean();
            dataSourceBean.setConnectorProfile(this.connectorProfile);
            dataSourceBean.setEnv(env);
            dataSourceBean.setUrl(url);
            dataSourceBean.setUserName(userName);
            dataSourceBean.setPassWord(passWord);
            return dataSourceBean;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public DBResult query() throws SQLException {
        return null;
    }

    public static class Builder{
        private String connectorProfile;
       public Builder(){
       }
       public DBCapability.Builder connectorProfile(String connectorProfile){
           this.connectorProfile=connectorProfile;
           return this;
       }
       public DBCapability build(){
           return new DBCapability(this.connectorProfile);
       }
    }
}
