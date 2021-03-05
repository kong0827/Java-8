package function;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author kxj
 * @date 2021/3/4 0:00
 * @desc 提供型接口
 */
public class Supplier_Demo04 {
    public static void main(String[] args) {
        Supplier<? extends Integer> supplier = () -> (int) (Math.random() * 10);
        System.out.println(supplier.get());
    }

    @Test
    public void test() {
        int supplier = supplier(() ->(int) (Math.random() * 10));
        System.out.println(supplier);
    }

    int supplier(Supplier<Integer> supplier) {
        return supplier.get();
    }
}
