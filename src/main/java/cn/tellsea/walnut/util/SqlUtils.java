package cn.tellsea.walnut.util;

/**
 * @author Tellsea
 * @date 2019/12/17
 */
public class SqlUtils {

    public static String like(String value) {
        return " '%".concat(value).concat("%' ");
    }

    public static boolean isNotEmpty(Integer value) {
        if (value != null && value > 0) {
            return true;
        }
        return false;
    }
}
