package function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author kxj
 * @date 2020/11/4 23:45
 * @desc 数组当中有多条“姓名+性别”的信息如下，请通过 Predicate 接口的拼装将符合要求的字符串筛选到集合
 * ArrayList 中，需要同时满足两个条件：
 * 1. 必须为女生；
 * 2. 姓名为4个字
 */
public class Predicate_Demo04 {

    public static void main(String[] args) {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};
        List<String> list = method(s -> s.split(",")[0].length() == 4, s -> s.split(",")[1].equals("女"), array);
        System.out.println(list);

    }

    private static List<String>  method(Predicate<String> one, Predicate<String> two, String[] array) {
        List<String> list = new ArrayList<>();
        for (String s : array) {
            boolean test = one.and(two).test(s);
            if (test) {
                list.add(s);
            }
        }
        return list;
    }
}
