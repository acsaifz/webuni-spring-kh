package hu.acsaifz.studentmanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

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
        name = "courses"
)
@Cacheable
@Audited
public class Course {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "courses_students",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id")}
    )
    private List<Student> students;

    @ManyToMany
    @JoinTable(
            name = "courses_teachers",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "teacher_id")}
    )
    private List<Teacher> teachers;

    public void addStudent(Student student){
        if (students == null) {
            students = new ArrayList<>();
        }

        student.addCourse(this);
        students.add(student);
    }

    public void removeStudent(Student student){
        if (students != null) {
            student.removeCourse(this);
            students.remove(student);
        }
    }

    public void addTeacher(Teacher teacher){
        if (teachers == null) {
            teachers = new ArrayList<>();
        }

        teacher.addCourse(this);
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher){
        if (teachers != null) {
            teacher.removeCourse(this);
            teachers.remove(teacher);
        }
    }

}
