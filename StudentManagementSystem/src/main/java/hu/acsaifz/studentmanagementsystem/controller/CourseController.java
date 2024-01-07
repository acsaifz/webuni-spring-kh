package hu.acsaifz.studentmanagementsystem.controller;

import com.querydsl.core.types.Predicate;
import hu.acsaifz.studentmanagementsystem.dto.CourseDto;
import hu.acsaifz.studentmanagementsystem.mapper.CourseMapper;
import hu.acsaifz.studentmanagementsystem.model.Course;
import hu.acsaifz.studentmanagementsystem.model.HistoryData;
import hu.acsaifz.studentmanagementsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = {"/api/courses"})
public class CourseController {

    private final CourseService courseService;

    private final CourseMapper courseMapper;

    @GetMapping(value = {"/search"})
    public List<CourseDto> searchCourses(
            @QuerydslPredicate(root = Course.class) Predicate predicate,
            @PageableDefault(sort = {"id"}) Pageable pageable,
            Optional<Boolean> full
    ){
        boolean isFull = full.orElse(false);

        if (isFull){
            return courseMapper.toDto(
                    courseService.findAllWithRelationships(predicate, pageable)
            );
        } else {
            return courseMapper.courseSummaryToDto(
                    courseService.findAll(predicate, pageable)
            );
        }
    }

    @GetMapping(value = {"/{id}"})
    public CourseDto getById(@PathVariable long id){
        return courseMapper.courseSummaryToDto(courseService.getById(id));
    }

    @GetMapping(value = {"/{id}/history"})
    public List<HistoryData<CourseDto>> getHistory(@PathVariable long id){
        return courseMapper.historyListToDto(courseService.getHistoryById(id));
    }

    @GetMapping(value = {"/{id}/version"})
    public CourseDto getVersionAt(@PathVariable int id, @RequestParam LocalDateTime at){
        return courseMapper.toDto(courseService.getVersionAt(id, at));
    }

}
