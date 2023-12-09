package hu.acsaifz.studentmanagementsystem.mapper;

import hu.acsaifz.studentmanagementsystem.dto.StudentDto;
import hu.acsaifz.studentmanagementsystem.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {

    StudentDto toDto(Student student);

    List<StudentDto> toDto(List<Student> students);
}
