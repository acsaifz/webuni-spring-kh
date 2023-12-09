package hu.acsaifz.studentmanagementsystem.service;

import hu.acsaifz.studentmanagementsystem.model.Student;
import hu.acsaifz.studentmanagementsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getById(long id){
        return studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
