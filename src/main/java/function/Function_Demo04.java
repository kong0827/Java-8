package function;

import entity.Employee;
import service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author xiangjin.kong
 * @date 2020/12/23 16:11
 *
 * apply 执行方法
 */
public class Function_Demo04 {

    public static void main(String[] args) {
        Function<Integer, List<Employee>> function = get("1");
        List<Employee> employeeList = function.apply(10);
        System.out.println(employeeList);
    }

    /**
     * Integer 是方法传入的参数
     * String 是要执行的那个方法
     * @param type
     * @return
     */
    static Function<Integer, List<Employee>> get(String type) {
        EmployeeService employeeService = new EmployeeService();
        Map<String, Function<Integer, List<Employee>>> map = new HashMap<>();
        map.put("1", employeeService::getByAge);
        map.put("2", employeeService::getByName);
        map.put("3", employeeService::getByGender);
        return map.get(type);
    }
}
