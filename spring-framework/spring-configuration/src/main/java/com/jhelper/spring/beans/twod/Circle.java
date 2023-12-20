package com.jhelper.spring.beans.twod;

public class Circle {
  private static final double PI = 3.14159;

  public double area(int radius) {
    return PI * radius * radius;
  }
}
