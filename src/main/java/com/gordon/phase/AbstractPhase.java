package com.gordon.phase;

import com.gordon.framework.config.FrameworkConfigBean;
import com.gordon.utils.ClassUtil;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPhase {
    @Autowired
    protected FrameworkConfigBean frameworkConfigBean;

    public static <T extends AbstractPhase> T getInstance(Class<T> cls){
        return ClassUtil.newInstance(cls);
    }
}
