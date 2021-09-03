package cn.feiyue.desensitization.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * @Description
 * @Date 2020-08-26 10:44
 * @Created by zfy
 */
public class DesensitizationUtils {

    public static String hiddenPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return "";
        }
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    public static String hiddenPlateNum(String plateNum) {
        if (StringUtils.isBlank(plateNum)) {
            return "";
        }
        return plateNum.substring(0, 3) + "*" + plateNum.substring(4, plateNum.length());
    }

    public static String hiddenIdCard(String idCard) {
        if (StringUtils.isBlank(idCard)) {
            return "";
        }
        return StringUtils.left(idCard, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(idCard, 4), StringUtils.length(idCard), "*"), "***"));
    }

}
