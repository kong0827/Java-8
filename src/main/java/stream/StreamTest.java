package stream;

import entity.Employee;
import org.junit.Test;

import java.awt.print.Book;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

/**
 * @author xiangjin.kong
 * @date 2020/9/9 19:07
 */
public class StreamTest {

    /**
     * forEach 和 ForEachOrdered 测试
     * parallel()函数表示对管道进行并行处理，非串行处理，处理速度更快，不保证元素的顺序
     * ForEachOrdered 数据处理顺序上可能无法保障，但是forEachOrdered方法可以在元素输出的顺序上保证与元素进入管道流的顺序一致
     */
    @Test
    public void forEachTest() {
        List<String> list = Arrays.asList("zhangsan", "lisi", "wanger", "zhangsanfeng");

        list.stream().parallel().forEach(System.out::println);

        list.stream().parallel().forEachOrdered(System.out::println);

    }


    /**
     * collect()方法 将管道流处理结果在转换成集合类
     */
    @Test
    public void collectTest() {
        List<String> list = Arrays.asList("zhangsan", "lisi", "zhangsan", "wanger", "zhangsanfeng");

        /**
         * 收集为Set
         */
        Set<String> set = list.stream().collect(Collectors.toSet());
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("-------收集为List-------");

        /**
         * 收集为List
         */
        List<String> collect = list.stream().collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }

        System.out.println("-----------收集为LinkedList----------");

        /**
         * 收集为LinkedList
         */
        LinkedList<String> collect1 = list.stream().collect(Collectors.toCollection(LinkedList::new));
        for (String s : collect1) {
            System.out.println(s);
        }

        System.out.println("--------收集为Array----------");

        /**
         * 收集为Array
         */
        String[] array = list.stream().toArray(String[]::new);
        for (String o : array) {
            System.out.println(o);
        }

        System.out.println("--------收集为Map--------");
        /**
         * 收集为Map
         */
        Map<String, String> map = Stream.of("zhangsan", "lisi", "wanger").distinct().collect(Collectors.toMap(
                Function.identity(), Function.identity()
        ));

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("--------- 分组统计 -----------");
        Map<Character, List<String>> map1 = list.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        Set<Map.Entry<Character, List<String>>> entries1 = map1.entrySet();
        for (Map.Entry<Character, List<String>> characterListEntry : entries1) {
            System.out.println(characterListEntry.getKey() + ": " + characterListEntry.getValue());
        }

        /**
         * groupingBy第一个参数作为分组条件，第二个参数是子收集器
         */
        Map<Character, Long> collect2 = list.stream().collect(Collectors.groupingBy(s -> s.charAt(0), counting()));
        Set<Map.Entry<Character, Long>> entries2 = collect2.entrySet();
        for (Map.Entry<Character, Long> characterListEntry : entries2) {
            System.out.println(characterListEntry.getKey() + ": " + characterListEntry.getValue());
        }

    }


    @Test
    public void otherTest() {
        System.out.println("------判断管道中是否包含某个值------");
        boolean isMatch = Stream.of("zhangsan", "lisi", "zhangsan", "wanger", "zhangsanfeng").anyMatch(s -> s.equals("lisi"));
        System.out.println(isMatch);


        System.out.println("------管道中的数据数量------");
        long count = Stream.of("zhangsan", "lisi", "zhangsan", "wanger", "zhangsanfeng").count();
        System.out.println(count);

        System.out.println("--------管道中数据去重-------");
        count = Stream.of("zhangsan", "lisi", "zhangsan", "wanger", "zhangsanfeng").distinct().count();
        System.out.println(count);

        System.out.println("管道中元素平平均值:"+IntStream.of(1, 3, 5, 6).average().getAsDouble());
        System.out.println("管道中元素和:"+IntStream.of(1, 3, 5, 6).sum());

        System.out.println("-----------全面统计-----------");
        System.out.println(IntStream.of(1, 4, 6, 8).summaryStatistics());

    }

    /**
     * 根据对象属性去重
     */
    @Test
    public void ObjectDistinctTest() {
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        ArrayList<Employee> employeeArrayList = employees.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getAge))), ArrayList::new));
        employeeArrayList.forEach(System.out::println);

    }


    /**
     * 根据对象属性去重
     */
    @Test
    public void ObjectDistinctTest2() {
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        List<Employee> unique2 = employees.stream()
                .filter(distinctByKey(Employee::getId))
                .collect(Collectors.toList());
        System.out.println(unique2);

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
