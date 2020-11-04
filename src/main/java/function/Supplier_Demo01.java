package function;

import java.util.function.Supplier;

/**
 * @author kxj
 * @date 2020/10/28 0:16
 * @desc java.util.function.Supplier<T> 接口中只包含一个无参的方法：T get(),用来获取一个泛型参数指定类型的对象数据。
 * 由于是一个函数式接口，意味着对应的Lambda表达式需要对外提供一个符合泛型类型的对象数据
 */
public class Supplier_Demo01 {
    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "Java";
        String s = getString(() -> msgA + msgB);
        System.out.println(s);
    }

    private static String getString(Supplier<String> function) {
        return function.get();
    }
}

