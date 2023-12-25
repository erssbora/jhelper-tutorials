package com.jhelper.spring.beans;

import jakarta.inject.Named;

@Named
public class Hemisphere {
  public double volume(int radius) {
    return (2 / 3d) * Math.PI * radius * radius * radius;
  }
}
