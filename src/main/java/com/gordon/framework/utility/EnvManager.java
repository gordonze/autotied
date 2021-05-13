package com.gordon.framework.utility;

import com.gordon.framework.controller.Context;
import com.gordon.framework.controller.ContextManager;

public class EnvManager {
    public EnvManager() {
    }
    public static String getPool(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getPool();
    }
    public static String getDomain(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getDomain();
    }

    public static String getUrlConverterClass(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getUrlConverterClass();
    }
    public static String getZkUrl(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getZkUrl();
    }
    public static String getEnv(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getEnv();
    }
    public static String getDbUrlPre(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getDbUrlPre();
    }
    public static String getDbCapablility(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getDbCapablility();
    }
    public static String getGroupId(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getGroupId();
    }
    public static String getZkUrlConverterClass(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getZkUrlConverterClass();
    }
    public static String getDbUrlConverterClass(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getDbUrlConverterClass();
    }
        public static String getMqUrlConverterClass(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getMqUrlConverterClass();
    }
        public static String getSecretConfifFilePath(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getSecretConfifFilePath();
    }
        public static String getAttribute(){
        Context context = ContextManager.getThreadContext() == null ? ContextManager.getSuitContext() :ContextManager.getThreadContext();
        return context==null?null:context.getAttribute();
    }


}
