package Guava;

import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

/**
 * @author xiangjin.kong
 * @date 2021/2/2 16:51
 * @desc 基本数据类型
 */
public class IntsTest {

    @Test
    public void test() {
        // 快速转为集合
        List<Integer> list = Ints.asList(1, 3, 5, 76, 9);
        for (Integer integer : list) {
            System.out.println(integer);
        }

        // 原生类型数据快速合并
        int[] concat = Ints.concat(new int[]{12, 4, 6}, new int[]{4, 5, 6});
        System.out.println(concat.length);

        int max = Ints.max(concat);
        int min = Ints.min(concat);
        System.out.println("最大值：" + max + " 最小值：" + min);

        // 是否包含
        boolean contains = Ints.contains(concat, 5);
        System.out.println(contains);

        // 集合到数组的转换
        int[] ints = Ints.toArray(list);
        System.out.println(ints.length);
    }
}
