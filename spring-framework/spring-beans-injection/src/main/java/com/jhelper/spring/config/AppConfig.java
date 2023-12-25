package com.jhelper.spring.config;

import com.jhelper.spring.beans.Author;
import com.jhelper.spring.beans.Book;
import com.jhelper.spring.beans.Car;
import com.jhelper.spring.beans.Course;
import com.jhelper.spring.beans.Engine;
import com.jhelper.spring.beans.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jhelper.spring.beans")
public class AppConfig {

  @Bean
  public Author author() {
    return new Author();
  }

  @Bean
  public Book book(Author author) {
    return new Book(author);
  }

  @Bean
  public Course course() {
    return new Course();
  }

  @Bean
  public Student student(Course course) {
    Student student = new Student();
    student.setCourse(course);
    return student;
  }

  @Bean
  public Engine engine() {
    Engine engine = new Engine();
    engine.setMaxTorque(500);
    return engine;
  }

  @Bean
  public Car car() {
    return new Car();
  }

}
