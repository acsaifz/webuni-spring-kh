package hu.acsaifz.studentmanagementsystem.controller;

import hu.acsaifz.studentmanagementsystem.dto.TeacherDto;
import hu.acsaifz.studentmanagementsystem.mapper.TeacherMapper;
import hu.acsaifz.studentmanagementsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    private final TeacherMapper teacherMapper;

    @GetMapping("/{id}")
    public TeacherDto getById(@PathVariable long id){
        return teacherMapper.toDto(teacherService.getById(id));
    }

}
