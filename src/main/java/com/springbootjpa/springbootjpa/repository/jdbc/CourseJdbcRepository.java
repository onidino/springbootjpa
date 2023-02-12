package com.springbootjpa.springbootjpa.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Basic repository to execute SQL queries into the database.
 */
@Repository
public class CourseJdbcRepository {

  private static final String INSERT_QUERY = """
      insert into course (id, name, author)
      values(1, 'LEARN AWS', 'in28minutes')
      """;
  @Autowired
  private final JdbcTemplate springJdbcTemplate;

  public CourseJdbcRepository(final JdbcTemplate springJdbcTemplate) {
    this.springJdbcTemplate = springJdbcTemplate;
  }

  /**
   * Insert method.
   */
  public void insert() {
    springJdbcTemplate.update(INSERT_QUERY);
  }

}
