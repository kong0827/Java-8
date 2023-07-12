package designpattern.filter;

/**
 * @author kxj
 * @date 2022/9/13 15:40
 * @desc
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean filter(Employee employee) {
        return  employee.getAge() >= 30;
    }
}
