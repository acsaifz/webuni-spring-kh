package hu.acsaifz.studentmanagementsystem.service;

import hu.acsaifz.studentmanagementsystem.model.Student;
import hu.acsaifz.studentmanagementsystem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final EducationRegistryService educationRegistryService;

    public Student getById(long id){
        return studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Scheduled(cron = "${students.free_semesters_update_interval}")
    @Transactional
    public void updateFreeSemestersOfStudents(){
        List<Student> students = studentRepository.findAll();

        for (Student student: students){
            int freeSemesters = educationRegistryService.getFreeSemestersByStudentId(student.getStudentId());
            if (freeSemesters > student.getSemester()) {
                student.setCountOfFreeSemesters(freeSemesters);
            }
        }
    }
}
