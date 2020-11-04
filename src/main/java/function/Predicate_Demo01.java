package function;

import java.util.function.Predicate;

/**
 * @author kxj
 * @date 2020/11/4 23:30
 * @desc 有时候我们需要对某种类型的数据进行判断，从而得到一个boolean值结果。这时可以使用
 * java.util.function.Predicate<T> 接口。
 */
public class Predicate_Demo01 {

//    Predicate 接口中包含一个抽象方法： boolean test(T t)

    private static void method(Predicate<String> predicate) {
        boolean test = predicate.test("helloworld");
        System.out.println("字符串的长度是否大于5：" + test);
    }

    public static void main(String[] args) {
        method(s -> s.length() > 5);
    }

}
