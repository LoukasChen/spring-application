package com.csp.spring.core.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/24
 */
public class AutoConfigImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.csp.spring.core.config.AutoConfig"};
    }
}
