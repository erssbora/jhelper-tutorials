package com.jhelper.spring.beans;

import jakarta.annotation.ManagedBean;

@ManagedBean
public class RectangularPrism {
  public int volume(int length, int width, int height) {
    return length * width * height;
  }
}
