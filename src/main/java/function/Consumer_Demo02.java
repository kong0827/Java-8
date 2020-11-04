package function;

import java.util.function.Consumer;

/**
 * @author kxj
 * @date 2020/11/4 23:14
 * @desc
 *
 * 如果一个方法的参数和返回值全都是 Consumer 类型，那么就可以实现效果：消费数据的时候，首先做一个操作，
 * 然后再做一个操作，实现组合。而这个方法就是 Consumer 接口中的default方法 andThen
 *
 */
public class Consumer_Demo02 {

    private static void consumerString(Consumer<String> one, Consumer<String> two) {
        one.andThen(two).accept("hello");
    }

    public static void main(String[] args) {
        consumerString(s -> System.out.println(s.toLowerCase()), s -> System.out.println(s.toUpperCase()));
    }

}
