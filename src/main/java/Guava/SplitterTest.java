package Guava;

import com.google.common.base.Splitter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author xiangjin.kong
 * @date 2021/2/2 16:44
 * @desc 分割器
 */
public class SplitterTest {

    @Test
    public void test() {
        Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();
        for (String s : splitter.split("a, b    , c  d")) {
            System.out.println(s);
        }

        String input = "apple - banana - orange";
        List<String> result = Splitter.on("-").trimResults()
                .splitToList(input);

        System.out.println(result);

        input = "John=first,Adam=second";
        Map<String, String> res = Splitter.on(",")
                .withKeyValueSeparator("=")
                .split(input);

        System.out.println(res);
    }
}
