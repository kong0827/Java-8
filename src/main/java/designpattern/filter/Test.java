package designpattern.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kxj
 * @date 2022/9/13 15:50
 * @desc
 */
public class Test {

    protected List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 60, 6666.66),
            new Employee("赵六", 16, 7777.77),
            new Employee("田七", 18, 3333.33));

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> myPredicate) {
        List<Employee> employees = new ArrayList<>();
        for (Employee e : list) {
            if (myPredicate.filter(e)) {
                employees.add(e);
            }
        }
        return employees;
    }

    @org.junit.Test
    public void test4() {
        List<Employee> employeeList = this.filterEmployee(this.employees, new FilterEmployeeByAge());
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }

    @org.junit.Test
    public void test5() {
        List<Employee> employeeList = this.filterEmployee(this.employees, new FilterEmployeeBySalary());
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }
}
