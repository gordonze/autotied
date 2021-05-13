package com.gordon.framework.dubbo;

public class DubboResponse extends MsResponse {
    private Object rawData;

    public DubboResponse() {
    }

    public <T> T value(Class<T> type){
        this.rawData=this.getRawData();
        return this.rawData==null?null:type.cast(this.rawData);
    }
    public String toPrettyString(){
        StringBuilder builder=new StringBuilder();
        builder.append("response rowData").append(this.rawData).append("\n");
        return builder.toString();
    }
}
