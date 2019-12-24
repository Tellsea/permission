package cn.tellsea.walnut.util;

/**
 * 时间工具类
 *
 * @author Tellsea
 * @date 2019/12/16
 */
public class DateUtils {

    /**
     * 补全时间-时分秒
     *
     * @return
     */
    public static String completTimeBefor(String date) {
        return date.concat(" ").concat("00:00:00");
    }

    /**
     * 补全时间-时分秒
     *
     * @return
     */
    public static String completTimeAfter(String date) {
        return date.concat(" ").concat("23:59:59");
    }
}
