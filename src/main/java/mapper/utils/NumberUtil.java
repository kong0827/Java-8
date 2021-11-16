package mapper.utils;

import java.util.UUID;

/**
 * @author xiangjin.kong
 * @date 2021/11/16 17:44
 */
public class NumberUtil {

    public static String init() {
        return UUID.randomUUID().toString();
    }
}
