package com.study.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

public class MyConfigurationPropertiesImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MultiValueMap<String, Object> allAnnotationAttributes = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties.class.getName());
        assert allAnnotationAttributes != null;
        Class propertyClass = (Class)allAnnotationAttributes.getFirst("value");
        assert propertyClass != null;
        return new String[] {propertyClass.getName()};
    }
}
