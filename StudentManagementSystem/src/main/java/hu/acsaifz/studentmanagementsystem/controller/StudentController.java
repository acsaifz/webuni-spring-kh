package hu.acsaifz.studentmanagementsystem.controller;

import hu.acsaifz.studentmanagementsystem.dto.StudentDto;
import hu.acsaifz.studentmanagementsystem.mapper.StudentMapper;
import hu.acsaifz.studentmanagementsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    private final StudentMapper studentMapper;

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable long id){
        return studentMapper.toDto(studentService.getById(id));
    }

}
