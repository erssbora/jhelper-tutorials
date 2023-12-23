package com.jhelper.spring.beans;

import org.springframework.stereotype.Component;

@Component(value = "cuboidBean")
public class Cuboid {
  public int volume(int length, int width, int height) {
    return length * width * height;
  }
}
