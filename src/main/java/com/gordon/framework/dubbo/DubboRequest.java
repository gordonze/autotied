package com.gordon.framework.dubbo;

import com.gordon.framework.dubbo.client.DubboRegistryConfig;
import com.gordon.framework.dubbo.client.InvokeClient;
import com.gordon.framework.dubbo.client.impl.DubboClientImpl;

import java.util.ArrayList;
import java.util.List;

public class DubboRequest extends MsRequest {

    private InvokeClient invokeClient = new DubboClientImpl();
    private String interFaceName;
    private String methodName;
    private String group;
    private List<String> paramTypes = new ArrayList<>();
    private List<Object> paramValues = new ArrayList<>();
    private DubboRegistryConfig dubboRegistryConfig;
    private Consumer consumer;

    public DubboRequest() {
    }

    //请求invoke
    public DubboResponse invoke() throws Exception {
        return (DubboResponse) this.invokeClient.invoke(this);
    }

    //销毁
    public void destory() {
        this.invokeClient.destroy();
    }

    public String toPrettyString() {
        StringBuilder builder = new StringBuilder();
        builder.append("|request 信息：\n dubboRegistry").append(this.getDubboRegistryConfig().toString()).append("\n");
        builder.append("|interfacename: \n").append(this.getInterFaceName()).append("\n");
        builder.append("|methodName: \n").append(this.getMethodName()).append("\n");
        builder.append("|paramType: \n").append(this.getParamTypes()).append("\n");
        builder.append(this.getParamValuesToString()).append("\n");
        return builder.toString();
    }

    public String getParamValuesToString() {
        return null;
    }

    public InvokeClient getInvokeClient() {
        return invokeClient;
    }

    public void setInvokeClient(InvokeClient invokeClient) {
        this.invokeClient = invokeClient;
    }

    public String getInterFaceName() {
        return interFaceName;
    }

    public void setInterFaceName(String interFaceName) {
        this.interFaceName = interFaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(List<String> paramTypes) {
        this.paramTypes = paramTypes;
    }

    public List<Object> getParamValues() {
        return paramValues;
    }

    public void setParamValues(List<Object> paramValues) {
        this.paramValues = paramValues;
    }

    public DubboRegistryConfig getDubboRegistryConfig() {
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
}
