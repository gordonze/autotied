package com.gordon.framework.dubbo;

public class Consumer {
    private String consumerName =  "gordon-test";
    private String consumerVersion="1.0";

    public Consumer() {
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerVersion() {
        return consumerVersion;
    }

    public void setConsumerVersion(String consumerVersion) {
        this.consumerVersion = consumerVersion;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "consumerName='" + consumerName + '\'' +
                ", consumerVersion='" + consumerVersion + '\'' +
                '}';
    }
}
