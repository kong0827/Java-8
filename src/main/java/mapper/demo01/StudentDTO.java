package mapper.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author kxj
 * @date 2021/6/13 3:00 下午
 * @desc
 */
@Data
@ToString
@AllArgsConstructor
public class StudentDTO {

    private String name;

    private String sex;

    private Integer age;

    private String nickname;

    public StudentDTO(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
