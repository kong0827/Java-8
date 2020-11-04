package function;

import java.util.function.Consumer;

/**
 * @author kxj
 * @date 2020/11/4 23:08
 * @desc
 *
 * java.util.function.Consumer<T> 接口则正好与Supplier接口相反，它不是生产一个数据，而是消费一个数据，
 * 其数据类型由泛型决定
 *
 * Consumer 接口中包含抽象方法 void accept(T t) ，意为消费一个指定泛型的数据
 */
public class Consumer_Demo01 {

    private static void consumerString(Consumer<String> consumer) {
        consumer.accept("hello");
    }

    public static void main(String[] args) {
        consumerString(System.out::println);
//   等价于    consumerString(s -> System.out.println(s));
    }
}
