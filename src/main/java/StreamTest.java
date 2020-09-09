import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xiangjin.kong
 * @date 2020/9/9 19:07
 */
public class StreamTest {

    /**
     * forEach 和 ForEachOrdered 测试
     * parallel()函数表示对管道进行并行处理，非串行处理，处理速度更快，不保证元素的顺序
     * ForEachOrdered 数据处理顺序上可能无法保障，但是forEachOrdered方法可以在元素输出的顺序上保证与元素进入管道流的顺序一致
     */
    @Test
    public void forEachTest() {
        List<String> list = Arrays.asList("zhangsan", "lisi", "wanger", "zhangsanfeng");

        list.stream().parallel().forEach(System.out::println);

        list.stream().parallel().forEachOrdered(System.out::println);

    }


    /**
     * collect()方法 将管道流处理结果在转换成集合类
     */
    @Test
    public void collectTest() {
        List<String> list = Arrays.asList("zhangsan", "lisi", "zhangsan", "wanger", "zhangsanfeng");

        Set<String> set = list.stream().collect(Collectors.toSet());
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("--------------");

        List<String> collect = list.stream().collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
    }
}
