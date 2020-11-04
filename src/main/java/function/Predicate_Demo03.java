package function;

import java.util.function.Predicate;

/**
 * @author kxj
 * @date 2020/11/4 23:43
 * @desc 。默认方法 negate ，它是执行了test方法之后，对结果boolean值进行“!”取反而已。一定要在 test 方法调用之前
 * 调用 negate 方法，正如 and 和 or 方法一样
 */
public class Predicate_Demo03 {

    private static void method(Predicate<String> predicate) {
        boolean veryLong = predicate.negate().test("HelloWorld");
        System.out.println("字符串很长吗：" + veryLong);
    }

    public static void main(String[] args) {
        method(s -> s.length() < 5);
    }
}
