package Guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

/**
 * @author xiangjin.kong
 * @date 2021/2/2 17:20
 * @desc 可以根据ke->value 也可以根据value->key
 * 要求value也是唯一的
 */
public class BiMapTest {

    @Test
    public void test() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("k1", "v1");
        biMap.put("k2", "v2");
        biMap.put("k3", "v3");
        for (String s : biMap.keySet()) {
            System.out.println(biMap.get(s));
        }
        // 翻转key 和 value
        String v3 = biMap.inverse().get("v3");
        System.out.println(v3);
    }
}
