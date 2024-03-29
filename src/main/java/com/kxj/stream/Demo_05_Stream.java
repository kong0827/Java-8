package com.kxj.stream;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author xiangjin.kong
 * @date 2021/6/7 16:33
 * @desc 规约
 */
public class Demo_05_Stream {

    @Test
    public void test() {
        /**
         * 求和
         */
        ArrayList<Integer> list = Lists.newArrayList(1, 3, 2, 4);
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        System.out.println(reduce.get());

        /**
         * 求最大值
         */
        Optional<Integer> reduce1 = list.stream().reduce(Integer::max);
        System.out.println(reduce1.get());
    }


    private List<Dish> menu = new ArrayList<>();

    @Before
    public void buildData() {
        Dish dish1 = new Dish("dish1", 300.0, false);
        Dish dish2 = new Dish("dish2", 200.0, false);
        Dish dish3 = new Dish("dish3", 600.0, true);
        Dish dish4 = new Dish("dish4", 100.0, false);
        Dish dish5 = new Dish("dish5", 300.0, false);
        Dish dish6 = new Dish("dish6", 200.0, false);
        menu.add(dish1);
        menu.add(dish2);
        menu.add(dish3);
        menu.add(dish4);
        menu.add(dish5);
        menu.add(dish6);
    }

    /**
     * 用map和reduce方法数一数流中有多少个菜呢
     */
    @Test
    public void test1() {
        Integer sum = menu.stream().map(dish -> 1).reduce(Integer::sum).orElse(0);
        System.out.println(sum);

        long count = menu.stream().count();
        System.out.println(count);
    }

    /**
     * 分组
     */
    @Test
    public void groupTest() {
        // 单一分组
        System.out.println("--------------根据单个属性分组------------");
        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::isVegetarian));
        for (Map.Entry<Boolean, List<Dish>> entry : collect.entrySet()) {
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }

        System.out.println("--------------根据多个属性分组------------");
        // 复杂分组
        Map<Tuple, List<Dish>> map = menu.stream().collect(Collectors.groupingBy(dish -> new Tuple(dish.isVegetarian(), dish.getCalories())));
        for (Map.Entry<Tuple, List<Dish>> entry : map.entrySet()) {
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }

        System.out.println("--------------修改分组后的类型------------");
        Map<Boolean, List<String>> map1 = menu.stream().collect(Collectors.groupingBy(Dish::isVegetarian, Collectors.mapping(Dish::getName, Collectors.toList())));
        for (Map.Entry<Boolean, List<String>> entry : map1.entrySet()) {
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }

        System.out.println("--------------根据多个属性分组------------");
        Map<Boolean, Map<Double, List<Dish>>> map2 = menu.stream().collect(Collectors.groupingBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getCalories)));
        for (Map.Entry<Boolean, Map<Double, List<Dish>>> entry : map2.entrySet()) {
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }

        System.out.println("--------------修改分组后的类型------------");
        Map<Boolean, String> map3 = menu.stream().collect(Collectors.groupingBy(Dish::isVegetarian, Collectors.mapping(Dish::getName, Collectors.joining(","))));
        for (Map.Entry<Boolean, String> entry : map3.entrySet()) {
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }


    }


    @Test
    public void test111() throws Exception {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        Integer xxx = list.stream().filter(integer -> integer == 11).findFirst().orElseThrow(() -> new Exception("xxxxxxx"));
        System.out.println(xxx);
    }
}
