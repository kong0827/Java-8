package function;

import java.awt.*;
import java.util.function.Predicate;

/**
 * @author kxj
 * @date 2020/11/4 23:35
 * @desc
 *
 * 既然是条件判断，就会存在与、或、非三种常见的逻辑关系。其中将两个 Predicate 条件使用“与”逻辑连接起来实
 * 现“并且”的效果时，可以使用default方法 and
 */
public class Predicate_Demo02 {

    //    如果要判断一个字符串既要包含大写“H”，又要包含大写“W”，
    private static void method(Predicate<String> one, Predicate<String> two, String arg) {
        boolean isValid = one.and(two).test(arg);
        System.out.println("字符串是否符合要求：" + isValid);
    }

    public static void main(String[] args) {
        String arg = "HelloWord";
        method(s -> s.contains("H"), s -> s.contains("W"), arg);
        method01(s -> s.contains("H"), s -> s.contains("W"), arg);
    }

    // 如果要判断一个字符串既要包含大写“H”或包含大写“W”
    private static void method01(Predicate<String> one, Predicate<String> two, String arg) {
        boolean isValid = one.or(two).test(arg);
        System.out.println("字符串是否符合要求：" + isValid);
    }
}
