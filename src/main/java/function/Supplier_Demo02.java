package function;

import java.util.function.Supplier;

/**
 * @author kxj
 * @date 2020/10/28 0:24
 * @desc
 *
 * 使用Supplier接口作为方法的参数类型，通过Lambda表达式求int数组中的最大值，
 */
public class Supplier_Demo02 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 3, 2, 8, 6};

        int maxNumber = getMaxNumber(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(maxNumber);
    }

    private static int getMaxNumber(Supplier<Integer> supplier) {
        return supplier.get();
    }
}
