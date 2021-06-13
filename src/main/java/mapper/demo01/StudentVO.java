package mapper.demo01;

import lombok.Data;
import lombok.ToString;

/**
 * @author kxj
 * @date 2021/6/13 3:01 下午
 * @desc
 */
@Data
@ToString
public class StudentVO {

    private String name;

    private String sex;

    private String voName;

    private Integer age;
}
