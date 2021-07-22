package stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiangjin.kong
 * @date 2021/7/22 10:56
 */
public class MapDemo {

    /**
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

    Integer getMethodName(String key) {
        System.out.println("-----" + key);
        return 100;
    }
}
