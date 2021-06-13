package stream;

import entity.Employee;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xiangjin.kong
 * @date 2020/10/21 18:43
 *
 * 对不同泛型的集合进行排序
 */
public class ListSortTest {

    /**
     * 字符串List排序
     */
    @Test
    public void StringTest() {
        List<String> cityList = Arrays.asList("beijing", "Shanghai", "heifei", "Guangzhou");
        /**
         * String.CASE_INSENSITIVE_ORDER（字母大小写不敏感）
         */
        cityList.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(cityList);

        /**
         * Comparator.naturalOrder()字母自然顺序排序
         */
        cityList.sort(Comparator.naturalOrder());
        System.out.println(cityList);

        /**
         * 把排序器Comparator用在Stream管道流中
         */
        cityList.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

    }

    /**
     * 整数类型List进行排序
     */
    @Test
    public void NumberListTest() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 2, 4, 7, 9);
        /**
         * 自然排序
         */
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);


        /**
         * 倒叙排列
         */
        numbers.sort(Comparator.reverseOrder());
        System.out.println(numbers);
    }

    /**
     * 对象字段对List<Object>排序
     */
    @Test
    public void ObjectListTest() {
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
        /**
         * 按照年龄正序排序
         */
        System.out.println("-----------按照年龄正序排序-------------");
        employees.sort(Comparator.comparing(Employee::getAge));
        employees.forEach(System.out::println);

        /**
         * 按照年龄倒叙排序
         */
        System.out.println("-----------按照年龄倒叙排序-------------");
        employees.sort(Comparator.comparing(Employee::getAge).reversed());
        employees.forEach(System.out::println);

        /**
         * Stream去重
         */
        System.out.println("-----------Stream去重- 按照年龄倒叙排序-------------");
        employees.stream().sorted((e, e12) -> e.getAge().compareTo(e12.getAge())).forEach(System.out::println);
    }

    /**
     * 对List<Object>中对象的多个字段进行排序
     */
    @Test
    public void ObjectMultiFiledTes() {
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

        /**
         * 按照对象多个属性进行排序
         */
        employees.sort(Comparator.comparing(Employee::getAge).thenComparing(Employee::getId));
        employees.forEach(System.out::println);
    }

    @Test
    public void test() {
        List<String> aftersalesNoList = new ArrayList<>();
        aftersalesNoList.add("a");
        aftersalesNoList.add("b");
        aftersalesNoList.add("c");
        String afterSalesNo = StringUtils.join(Arrays.asList(aftersalesNoList.toArray()), ",");
        System.out.println(afterSalesNo);
    }
}
