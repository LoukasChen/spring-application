package com.csp.webflux.client.framework;

import com.csp.webflux.client.framework.proxy.ProxyCreator;
import com.csp.webflux.client.framework.service.IUserApi;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @desc:
 * @author: csp
 * @date: 2023/12/7
 */
@SpringBootApplication
public class WebfluxClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxClientApplication.class, args);
    }

    @Bean
    FactoryBean<IUserApi> userApi(ProxyCreator proxyCreator) {
        return new FactoryBean<IUserApi>() {
            @Override
            public IUserApi getObject() throws Exception {
                return (IUserApi) proxyCreator.createProxy(IUserApi.class);
            }

            @Override
            public Class<?> getObjectType() {
                return IUserApi.class;
            }
        };
    }
}
