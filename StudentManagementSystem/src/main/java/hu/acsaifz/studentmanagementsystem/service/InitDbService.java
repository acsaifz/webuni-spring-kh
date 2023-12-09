package hu.acsaifz.studentmanagementsystem.service;

import hu.acsaifz.studentmanagementsystem.model.Course;
import hu.acsaifz.studentmanagementsystem.model.Student;
import hu.acsaifz.studentmanagementsystem.model.Teacher;
import hu.acsaifz.studentmanagementsystem.repository.CourseRepository;
import hu.acsaifz.studentmanagementsystem.repository.StudentRepository;
import hu.acsaifz.studentmanagementsystem.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class InitDbService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;


    public void clearDb(){
        courseRepository.deleteAllInBatch();
        studentRepository.deleteAllInBatch();
        teacherRepository.deleteAllInBatch();
    }

    @Transactional
    public void initDb(){
        Course course1 = Course.builder().name("Matematika").build();
        Course course2 = Course.builder().name("Informatika Alapjai").build();
        Course course3 = Course.builder().name("Nyelvek és kultúrák").build();

        Teacher teacher1 = teacherRepository.save(Teacher.builder().name("Nagy Péter").birthDate(LocalDate.parse("1980-03-10")).build());
        Teacher teacher2 = teacherRepository.save(Teacher.builder().name("Kiss Erika").birthDate(LocalDate.parse("1985-09-22")).build());
        Teacher teacher3 = teacherRepository.save(Teacher.builder().name("Mészáros László").birthDate(LocalDate.parse("1978-07-18")).build());
        Teacher teacher4 = teacherRepository.save(Teacher.builder().name("Takács Zsuzsanna").birthDate(LocalDate.parse("1976-04-29")).build());
        Teacher teacher5 = teacherRepository.save(Teacher.builder().name("Simon András").birthDate(LocalDate.parse("1982-11-15")).build());

        Student student1 = studentRepository.save(Student.builder().name("Kovács Anna").birthDate(LocalDate.parse("2000-05-15")).semester(3).build());
        Student student2 = studentRepository.save(Student.builder().name("Nagy Gábor").birthDate(LocalDate.parse("1999-08-20")).semester(4).build());
        Student student3 = studentRepository.save(Student.builder().name("Varga Eszter").birthDate(LocalDate.parse("2001-02-10")).semester(2).build());
        Student student4 = studentRepository.save(Student.builder().name("Tóth Bence").birthDate(LocalDate.parse("2002-01-25")).semester(1).build());
        Student student5 = studentRepository.save(Student.builder().name("Molnár Petra").birthDate(LocalDate.parse("2000-11-30")).semester(3).build());
        Student student6 = studentRepository.save(Student.builder().name("Kis Dávid").birthDate(LocalDate.parse("2001-06-05")).semester(2).build());
        Student student7 = studentRepository.save(Student.builder().name("Fekete Zsuzsa").birthDate(LocalDate.parse("2002-04-12")).semester(1).build());
        Student student8 = studentRepository.save(Student.builder().name("Szabó Dániel").birthDate(LocalDate.parse("2001-12-08")).semester(2).build());
        Student student9 = studentRepository.save(Student.builder().name("Horváth Krisztina").birthDate(LocalDate.parse("2000-09-17")).semester(4).build());

        course1.addTeacher(teacher1);
        course2.addTeacher(teacher2);
        course3.addTeacher(teacher3);
        course2.addTeacher(teacher4);
        course3.addTeacher(teacher5);
        course1.addTeacher(teacher5);
        course2.addTeacher(teacher3);

        course1.addStudent(student1);
        course1.addStudent(student2);
        course1.addStudent(student3);
        course1.addStudent(student8);
        course1.addStudent(student5);

        course2.addStudent(student4);
        course2.addStudent(student5);
        course2.addStudent(student6);
        course2.addStudent(student1);
        course2.addStudent(student7);

        course3.addStudent(student7);
        course3.addStudent(student8);
        course3.addStudent(student9);
        course3.addStudent(student2);
        course3.addStudent(student4);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
    }
}
