package function;

/**
 * @author kxj
 * @date 2020/10/28 0:02
 * @desc 性能浪费的日志案例
 *
 * 如下代码存在性能浪费问题
 * 无论级别是否满足要求，作为log的第二个参数都会进行拼接运算然后传入方法内
 */
public class Example01_Logger {

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "Java";
        int level = 1;

        log(level, msgA + msgB);
    }

    private static void log(int level, String msg) {
        if (level == 1) {
            System.out.println(msg);
        }
    }

}
