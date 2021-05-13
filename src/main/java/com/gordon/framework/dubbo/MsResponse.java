package com.gordon.framework.dubbo;

public class MsResponse {
    private Object rawData;
    public MsResponse() {
    }

    public Object getRawData() {
        return rawData;
    }

    public void setRawData(Object rawData) {
        this.rawData = rawData;
    }
    public String toPrettyString(){
        return super.toString();
    }
}
