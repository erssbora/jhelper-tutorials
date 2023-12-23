package com.jhelper.spring.beans;

public class Cone {
  public double volume(int radius, int height) {

    return (1 / 3d) * Math.PI * radius * radius * height;
  }
}
