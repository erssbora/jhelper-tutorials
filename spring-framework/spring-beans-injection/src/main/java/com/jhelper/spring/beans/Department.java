package com.jhelper.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Department {
  private String name;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
