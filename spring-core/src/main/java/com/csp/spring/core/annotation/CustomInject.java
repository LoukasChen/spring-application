package com.csp.spring.core.annotation;

import java.lang.annotation.*;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/3
 */
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomInject {
}
