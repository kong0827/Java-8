package mapper.demo02;

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


    @Mapping(source = "studentDTO.name", target = "studentName")
    @Mapping(source = "classDTO.name", target = "className")
    StudentVO dtoToVo(StudentDTO studentDTO, ClassDTO classDTO);

}
