package com.jhelper.spring.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Rectangle {
  public int area(int width, int height) {
    return width * height;
  }
}
