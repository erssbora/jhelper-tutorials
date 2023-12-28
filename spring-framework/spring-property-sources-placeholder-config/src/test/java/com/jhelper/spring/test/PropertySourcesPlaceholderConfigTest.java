package com.jhelper.spring.test;

import com.jhelper.spring.beans.Person;
import com.jhelper.spring.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertySourcesPlaceholderConfigTest {

  @Test
  void testPropertySourcesPlaceholderConfigWithValueAnnotation() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    Person person = applicationContext.getBean(Person.class);
    assertEquals("John", person.getFirstName());
    assertEquals("Doe", person.getLastName());
    assertEquals("John Doe", person.getFullName());
  }

  @Test
  void testPropertySourcesPlaceholderConfigWithEnvironment() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    Environment environment = applicationContext.getEnvironment();
    assertEquals("John", environment.getProperty("person.first.name"));
    assertEquals("Doe", environment.getProperty("person.last.name"));
    assertEquals("John Doe", environment.getProperty("person.full.name"));
  }
}
