package function;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author kxj
 * @date 2021/3/3 23:52
 * @desc
 */
public class Consumer_Demo04 {
    public static void main(String[] args) {
        Consumer consumer = x -> System.out.println("accept param is：" + x);
        consumer.accept(10);
    }

    @Test
    public void test() {
        consumer(s-> System.out.println(s));
        consumer(System.out::println);
    }

    void consumer(Consumer<Integer> consumer) {
        consumer.accept(10);
    }

}
