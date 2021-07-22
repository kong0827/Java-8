import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import entity.Employee;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

/**
 * @author kxj
 * @date 2020/11/17 23:32
 * @desc Java 8 Optional类
 */
public class OptionalTest {

    @Test
    public void testNull1() {
        Employee employee = null;
        // 抛出空指针
        Optional<Employee> optional = Optional.of(employee);
    }

    @Test
    public void testNull2() {
        Employee employee = null;
        // 返回null对象
        Optional<Employee> optional = Optional.ofNullable(employee);
    }

    /**
     * orElse
     * orElseGet
     */
    @Test
    public void test() throws Exception {
        Employee employee = null;
        Employee employee1 = Optional.ofNullable(employee).orElse(createEmployee());
        Employee employee2 = Optional.ofNullable(employee).orElseGet(() -> createEmployee());
        System.out.println(employee1);
        System.out.println(employee2);

        /*
         * employee值不为null时，orElse函数依然会执行createEmployee()方法，但是不会改变值
         * ，而orElseGet函数并不会执行createEmployee()方法
         */
        employee = Employee.builder().firstName("李").age(20).build();
        Employee employee3 = Optional.ofNullable(employee).orElse(createEmployee());
        Employee employee4 = Optional.ofNullable(employee).orElseGet(this::createEmployee);
        System.out.println(employee3);
        System.out.println(employee4);

        employee = null;
        Optional.ofNullable(employee).orElseThrow(() -> new Exception("空"));
    }

    /**
     * map flatMap
     */
    @Test
    public void test2() {
        /*
            map
         */
        Employee employee = Employee.builder().firstName("李").age(20).build();
        Integer age = Optional.ofNullable(employee).map(Employee::getAge).get();
        System.out.println(age);

        Employee employee1 = new Employee();
        System.out.println(Optional.ofNullable(employee1).map(Employee::getAge).get());

    }


    /**
     * ifPresent isPresent
     */
    @Test
    public void test3() {
        /*
            map
         */
        Employee employee = Employee.builder().firstName("李").age(20).build();
        Employee employee1 = new Employee();

        boolean present = Optional.ofNullable(employee).isPresent();
        if (present) {
            System.out.println("空");
        }

        Optional.of(employee1).ifPresent(e -> {
            System.out.println("我能做什么操作呢....");
        });

    }

    /**
     * filter
     */
    @Test
    public void test4() {


//        Employee employee = Employee.builder().firstName("李").age(20).build();
//        Optional<Employee> employee2 = Optional.ofNullable(employee).filter(employee1 -> employee1.getAge() == 20);
//        System.out.println(employee2);
//        employee2 = Optional.ofNullable(employee).filter(employee1 -> employee1.getAge() == 10);
//        System.out.println(employee2);
    }


    public Employee createEmployee(){
        return Employee.builder().firstName("张").age(10).build();
    }
}
