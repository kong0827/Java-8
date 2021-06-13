package mapper.demo01;

/**
 * @author kxj
 * @date 2021/6/13 3:02 下午
 * @desc
 */
public class Test {

    public static void main(String[] args) {
        StudentDTO dto = new StudentDTO("阿劲", "男", 24);
        StudentVO vo = StudentMapper.INSTANCE.dtoToVo(dto);
        System.out.println(vo);


        StudentDTO dto2 = new StudentDTO("阿劲", "男", 24, "小k");
        StudentVO vo2 = StudentMapper.INSTANCE.dtoToVo2(dto2);
        System.out.println(vo2);
    }
}
