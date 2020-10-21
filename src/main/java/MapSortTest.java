import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.*;
import static java.util.Map.Entry.*;

/**
 * @author xiangjin.kong
 * @date 2020/10/21 19:41
 */
public class MapSortTest {

    /**
     * 按照Map的键进行排序
     */
    @Test
    public void MapKeySortTest() {
        // 创建一个Map，并填入数据
        Map<String, Integer> codes = new HashMap<>();
        codes.put("United States", 1);
        codes.put("Germany", 49);
        codes.put("France", 33);
        codes.put("China", 86);
        codes.put("Pakistan", 92);

        LinkedHashMap<String, Integer> sortedMap = codes.entrySet().stream().sorted(comparingByKey()).collect(Collectors.toMap(
                Entry::getKey,
                Entry::getValue,
                (oldVal, newVal) -> oldVal,
                LinkedHashMap::new
        ));
        // 将排序后的Map打印
        sortedMap.entrySet().forEach(System.out::println);
    }

    /**
     * 按照Map的value进行排序
     */
    @Test
    public void MapValueTest() {
        Map<String, Integer> codes = new HashMap<>();
        codes.put("United States", 1);
        codes.put("Germany", 49);
        codes.put("France", 33);
        codes.put("China", 86);
        codes.put("Pakistan", 92);

        LinkedHashMap<String, Integer> sortedMap = codes.entrySet().stream().sorted(comparingByValue()).collect(Collectors.toMap(Entry::getKey,
                Entry::getValue,
                (oldVal, newVal) -> oldVal,
                LinkedHashMap::new));
        sortedMap.entrySet().forEach(System.out::println);

    }

    /**
     * TreeSet排序
     */
    @Test
    public void test() {
        Map<String, Integer> codes = new HashMap<>();
        codes.put("United States", 1);
        codes.put("Germany", 49);
        codes.put("France", 33);
        codes.put("China", 86);
        codes.put("Pakistan", 92);
        Map<String, Integer> sortedMap = new TreeMap<>(codes);
        sortedMap.entrySet().forEach(System.out::println);
    }
}
