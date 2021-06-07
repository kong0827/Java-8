package com.kxj.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiangjin.kong
 * @date 2021/6/7 14:48
 * 返回低热量的菜肴名称
 * 两种写法
 * JDK7
 * JDK8
 */
public class Demo_01_Stream {

    private List<Dish> menu = new ArrayList<>();

    @Before
    public void buildData() {
        Dish dish1 = new Dish("dish1", 300.0);
        Dish dish2 = new Dish("dish2", 200.0);
        Dish dish3 = new Dish("dish3", 600.0);
        Dish dish4 = new Dish("dish4", 100.0);
        menu.add(dish1);
        menu.add(dish2);
        menu.add(dish3);
        menu.add(dish4);
    }

    @Test
    public void test() {
        // java7写法
        List<Dish> lowCaloricDishes = new ArrayList<>();
        // 使用累加器选元素
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        // 用匿名类对菜肴排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Double.compare(o1.getCalories(), o2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        // 处理排序后的菜单列表
        for (Dish lowCaloricDish : lowCaloricDishes) {
            lowCaloricDishesName.add(lowCaloricDish.getName());
        }
        //输出
        lowCaloricDishesName.forEach(System.out::println);

        /**
         * JDK1.8写法
         * lowCaloricDishes是一个垃圾代码 只作为一次性的中间容器
         *
         * filter的结果被传给了sorted方法，再传给map方法，最后传给collect方法
         */
        List<String> list = menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println();
        list.forEach(System.out::println);

        /**
         * JDK1.8 并行执行
         */
        list = menu.parallelStream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println();
        list.forEach(System.out::println);
    }
}
