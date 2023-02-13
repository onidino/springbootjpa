package com.springbootjpa.springbootjpa.repository.spring_jpa;

import com.springbootjpa.springbootjpa.entities.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring JPA repository.
 */
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

  List<Course> findByAuthor(String author);

  List<Course> findByName(String name);

}
