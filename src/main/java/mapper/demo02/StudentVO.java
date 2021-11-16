package mapper.demo02;

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

    private String studentName;

    private String sex;

    private Integer age;

    private String className;

    /**
     * 编号
     */
    private String no;
}
