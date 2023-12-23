package com.jhelper.spring.beans;



public class Sphere {
  public double volume(int radius) {

    return (4 / 3d) * Math.PI * radius * radius * radius;
  }
}
