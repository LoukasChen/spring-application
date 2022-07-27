package com.csp.application.util;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;

import java.lang.annotation.Annotation;

public abstract class WebUtils {

    public static void validate(WebDataBinder binder, MethodParameter parameter) throws Exception {
        Annotation[] annotations = parameter.getParameterAnnotations();
        for (Annotation ann : annotations) {
            if (ann.annotationType().getSimpleName().startsWith("Valid")) {
                Object hints = AnnotationUtils.getValue(ann);
                binder.validate(hints instanceof Object[] ? (Object[]) hints : new Object[]{hints});
                BindingResult bindingResult = binder.getBindingResult();
                if (bindingResult.hasErrors()) {
                    if (isBindExceptionRequired(binder, parameter)) {
                        throw new MethodArgumentNotValidException(parameter, bindingResult);
                    }
                }
                break;
            }
        }
    }

    private static boolean isBindExceptionRequired(WebDataBinder binder, MethodParameter parameter) {
        int i = parameter.getParameterIndex();
        Class<?>[] paramTypes = parameter.getMethod().getParameterTypes();
        boolean hasBindingResult = (paramTypes.length > (i + 1) && Errors.class.isAssignableFrom(paramTypes[i + 1]));

        return !hasBindingResult;
    }

}
