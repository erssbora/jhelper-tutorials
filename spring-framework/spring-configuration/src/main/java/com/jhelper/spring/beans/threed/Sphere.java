package com.jhelper.spring.beans.threed;

public class Sphere {
  private static final double PI = 3.14159;

  public double area(int radius) {
    return 4 * PI * radius * radius;
  }
}
