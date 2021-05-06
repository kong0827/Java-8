package entity;

import lombok.*;

/**
 * @author xiangjin.kong
 * @date 2020/10/21 18:44
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private Integer id;
    private Integer age;   //年龄
    private String gender;  //性别
    private String firstName;
    private String lastName;
}
