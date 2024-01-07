package hu.acsaifz.studentmanagementsystem.service;

import com.querydsl.core.types.Predicate;
import hu.acsaifz.studentmanagementsystem.model.Course;
import hu.acsaifz.studentmanagementsystem.model.HistoryData;
import hu.acsaifz.studentmanagementsystem.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @PersistenceContext
    private final EntityManager entityManager;

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

    @SuppressWarnings({"unchecked", "ResultOfMethodCallIgnored"})
    @Transactional
    public List<HistoryData<Course>> getHistoryById(long id){
        List<HistoryData<Course>> history = new ArrayList<>();

        AuditReaderFactory.get(entityManager)
                .createQuery()
                .forRevisionsOfEntity(Course.class, false, true)
                .add(AuditEntity.property("id").eq(id))
                .getResultList().forEach(o -> {
                    Object[] objArr = (Object[]) o;
                    DefaultRevisionEntity revisionEntity = (DefaultRevisionEntity)objArr[1];
                    Course course = (Course) objArr[0];
                    course.getStudents().size();
                    course.getTeachers().size();
                    history.add(
                            new HistoryData<>(
                                    course,
                                    (RevisionType) objArr[2],
                                    revisionEntity.getId(),
                                    revisionEntity.getRevisionDate()
                                            .toInstant()
                                            .atZone(ZoneId.systemDefault())
                                            .toLocalDateTime()
                            )
                    );
                });

        return history;
    }

    @SuppressWarnings({"unchecked", "ResultOfMethodCallIgnored"})
    @Transactional
    public Course getVersionAt(long id, LocalDateTime at){
        long timestamp = at.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        List<Course> courses = (List<Course>) AuditReaderFactory.get(entityManager).createQuery().forRevisionsOfEntity(Course.class, true, false)
                .add(AuditEntity.property("id").eq(id))
                .add(AuditEntity.revisionProperty("timestamp").le(timestamp))
                .addOrder(AuditEntity.revisionProperty("timestamp").desc())
                .setMaxResults(1)
                .getResultList();

        if (courses.isEmpty()) {
            return null;
        }

        Course course = courses.get(0);
        course.getStudents().size();
        course.getTeachers().size();

        return course;
    }
}
