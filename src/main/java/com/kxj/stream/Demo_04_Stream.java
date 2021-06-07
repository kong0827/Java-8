package com.kxj.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangjin.kong
 * @date 2021/6/7 16:12
 * @desc 查找与匹配
 * Stream API通过allMatch、anyMatch、noneMatch、findFirst和findAny方法
 */
public class Demo_04_Stream {

    private List<Dish> menu = new ArrayList<>();

    @Before
    public void buildData() {
        Dish dish1 = new Dish("dish1", 300.0, true);
        Dish dish2 = new Dish("dish2", 200.0, false);
        Dish dish3 = new Dish("dish3", 600.0, true);
        Dish dish4 = new Dish("dish4", 100.0, true);
        menu.add(dish1);
        menu.add(dish2);
        menu.add(dish3);
        menu.add(dish4);
    }

    /**
     * 是否至少匹配一个元素
     */
    @Test
    public void anyMatchTest() {
        boolean match = menu.stream().anyMatch(dish -> !dish.isVegetarian());
        System.out.println(match);
    }

    /**
     * 是否匹配所有元素
     */
    @Test
    public void allMatchTest() {
        boolean match = menu.stream().allMatch(Dish::isVegetarian);
        System.out.println(match);
    }


    /**
     * noneMatch和allMatch相对的是noneMatch
     */
    @Test
    public void noneMatchTest() {
        boolean match = menu.stream().noneMatch(Dish::isVegetarian);
        System.out.println(match);
    }

    /**
     * 查找元素
     * findAny方法将返回当前流中的任意元素。
     */
    @Test
    public void findAnyTest() {
        Dish dish1 = menu.stream().filter(dish -> dish.getCalories() > 100.0).findAny().orElseThrow(() -> new RuntimeException("不存在"));
        System.out.println(dish1);

        try {
            Dish dish2 = menu.stream().filter(dish -> dish.getCalories() > 1000.0).findAny().orElseThrow(() -> new RuntimeException("不存在"));
            System.out.println(dish2);
        } catch (Exception e) {
            System.out.println(e);
        }

        /**
         * orElse()
         * 当optional值不存在时，调用orElse()返回orElse()的参数，如果optional的值存在时返回optional的值
         */
        Dish dish3 = menu.stream().filter(dish -> dish.getCalories() > 1000.0).findAny().orElse(new Dish("xxx", 1.0));
        System.out.println(dish3);

        /**
         * orElseGet()
         * 当optional值不存在时，调用orElseGet()中接口调用的返回值，如果optional的值存在时返回optional的值
         */
        Dish dish4 = menu.stream().filter(dish -> dish.getCalories() > 1000.0).findAny().orElseGet(() -> new Dish("xxx", 1.0));
        System.out.println(dish4);
    }

    /**
     *  findFirst - 查找第一个元素
     *
     */
    @Test
    public void findFirstTest() {
        Dish dish = menu.stream().filter(dish1 -> dish1.getCalories() > 300.0).findFirst().get();
        System.out.println(dish);
    }
}
