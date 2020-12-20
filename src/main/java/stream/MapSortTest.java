package stream;

import entity.Employee;
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

    @Test
    public void testMerge() {
        Map<String, Employee> map1 = new HashMap<String, Employee>();
        Employee employee1 = new Employee();
        employee1.setAge(1);
        employee1.setLastName("小明");

        Employee employee2 = new Employee();
        employee2.setAge(1);
        employee2.setLastName("小张");

        map1.put("小明", employee1);
        map1.put(employee2.getLastName(), employee2);


        Map<String, Employee> map2 = new HashMap<String, Employee>();
        Employee employee3 = new Employee();
        employee3.setAge(2);
        employee3.setLastName("小明");

        Employee employee4 = new Employee();
        employee4.setAge(1);
        employee4.setLastName("小强");

        map2.put(employee3.getLastName(), employee3);
        map2.put(employee4.getLastName(), employee4);

        Map<String, Employee> result = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (value1, value2) -> {

                            Employee employee = new Employee();
                            int age = value2.getAge();
                            if (value1.getAge() >= value2.getAge()) {
                                age = value1.getAge();
                            }
                            employee.setLastName(value1.getLastName());
                            employee.setAge(age);

                            return employee;
                        }
                ));


        System.out.println(result);


    }
}
