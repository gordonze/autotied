package com.gordon.framework.dubbo.api;

import com.gordon.framework.dubbo.Consumer;
import com.gordon.framework.dubbo.DubboRequest;
import com.gordon.framework.dubbo.client.DubboRegistryConfig;

public abstract  class FacadeAPI {
    private String interfaceName;
    private DubboRegistryConfig dubboRegistryConfig;
    private Consumer consumer;

    public FacadeAPI() {
    }

    public FacadeAPI(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public FacadeAPI(String interfaceName, DubboRegistryConfig dubboRegistryConfig, Consumer consumer) {
        this.interfaceName = interfaceName;
        this.dubboRegistryConfig = dubboRegistryConfig;
        this.consumer = consumer;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public DubboRegistryConfig getDubboRegistryConfig() {
        if(this.dubboRegistryConfig==null){
            DubboRegistryConfig dubboRegistryConfig = new DubboRegistryConfig();
            dubboRegistryConfig.init();

        }
        return dubboRegistryConfig;
    }

    public void setDubboRegistryConfig(DubboRegistryConfig dubboRegistryConfig) {
        this.dubboRegistryConfig = dubboRegistryConfig;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
    protected DubboRequest buildBaseRequest(){
        DubboRequest dubboRequest=new DubboRequest();
        dubboRequest.setInterFaceName(this.getInterfaceName());
        dubboRequest.setDubboRegistryConfig(this.getDubboRegistryConfig());
        dubboRequest.setConsumer(this.getConsumer());
        return dubboRequest;
    }
}
