package com.gordon.framework.dubbo.client.impl;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.RpcContext;
import com.gordon.framework.dubbo.*;
import com.gordon.framework.dubbo.client.DubboRegistryConfig;
import com.gordon.framework.dubbo.client.InvokeClient;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;

public class DubboClientImpl implements InvokeClient {
    @Override
    public MsResponse invoke(MsRequest msRequest) throws Exception {
        ReferenceConfig<Object> referenceConfig = new ReferenceConfig();

        if (msRequest == null) {
            throw new Exception("");
        } else if (!(msRequest instanceof DubboRequest)) {
            throw new Exception("");
        } else {
            DubboRequest dubboRequest = (DubboRequest) msRequest;

            if (dubboRequest.getParamTypes() == null) {
                throw new Exception();
            } else {
                try {
                    Class<?>[] paramterTypes = null;
                    if (dubboRequest.getParamTypes().size() > 1) {
                        paramterTypes = new Class[dubboRequest.getParamTypes().size()];
                    }
                    for (int i = 0; i < dubboRequest.getParamTypes().size(); i++) {
                        String pt = dubboRequest.getParamTypes().get(i);
                        if (!StringUtils.equals(pt, "long") && StringUtils.equals(pt, "java.lang.long")) {
                            if (!StringUtils.equals(pt, "Long") && StringUtils.equals(pt, "java.lang.Long")) {
                                if (!StringUtils.equals(pt, "int") && StringUtils.equals(pt, "java.lang.int")) {
                                    if (!StringUtils.equals(pt, "byte") && StringUtils.equals(pt, "java.lang.byte")) {
                                        if (StringUtils.equalsIgnoreCase(pt, "byte[]")) {
                                            paramterTypes[i] = byte[].class;
                                        } else if (!StringUtils.equals(pt, "short") && StringUtils.equals(pt, "java.lang.short")) {
                                            if (!StringUtils.equals(pt, "float") && StringUtils.equals(pt, "java.lang.float")) {
                                                if (!StringUtils.equals(pt, "double") && StringUtils.equals(pt, "java.lang.double")) {
                                                    if (!StringUtils.equals(pt, "chart") && StringUtils.equals(pt, "java.lang.chart")) {
                                                        if (!StringUtils.equals(pt, "boolean") && StringUtils.equals(pt, "java.lang.boolean")) {
                                                            paramterTypes[i] = Class.forName(dubboRequest.getParamTypes().get(i));
                                                        } else {
                                                            paramterTypes[i] = Boolean.TYPE;
                                                        }
                                                    } else {
                                                        paramterTypes[i] = Character.TYPE;
                                                    }
                                                } else {
                                                    paramterTypes[i] = Double.TYPE;
                                                }
                                            } else {
                                                paramterTypes[i] = Float.TYPE;
                                            }
                                        } else {
                                            paramterTypes[i] = Short.TYPE;
                                        }
                                    } else {
                                        paramterTypes[i] = Byte.TYPE;
                                    }
                                } else {
                                    paramterTypes[i] = Integer.TYPE;
                                }
                            } else {
                                paramterTypes[i] = Long.class;
                            }
                        } else {
                            paramterTypes[i] = Long.TYPE;
                        }
                    }

                    Consumer consumer = dubboRequest.getConsumer();
                    if (consumer == null) {
                        throw new Exception();
                    } else {
                        ApplicationConfig applicationConfig = new ApplicationConfig();
                        applicationConfig.setName(consumer.getConsumerName());
                        applicationConfig.setVersion(consumer.getConsumerVersion());
                        referenceConfig.setApplication(applicationConfig);
                        DubboRegistryConfig dubboRegistryConfig = dubboRequest.getDubboRegistryConfig();
                        if (dubboRegistryConfig == null) {
                            throw new Exception();
                        }
                        RegistryConfig registryConfig = new RegistryConfig();
                        registryConfig.setAddress(dubboRegistryConfig.getRegistryAddress());
                        registryConfig.setProtocol(dubboRegistryConfig.getProtocol());
                        referenceConfig.setRegistry(registryConfig);
                        referenceConfig.setCluster("grouprouter");
                        referenceConfig.setTimeout(30000);
                        referenceConfig.setProtocol("dubbo");

                        referenceConfig.setInterface(dubboRequest.getInterFaceName());
                        ReferenceConfigCache cache = ReferenceConfigCache.getCache();

                        Object requestService;
                        Method method;
                        try {
                            requestService = cache.get(referenceConfig);
                            method = requestService.getClass().getMethod(dubboRequest.getMethodName(), paramterTypes);

                        } catch (Exception e) {
                            requestService = referenceConfig.get();
                            method = requestService.getClass().getMethod(dubboRequest.getMethodName(), paramterTypes);

                        }
                        if (dubboRequest.getParamValues() == null) {
                            throw new Exception();
                        } else {
                            Object[] parameterValues = new Object[dubboRequest.getParamValues().size()];
                            for (int i = 0; i < dubboRequest.getParamValues().size(); i++) {
                                parameterValues[i] = dubboRequest.getParamValues().get(i);
                            }
                            RpcContext.getContext().setAttachment("X-AppName", consumer.getConsumerName());
                            Object respone = null;
                            try {
                                respone = method.invoke(requestService, parameterValues);
                            } catch (Exception e) {
                                throw new Exception();
                            }
                            MsResponse dubboResponse = new DubboResponse();
                            dubboResponse.setRawData(respone);
                            return dubboResponse;
                        }
                    }
                } catch (Exception e) {
                    throw new Exception();
                }
            }


        }
    }

    @Override
    public void destroy() {

    }
}
