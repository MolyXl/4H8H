package com.shbh.common.file;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import java.util.Map;

public class FileStorageCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

       Map<String, Object> attrs = metadata.getAnnotationAttributes(Component.class.getName());
        if(attrs==null || attrs.isEmpty()){
            return false;
        }
        String storage = attrs.get("value").toString();
        return context.getEnvironment().getProperty("file.storage.type").equals(storage);
       //return true;
    }

}