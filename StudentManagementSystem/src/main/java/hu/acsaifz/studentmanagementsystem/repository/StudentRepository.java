package hu.acsaifz.studentmanagementsystem.repository;

import hu.acsaifz.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
