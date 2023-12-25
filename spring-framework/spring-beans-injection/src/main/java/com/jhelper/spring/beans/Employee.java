package com.jhelper.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Employee {

  private Department department;

  public Employee(Department department) {
    this.department = department;
  }

  public String getDepartmentName() {
    return department.getName();
  }
}
