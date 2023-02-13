package com.springbootjpa.springbootjpa.repository;

import com.springbootjpa.springbootjpa.entities.Course;
import com.springbootjpa.springbootjpa.repository.spring_jpa.CourseSpringDataJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Command line runner for testing JDBC, JPA & Spring JPA repositories.
 */
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

  private static final Logger LOG = LoggerFactory.getLogger(CourseCommandLineRunner.class);

  // Spring Data JPA repositories
  @Autowired
  private final CourseSpringDataJpaRepository repository;

//  JDBC Repository
//  @Autowired
//  private final CourseJdbcRepository repository;

//  JPA Repository
//  @Autowired
//  private final CourseJpaRepository repository;

  public CourseCommandLineRunner(CourseSpringDataJpaRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) {
    LOG.info("Testing inserting rows in the h2 db");
// repository.insert is only for JDBC & JPA repositories
//    repository.insert(new Course(1, "LEARN SPRING BOOT", "in28minutes"));
//    repository.insert(new Course(2, "LEARN AWS", "in28minutes"));
//    repository.insert(new Course(3, "LEARN GRAPHQL", "in28minutes"));
    repository.save(new Course(1, "LEARN SPRING BOOT", "in28minutes"));
    repository.save(new Course(2, "LEARN AWS", "in28minutes"));
    repository.save(new Course(3, "LEARN GRAPHQL", "testAuthor"));

    LOG.info("Testing listing all rows");
    LOG.info("ROWS: COUNT {} - {}", repository.count(), repository.findAll());

    LOG.info("Testing deleting row with id 2");
    repository.deleteById(2L);
    LOG.info("ROWS: COUNT {} - {}", repository.count(), repository.findAll());

    LOG.info("Testing find a row by id 1, 3");
    LOG.info("ROW 1: {}", repository.findById(1L));
    LOG.info("ROW 3: {}", repository.findById(3L));

    LOG.info("Testing find a row by author: 'testAuthor'");
    LOG.info("ROW: {}", repository.findByAuthor("testAuthor"));

    LOG.info("Testing find a row by name: 'LEARN SPRING BOOT'");
    LOG.info("ROW: {}", repository.findByName("LEARN SPRING BOOT"));
  }
}
