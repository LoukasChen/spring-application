package com.csp.spring.core.annotation;

import com.csp.spring.core.config.AutoConfig;
import com.csp.spring.core.config.AutoConfigImportBeanDefinitionRegistrar;
import com.csp.spring.core.config.AutoConfigImportSelector;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/24
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(AutoConfig.class)
//@Import(AutoConfigImportSelector.class)
@Import(AutoConfigImportBeanDefinitionRegistrar.class)
public @interface EnableAutoConfig {
}
