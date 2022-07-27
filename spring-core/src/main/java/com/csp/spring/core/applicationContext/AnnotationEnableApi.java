package com.csp.spring.core.applicationContext;

import com.csp.spring.core.annotation.EnableAutoConfig;
import com.csp.spring.core.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/24
 */
@EnableAutoConfig
public class AnnotationEnableApi {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 标注@EnableAutoConfig
        applicationContext.register(AnnotationEnableApi.class);

        applicationContext.refresh();

        User bean = applicationContext.getBean(User.class);
        System.out.println(bean);

        applicationContext.close();
    }
}
