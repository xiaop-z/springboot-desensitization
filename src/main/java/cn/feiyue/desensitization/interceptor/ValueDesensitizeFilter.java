package cn.feiyue.desensitization.interceptor;

import cn.feiyue.desensitization.SensitiveTypeEnum;
import cn.feiyue.desensitization.annotation.Desensitization;
import cn.feiyue.desensitization.utils.DesensitizationUtils;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.lang.reflect.Field;

/**
 * @Description
 * @Date 2020-08-26 13:46
 * @Created by zfy
 */
public class ValueDesensitizeFilter implements ValueFilter {
    @Override
    public Object process(Object object, String name, Object value) {
        if (Page.class == object.getClass())//mybatis-plus的分页返回current、size、pages..的是long类型,不应该作为字符串处理,所以直接返回
            return value;
        if (value instanceof Long)//其余的字符串是long类型的应作为字符串处理,主要是那些id,项目中若有其他字段是Long类型的话,可以写逻辑判断类、字段
            return value + "";
        if (null == value || !(value instanceof String) || ((String) value).length() == 0) {
            return value;
        }
        try {
            Field field = object.getClass().getDeclaredField(name);
            Desensitization desensitization;
            if (String.class != field.getType() || (desensitization = field.getAnnotation(Desensitization.class)) == null) {
                return value;
            }
            String valueStr = (String) value;
            SensitiveTypeEnum type = desensitization.type();
            switch (type) {
                case ID_CARD:
                    return DesensitizationUtils.hiddenIdCard(valueStr);
                case PHONE:
                    return DesensitizationUtils.hiddenPhone(valueStr);
                case PLATE_NUM:
                    return DesensitizationUtils.hiddenPlateNum(valueStr);
                default:
            }
        } catch (NoSuchFieldException e) {
            return value;
        }
        return value;
    }
}
