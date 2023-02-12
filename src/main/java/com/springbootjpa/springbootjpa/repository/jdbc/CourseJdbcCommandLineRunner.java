package com.springbootjpa.springbootjpa.repository.jdbc;

import com.springbootjpa.springbootjpa.entities.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Command line runner for testing SQL executions. This executes "run" on start of the application.
 */
@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

  private static final Logger LOG = LoggerFactory.getLogger(CourseJdbcCommandLineRunner.class);

  @Autowired
  private final CourseJdbcRepository repository;

  public CourseJdbcCommandLineRunner(CourseJdbcRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) {
    // Testing inserting rows in the h2 db
    LOG.info("INSERTING ROWS 1, 2, 3");
    repository.insert(new Course(1, "LEARN SPRING BOOT", "in28minutes"));
    repository.insert(new Course(2, "LEARN AWS", "in28minutes"));
    repository.insert(new Course(3, "LEARN GRAPHQL", "in28minutes"));

    // Testing deleting row with id 2
    LOG.info("DELETING ROW 2");
    repository.deleteById(2);

    // Testing find a row by id
    LOG.info("FINDING ROW 1, 3");
    LOG.info("ROW 1 {}", repository.findById(1));
    LOG.info("ROW 3 {}", repository.findById(3));
  }
}
