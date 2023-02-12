package com.springbootjpa.springbootjpa.repository.jdbc;

import com.springbootjpa.springbootjpa.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Basic repository to execute SQL queries into the database.
 */
@Repository
public class CourseJdbcRepository {

  private static final String INSERT_QUERY = """
      INSERT INTO course (id, name, author)
      VALUES (?, ?, ?)
      """;

  private static final String DELETE_QUERY = """
      DELETE FROM course
      WHERE id = ?
      """;
  @Autowired
  private final JdbcTemplate springJdbcTemplate;

  public CourseJdbcRepository(final JdbcTemplate springJdbcTemplate) {
    this.springJdbcTemplate = springJdbcTemplate;
  }

  /**
   * Insert method.
   */
  public void insert(final Course course) {
    springJdbcTemplate.update(INSERT_QUERY,
        course.getId(),
        course.getName(),
        course.getAuthor());
  }

  /**
   * Insert method.
   */
  public void deleteById(final long id) {
    springJdbcTemplate.update(DELETE_QUERY, id);
  }
}
