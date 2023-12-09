package hu.acsaifz.studentmanagementsystem.mapper;

import hu.acsaifz.studentmanagementsystem.dto.CourseDto;
import hu.acsaifz.studentmanagementsystem.model.Course;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {StudentMapper.class, TeacherMapper.class}
)
public interface CourseMapper {

    CourseDto toDto(Course course);

    List<CourseDto> toDto(Iterable<Course> courses);

    @Named("summary")
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "students", ignore = true)
    CourseDto courseSummaryToDto(Course course);

    @IterableMapping(qualifiedByName = "summary")
    List<CourseDto> courseSummaryToDto(Iterable<Course> courses);
}
