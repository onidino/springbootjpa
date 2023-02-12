package com.springbootjpa.springbootjpa.repository.spring_jpa;

import com.springbootjpa.springbootjpa.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring JPA repository.
 */
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

}
