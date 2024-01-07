package hu.acsaifz.studentmanagementsystem.mapper;

import hu.acsaifz.studentmanagementsystem.dto.CourseDto;
import hu.acsaifz.studentmanagementsystem.model.Course;
import hu.acsaifz.studentmanagementsystem.model.HistoryData;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

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

    default List<HistoryData<CourseDto>> historyListToDto(List<HistoryData<Course>> historyList){
        return historyList.stream()
                .map(this::historyToDto)
                .collect(Collectors.toList());
    }

    default HistoryData<CourseDto> historyToDto(HistoryData<Course> historyData){
        return new HistoryData<>(
                this.toDto(historyData.getData()),
                historyData.getRevType(),
                historyData.getRev(),
                historyData.getDate()
        );
    }
}
