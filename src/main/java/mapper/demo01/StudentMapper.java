package mapper.demo01;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author kxj
 * @date 2021/6/13 3:01 下午
 * @desc
 */
@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentVO dtoToVo(StudentDTO dto);

    @Mapping(target = "voName", source = "nickname")  // 属性名不一致
    @Mapping(target = "sex", ignore = true)         // 排除
    StudentVO dtoToVo2(StudentDTO dto);
}
