package hu.acsaifz.studentmanagementsystem.service;

import com.querydsl.core.types.Predicate;
import hu.acsaifz.studentmanagementsystem.model.Course;
import hu.acsaifz.studentmanagementsystem.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public Page<Course> findAll(Predicate predicate, Pageable pageable){
        return courseRepository.findAll(predicate, pageable);
    }

    @Transactional
    @Cacheable(value = "pagedCourses")
    public Page<Course> findAllWithRelationships(Predicate predicate, Pageable pageable){
        Page<Course> coursePage = courseRepository.findAll(predicate,pageable);
        List<Course> courses = coursePage.getContent();
        courseRepository.fetchStudents(coursePage.getContent());
        courseRepository.fetchTeachers(courses);

        return coursePage;
    }

    public Course getById(long id){
        return courseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
