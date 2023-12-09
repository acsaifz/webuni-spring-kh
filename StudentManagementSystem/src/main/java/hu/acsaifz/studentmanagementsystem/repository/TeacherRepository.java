package hu.acsaifz.studentmanagementsystem.repository;

import hu.acsaifz.studentmanagementsystem.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
