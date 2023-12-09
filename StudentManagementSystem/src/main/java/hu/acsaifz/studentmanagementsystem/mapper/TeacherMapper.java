package hu.acsaifz.studentmanagementsystem.mapper;

import hu.acsaifz.studentmanagementsystem.dto.TeacherDto;
import hu.acsaifz.studentmanagementsystem.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeacherMapper {

    TeacherDto toDto(Teacher teacher);

    List<TeacherDto> toDto(List<Teacher> teachers);
}
