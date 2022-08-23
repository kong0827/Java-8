package mapper.demo02;

import mapper.utils.NumberUtil;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ap.shaded.freemarker.template.utility.CollectionUtils;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author kxj
 * @date 2021/6/13 3:01 下午
 * @desc
 */
@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);


    @Mapping(source = "studentDTO.name", target = "studentName")
    @Mapping(source = "classDTO.name", target = "className")
    StudentVO dtoToVo(StudentDTO studentDTO, ClassDTO classDTO);


    /**
     * expression 表达式
     * 两种写法
     * 全限定类名加方法
     * @Mapping(target = "no", expression = "java(mapper.utils.NumberUtil.init())")
     * 调用方法
     * @Mapping(target = "no", expression = "java(getNo())")
     *
     * 如果是spring注入的
     * @Autowired
     * NumberUtil numberUtil;
     * @Mapping(target = "no", expression = "java(numberUtil.init())")
     *
     *
     * 导入
     * @Mapper(classes = NumberUtil.class)
     *  @Mapping(target = "no", expression = "java(NumberUtil.getNo())")
     *     StudentVO dtoToVo1(StudentDTO studentDTO, ClassDTO classDTO);
     * @param studentDTO
     * @param classDTO
     * @return
     */
//    @Mapping(target = "no", expression = "java(mapper.utils.NumberUtil.init())")
    @Mapping(target = "no", expression = "java(getNo())")
    @Mapping(target = "sex", expression = "java(covertStr(studentDTO.getSex()))")
    StudentVO dtoToVo1(StudentDTO studentDTO, ClassDTO classDTO);

    /**
     * 获取编号
     * @return
     */
    default String getNo() {
        return NumberUtil.init();
    }

    default String covertStr(List<String> businessKeyList) {
        if (businessKeyList == null) {
            return StringUtils.EMPTY;
        }
        return String.join(",", businessKeyList);
    }
}
