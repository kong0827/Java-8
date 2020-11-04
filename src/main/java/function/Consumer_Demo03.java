package function;

import java.util.function.Consumer;

/**
 * @author kxj
 * @date 2020/11/4 23:18
 * @desc 下面的字符串数组当中存有多条信息，请按照格式“ 姓名：XX。性别：XX。 ”的格式将信息打印出来。要求将打印姓
 * 名的动作作为第一个 Consumer 接口的Lambda实例，将打印性别的动作作为第二个 Consumer 接口的Lambda实
 * 例，将两个 Consumer 接口按照顺序“拼接”到一起
 */
public class Consumer_Demo03 {

    private static void printInfo(Consumer<String> one, Consumer<String> two, String[] array) {
        for (String info : array) {
            one.andThen(two).accept(info);
        }
    }

    public static void main(String[] args) {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};
        printInfo(s -> System.out.print("姓名：" + s.split(",")[0]), s -> System.out.println("。性别：" + s.split(",")[1]), array);
    }
}
