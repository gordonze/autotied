package com.gordon.framework.dubbo.client;

public class DubboRegistryConfig {
    private static final String DEFAULT_PROROCOL_STABLE = "groupzookeeper";
    private static final String DEFSULT_PROTOCOL = "zookeeper";
    private String registryAddress;
    private String protocol;
    private String groupId;

    public DubboRegistryConfig() {

    }

    public DubboRegistryConfig(String registryAddress, String protocol, String groupId) {
        this.registryAddress = registryAddress;
        this.protocol = protocol;
        this.groupId = groupId;
    }

    public void init() {


    }

    public static String getDefaultProrocolStable() {
        return DEFAULT_PROROCOL_STABLE;
    }

    public static String getDefsultProtocol() {
        return DEFSULT_PROTOCOL;
    }

    public String getRegistryAddress() {
        return registryAddress;
    }

    public void setRegistryAddress(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
