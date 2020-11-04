package function;

import java.util.function.Function;

/**
 * @author kxj
 * @date 2020/11/5 0:13
 * @desc
 *
 * Function 接口中有一个默认的 andThen 方法，用来进行组合操作
 */
public class Function_Demo02 {

    private static void method(Function<String, Integer> one, Function<Integer, Integer> two) {
        Integer integer = one.andThen(two).apply("10");
        System.out.println(integer);
    }
    public static void main(String[] args) {
        // 第一个操作是将字符串解析成为int数字，第二个操作是乘以10。两个操作通过 andThen 按照前后顺序组合到了一起。
        method(s -> Integer.valueOf(s) + 10, i -> i *= 10);
    }

}
