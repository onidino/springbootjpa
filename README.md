# SPRING BOOT - TESTING JDBC, JPA & SPRING DATA JPA

SpringBoot basic application for test different data repository implementations to save data in H2:

- JDBC Repository: Implementation with SQL explicit queries to write and read data.
- JPA Repository: Using EntityManager to manage the methods to write and read data.
- Spring Data JPA: Using an interface that extends from JpaRepository to test default and 
  some minor customs functions to read and write data.

The project has a simple COURSE class corresponding to the following table structure with the following structure:

  create table course(
  id      bigint        not null,
  name    varchar(255)  not null,
  author  varchar(255)  not null,
  primary key (id));
 
 The data can be read in the LOGs of the console:

![image](https://user-images.githubusercontent.com/51863674/218346182-3c265868-5479-4422-b5d2-fd3c9a738a7a.png)

As well as can be accessed via the H2 Local Console:

http://localhost:8080/h2-console

![image](https://user-images.githubusercontent.com/51863674/218346238-ed5d8a9b-b6de-4216-adac-65d197a2707a.png)

(No credentials needed, just clic connect to access the H2 console)
