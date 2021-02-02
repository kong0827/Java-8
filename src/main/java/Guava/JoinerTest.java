package Guava;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiangjin.kong
 * @date 2021/2/2 16:21
 * @desc 连接器
 */
public class JoinerTest {

    /**
     * 测试链接
     * Joiner
     */
    @Test
    public void test() {
        // 用','连接，跳过null
        Joiner joiner = Joiner.on(",").skipNulls();
        String join = joiner.join("a", "b", null, "c");
        System.out.println(join);

        Joiner joiner1 = Joiner.on("").skipNulls();
        join = joiner1.join("a", "b", null, "c");
        System.out.println(join);

        final String[] input = new String[]{"dave", "john", "dan", "matt"};
        final String result = Joiner.on(",")
                .join(input);
        System.out.println(result);

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder str = Joiner.on(",").appendTo(stringBuilder, input);
        System.out.println(str);


        Map<String, String> map = new HashMap<String, String>() {{
            put("param", "v");
            put("p2", "v2");
            put("q", "java");
        }};

        String res = Joiner.on("&")
                .withKeyValueSeparator("=")
                .join(map);
        System.out.println(res);
    }
}
