package cn.feiyue.desensitization.annotation;

import cn.feiyue.desensitization.SensitiveTypeEnum;
import cn.feiyue.desensitization.utils.DesensitizationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @Description
 * @Date 2020-08-26 12:45
 * @Created by zfy
 */

public class DesensitizationFormatter implements Formatter<String> {
    private SensitiveTypeEnum typeEnum;

    public SensitiveTypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(SensitiveTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    @Override
    public String parse(String valueStr, Locale locale) throws ParseException {
        if (StringUtils.isNotBlank(valueStr)) {
            switch (typeEnum) {
                case ID_CARD:
                    valueStr = DesensitizationUtils.hiddenIdCard(valueStr);
                    break;
                case PHONE:
                    valueStr = DesensitizationUtils.hiddenPhone(valueStr);
                    break;
                case PLATE_NUM:
                    valueStr = DesensitizationUtils.hiddenPlateNum(valueStr);
                    break;
                default:
            }
        }
        return valueStr;
    }

    @Override
    public String print(String s, Locale locale) {
        return s;
    }

}
