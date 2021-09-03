package cn.feiyue.desensitization.annotation;

/**
 * @Description
 * @Date 2020-08-26 12:33
 * @Created by zfy
 */


import cn.feiyue.desensitization.SensitiveTypeEnum;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
public @interface Desensitization {

    //脱敏类型
    SensitiveTypeEnum type();

}
