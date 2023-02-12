package com.springbootjpa.springbootjpa.repository.jpa;

import com.springbootjpa.springbootjpa.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository.
 */
@Repository
@Transactional
public class CourseJpaRepository {

  @PersistenceContext
  private final EntityManager entityManager;

  public CourseJpaRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  /**
   * Insert course with jpa.
   *
   * @param course the course to insert
   */
  public void insert(Course course) {
    entityManager.merge(course);
  }


  /**
   * Find course by id with jpa.
   *
   * @param id the id of the course
   * @return the course find
   */
  public Course findById(long id) {
    return entityManager.find(Course.class, id);
  }

  /**
   * Delete course with jpa.
   *
   * @param id the id of the course
   */
  public void deleteById(long id) {
    Course courseToDelete = findById(id);
    if (courseToDelete != null) {
      entityManager.remove(courseToDelete);
    }
  }

}
