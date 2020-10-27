package function;

import entity.Employee;

import java.util.function.Supplier;

/**
 * @author kxj
 * @date 2020/10/28 0:34
 * @desc
 *
 * Represents a supplier of results.
 *
 * There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * Supplier是一个提供者，类似一个工厂，可以不断创建对象
 */
public class Example05_Supplier {

    public static void main(String[] args) {
        Supplier<Employee> employeeSupplier = Employee::new;
        Employee employee = employeeSupplier.get();
        Employee employee1 = employeeSupplier.get();
        System.out.println(employee == employee1);  //false
    }
}
