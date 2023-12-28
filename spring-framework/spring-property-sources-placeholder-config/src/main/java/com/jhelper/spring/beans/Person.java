package com.jhelper.spring.beans;

import org.springframework.beans.factory.annotation.Value;

public class Person {

  @Value("${person.first.name}")
  private String firstName;

  @Value("${person.last.name}")
  private String lastName;

  @Value("${person.full.name}")
  private String fullName;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFullName() {
    return fullName;
  }
}
