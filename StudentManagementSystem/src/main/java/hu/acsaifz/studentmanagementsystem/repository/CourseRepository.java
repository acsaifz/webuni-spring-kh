package hu.acsaifz.studentmanagementsystem.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import hu.acsaifz.studentmanagementsystem.model.Course;
import hu.acsaifz.studentmanagementsystem.model.QCourse;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.MultiValueBinding;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long>, QuerydslPredicateExecutor<Course>, QuerydslBinderCustomizer<QCourse> {

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("SELECT DISTINCT c FROM Course c LEFT JOIN FETCH c.students WHERE c IN :courses")
    List<Course> fetchStudents(List<Course> courses);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("SELECT DISTINCT c FROM Course c LEFT JOIN FETCH c.teachers WHERE c IN :courses")
    List<Course> fetchTeachers(List<Course> courses);

    @Override
    default void customize(QuerydslBindings bindings, QCourse course){
        bindings.bind(course.id).first(SimpleExpression::eq);
        bindings.bind(course.name).first(StringExpression::startsWithIgnoreCase);
        bindings.bind(course.teachers.any().name).first(StringExpression::startsWithIgnoreCase);
        bindings.bind(course.students.any().id).first(SimpleExpression::eq);
        bindings.bind(course.students.any().semester).all(semesterBinding);
    }

    //Ez csak kisérletezés volt, hogy így működik-e
    MultiValueBinding<NumberPath<Integer>, Integer> semesterBinding = (path, value) -> {
        if (value.size() != 2) {
            return Optional.empty();
        }
        Iterator<? extends Integer> iterator = value.iterator();
        int first = iterator.next();
        int second = iterator.next();
        return Optional.of(path.between(first,second));
    };

    @Override
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    Page<Course> findAll(Predicate predicate, Pageable pageable);
}
