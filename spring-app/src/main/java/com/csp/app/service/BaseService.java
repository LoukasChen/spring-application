package com.csp.app.service;

import com.csp.app.util.Base64Util;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @description:
 * @author: csp52872
 * @date: 2020/11/21
 */
public abstract class BaseService implements InitializingBean, DisposableBean {

    static Base64Util base64Util = new Base64Util();

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("实例代码块");
    }

    public BaseService() {
        System.out.println("构造方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }
}
