package com.gordon.framework.dubbo.client;

import com.gordon.framework.dubbo.MsRequest;
import com.gordon.framework.dubbo.MsResponse;

public interface InvokeClient {
    MsResponse invoke(MsRequest msRequest) throws Exception;

    void destroy();
}
