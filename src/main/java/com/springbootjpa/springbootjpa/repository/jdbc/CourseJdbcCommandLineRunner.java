package com.springbootjpa.springbootjpa.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

  @Autowired
  private final CourseJdbcRepository repository;

  public CourseJdbcCommandLineRunner(CourseJdbcRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) throws Exception {
    this.repository.insert();
  }
}
