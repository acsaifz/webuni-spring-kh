package hu.acsaifz.studentmanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(
        onlyExplicitlyIncluded = true
)
@Builder
@Entity
@Table(
        name = "students"
)
@Cacheable
public class Student {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private LocalDate birthDate;

    private int semester;

    @ManyToMany(
            mappedBy = "students"
    )
    private List<Course> courses;

    public void addCourse(Course course){
        if (courses == null) {
            courses = new ArrayList<>();
        }
    }

    public void removeCourse(Course course) {
        if (course != null) {
            courses.remove(course);
        }
    }
}
