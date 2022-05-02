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
    private double change; // 零钱

    public Employee(Integer id, Integer age, String gender, String firstName, String lastName) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String gender, double change) {
        this.gender = gender;
        this.change = change;
    }
}
