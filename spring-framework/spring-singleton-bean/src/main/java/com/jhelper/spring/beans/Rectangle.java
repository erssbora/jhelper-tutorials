package com.jhelper.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Rectangle {
  public int area(int width, int height) {
    return width * height;
  }
}
