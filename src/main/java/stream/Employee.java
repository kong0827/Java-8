package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author xiangjin.kong
 * @date 2020/10/21 18:44
 */
@Data
@AllArgsConstructor
@ToString
public class Employee {

    private Integer id;
    private Integer age;   //年龄
    private String gender;  //性别
    private String firstName;
    private String lastName;
}
