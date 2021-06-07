package com.kxj.stream;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Dish dish1 = new Dish("dish1", 300.0);
        Dish dish2 = new Dish("dish2", 200.0);
        Dish dish3 = new Dish("dish3", 600.0);
        Dish dish4 = new Dish("dish4", 100.0);
        menu.add(dish1);
        menu.add(dish2);
        menu.add(dish3);
        menu.add(dish4);
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
}
