package com.kxj.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiangjin.kong
 * @date 2021/6/7 15:21
 * @desc 删选和截断流
 */
public class Demo_02_Stream {

    /**
     * 筛选各异的元素
     */
    @Test
    public void distinctTest() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 5, 4, 2, 3, 4, 6, 8);
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 截短流
     */
    @Test
    public void limitTest() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 5, 4, 2, 3, 4, 6, 8);
        List<Integer> collect = list.parallelStream().limit(3).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 跳过元素
     * 返回一个扔掉了前n个元素的流。如果流中元素不足n个，则返回一个空流。
     */
    @Test
    public void skipTest() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> collect = list.parallelStream().skip(3).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
