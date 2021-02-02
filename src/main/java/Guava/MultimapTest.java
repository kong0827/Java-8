package Guava;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Collection;

/**
 * @author xiangjin.kong
 * @date 2021/2/2 17:10
 * @desc 一个键 多个值
 */
public class MultimapTest {

    @Test
    public void test() {
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("k1", "v1");
        multimap.put("k2", "v2");
        multimap.put("k3", "v3");
        multimap.put("k3", "v4");
        multimap.put("k4", null);
        multimap.put(null, null);
        System.out.println(multimap.size());
        for (String key : multimap.keySet()) {
            Collection<String> strings = multimap.get(key);
            System.out.println(strings);
        }
    }
}
