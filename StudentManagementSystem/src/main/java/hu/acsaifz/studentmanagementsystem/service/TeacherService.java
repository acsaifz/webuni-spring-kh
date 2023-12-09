package hu.acsaifz.studentmanagementsystem.service;

import hu.acsaifz.studentmanagementsystem.model.Teacher;
import hu.acsaifz.studentmanagementsystem.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public Teacher getById(long id){
        return teacherRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
