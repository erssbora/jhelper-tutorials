package com.jhelper.spring.beans.threed;

public class Cone {
  private static final double PI = 3.14159;

  public double area(int radius, int height) {
    return PI * radius * (radius + height);
  }
}
