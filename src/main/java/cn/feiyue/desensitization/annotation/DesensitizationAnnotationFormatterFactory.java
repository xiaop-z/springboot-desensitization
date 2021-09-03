package cn.feiyue.desensitization.annotation;


import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Date 2020-08-26 12:38
 * @Created by zfy
 */

public class DesensitizationAnnotationFormatterFactory implements AnnotationFormatterFactory<Desensitization> {



    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> hashSet = new HashSet<>();
        hashSet.add(String.class);
        return hashSet;
    }

    @Override
    public Printer<?> getPrinter(Desensitization annotation, Class<?> fieldType) {
        return getFormatter(annotation);
    }

    @Override
    public Parser<?> getParser(Desensitization annotation, Class<?> fieldType) {
        return getFormatter(annotation);
    }

    private DesensitizationFormatter getFormatter(Desensitization desensitization) {
        DesensitizationFormatter formatter = new DesensitizationFormatter();
        formatter.setTypeEnum(desensitization.type());
        return formatter;
    }
}
