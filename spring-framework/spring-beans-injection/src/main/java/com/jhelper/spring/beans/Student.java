package com.jhelper.spring.beans;

public class Student {

  private Course course;

  public void setCourse(Course course) {
    this.course = course;
  }

  public String getCourseName() {
    return course.getName();
  }
}
