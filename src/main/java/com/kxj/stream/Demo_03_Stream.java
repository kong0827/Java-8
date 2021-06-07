package com.kxj.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xiangjin.kong
 * @date 2021/6/7 15:39
 * @desc map与flatMap
 */
public class Demo_03_Stream {

    /**
     * map
     * 流支持map方法，它会接受一个函数作为参数。这个函数会被应用到每个元素上，并将其映
     * 射成一个新的元素
     */
    @Test
    public void mapTest() {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        wordLengths.forEach(System.out::println);
    }

    /**
     * flatMap - 流的扁平化
     * flatMap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流
     *
     * 给定单词列表
     * ["Hello","World"]，你想要返回列表["H","e","l", "o","W","r","d"]。
     */
    @Test
    public void faltMapTest() {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<String> collect = words.stream()
                .map(s -> s.split("")) // 将每个单词转换为字母构成的数组
                .flatMap(Arrays::stream)     // 将各个生成的流扁平化为单个流
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     *  1、给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？例如，给定[1, 2, 3, 4,5]，应该返回[1, 4, 9, 16, 25]。
     *  2、给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，
     *  应该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代表数对
     */
    @Test
    public void test() {
        Stream.of(1, 2, 3, 4, 5).map(integer -> integer * integer).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("------------------------");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<ArrayList<Integer>> collect = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> Lists.newArrayList(i, j)))
                .collect(Collectors.toList());
        for (ArrayList<Integer> list : collect) {
            System.out.println(list);
        }
    }
}
