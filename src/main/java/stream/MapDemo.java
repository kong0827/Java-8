package stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import entity.Employee;
import mapper.demo01.StudentDTO;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import util.JsonUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiangjin.kong
 * @date 2021/7/22 10:56
 */
public class MapDemo {

    /**
     * putIfAbsent用法
     * 如果key存在则不替换，不存在则设置
     */
    @Test
    public void putIfAbsentTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("ben", 24);
        map.putIfAbsent("ben", 20);
        System.out.println(map);

        map.putIfAbsent("jack", 20);
        System.out.println(map);
    }

    /**
     * merge的用法
     * merge方法在统计时用的场景比较多
     * merge() 可以这么理解：它将新的值赋值到 key （如果不存在）或更新给定的key 值对应的 value
     * 该方法接收三个参数，一个 key 值，一个 value，一个 remappingFunction ，如果给定的key不存在，它就变成了 put(key, value) 。
     *
     * 但是，如果 key 已经存在一些值，我们 remappingFunction 可以选择合并的方式，然后将合并得到的 newValue 赋值给原先的 key
     */
    @Test
    public void mergeTest() {
        List<Employee> employeeList = Lists.newArrayList(new Employee("男", 10d),
                new Employee("女", 20.0),
                new Employee("男", 40.0),
                new Employee("女", 10.0),
                new Employee("男", 20.0));
        Map<String, Integer> map = Maps.newHashMap();
        employeeList.forEach(employee ->
                map.merge(employee.getGender(), (int) employee.getChange(), Integer::sum));
        System.out.println(JSON.toJSON(map));
    }

    @Test
    public void mergeTest2() {
        Map<String, Integer> map = Maps.newHashMap();
        map.merge("zs", 10, Integer::sum);
        System.out.println(JSON.toJSON(map));
        map.merge("zs", 20, (oldValue, newValue) -> newValue);
        System.out.println(JSON.toJSON(map));
        map.merge("zs", 20, Integer::sum);
        System.out.println(JSON.toJSON(map));
    }

    /**
     * 如果key不存在设置值
     * java8之前。从map中根据key获取value操作可能会有下面的操作
     * Object key = map.get("key");
     * if (key == null) {
     * key = new Object();
     * map.put("key", key);
     * }
     */
    @Test
    public void computeIfAbsentTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("ben", 24);
        Integer value = map.computeIfAbsent("ben", s -> 0);
        System.out.println(value);

        value = map.computeIfAbsent("jack", s -> 0);
        System.out.println(value);

        map.computeIfAbsent("lucy", this::getMethodName);
        System.out.println(map);
    }


    /**
     * 如果key存在设置值
     */
    @Test
    public void test() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zs", 1);
        map.computeIfPresent("zs", (key, value) -> 100);
        System.out.println(JSON.toJSON(map));
    }

    Integer getMethodName(String key) {
        return 100;
    }

    /**
     *
     * computeIfAbsent + computeIfPresent 结合体
     * 需要统计一个字符串中各个单词出现的频率，然后从中找出频率最高的单词
     * jdk8之前写法
     *
     * String str = "hello java, i am vary happy! nice to meet you";
     *
     *         // jdk1.8之前的写法
     *         HashMap<Character, Integer> result1 = new HashMap<>(32);
     *         for (int i = 0; i < str.length(); i++) {
     *             char curChar = str.charAt(i);
     *             Integer curVal = result1.get(curChar);
     *             if (curVal == null) {
     *                 curVal = 1;
     *             } else {
     *                 curVal += 1;
     *             }
     *             result1.put(curChar, curVal);
     *         }
     *
     * BiFunction则是Function函数的升级版。聪明的同学可能会发现Function只能接受一个参数。
     * 假如我的函数体有两个参数，咋办呢。而BiFunction正是解决这一问题而出现的
     */
    @Test
    public void computeTest() {
        String str = "hello java, i am vary happy! nice to meet you";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            map.compute(curChar, (k, v) -> {
                if (v == null) {
                    v = 1;
                } else {
                    v += 1;
                }
                return v;
            });
        }
        System.out.println(map);


    }

    @Test
    public void test1() {
        LocalDateTime localDateTime = LocalDateTime.now().minusMonths(2);

        List<StudentDTO> list = new ArrayList<>();
        StudentDTO s1 = new StudentDTO();
        s1.setAge(8);
        s1.setName("xxx");
        list.add(s1);

        s1 = new StudentDTO();
        s1.setAge(9);
        s1.setName("yyy");
        list.add(s1);

        s1 = new StudentDTO();
        s1.setAge(8);
        s1.setName("xzzzzxx");
        list.add(s1);


        Map<Integer, List<String>> map = new HashMap<>(32);
        for (StudentDTO studentDTO : list) {
            map.compute(studentDTO.getAge(), (k, v) -> {
                if (v == null) {
                    v = Lists.newArrayList(studentDTO.getName());
                } else {
                    v.add(studentDTO.getName());
                }
                return v;
            });
        }



    }
}
