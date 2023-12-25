package com.jhelper.spring.beans;

public class Pyramid {

  private final int baseLength;
  private final int baseHeight;
  private final int height;

  public Pyramid(int baseLength, int baseHeight, int height) {
    this.baseHeight = baseHeight;
    this.baseLength = baseLength;
    this.height = height;
  }

  public double volume() {
    return (1 / 3d) * baseLength * baseHeight * height;
  }
}
