package hu.acsaifz.studentmanagementsystem.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDto {
    private Long id;
    private String name;
    private List<StudentDto> students = new ArrayList<>();
    private List<TeacherDto> teachers = new ArrayList<>();
}
