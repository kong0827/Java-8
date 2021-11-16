package mapper.demo02;


/**
 * @author kxj
 * @date 2021/6/13 4:20 下午
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        StudentDTO studentDTO = new StudentDTO("阿劲", "男", 24);
        ClassDTO classDTO = new ClassDTO("非师一班", 80);
        StudentVO vo = StudentMapper.INSTANCE.dtoToVo(studentDTO, classDTO);
        System.out.println(vo);

        StudentVO vo1 = StudentMapper.INSTANCE.dtoToVo1(studentDTO, classDTO);
        System.out.println(vo1);
    }
}
