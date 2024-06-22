package com.csp.webflux.client.framework.proxy;

/**
 * @desc: 创建代理类接口
 * @author: csp
 * @date: 2023/12/7
 */
public interface ProxyCreator {
    /***
     * 创建代理类
     * @param type
     * @return
     */
    Object createProxy(Class<?> type);
}
