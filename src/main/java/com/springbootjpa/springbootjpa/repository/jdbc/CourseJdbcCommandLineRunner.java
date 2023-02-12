package com.springbootjpa.springbootjpa.repository.jdbc;

import com.springbootjpa.springbootjpa.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Command line runner for testing SQL executions. This executes "run" on start of the application.
 */
@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

  @Autowired
  private final CourseJdbcRepository repository;

  public CourseJdbcCommandLineRunner(CourseJdbcRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) {
    // Testing inserting rows in the h2 db
    repository.insert(new Course(1, "LEARN SPRING BOOT", "in28minutes"));
    repository.insert(new Course(2, "LEARN AWS", "in28minutes"));
    repository.insert(new Course(3, "LEARN GRAPHQL", "in28minutes"));

    // Testing deleting row with id 2
    repository.deleteById(2);
  }
}
