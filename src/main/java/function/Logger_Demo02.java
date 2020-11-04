package function;

/**
 * @author kxj
 * @date 2020/10/28 0:08
 * @desc 利用Lambda表达式对example01中的性能浪费的日志进行优化，当且仅当满足条件性才进行拼接
 */
public class Logger_Demo02 {

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "Java";
        int level = 2;

//        log(level, () -> msgA + msgB);
        // 验证Lambda表达式的延迟
        log(level, () -> {
            System.out.println("lambda表达式的执行");
            return msgA + msgB;
        });

    }

    private static void log(int level, MessageBuilder builder) {
        if (level == 1) {
            System.out.println(builder.buildMessage());
        }
    }
}

/**
 * 利用Lambda必然需要创建一个函数式接口
 */
@FunctionalInterface
interface MessageBuilder {
    /**
     * 字符串拼接
     * @return
     */
    String buildMessage();
}