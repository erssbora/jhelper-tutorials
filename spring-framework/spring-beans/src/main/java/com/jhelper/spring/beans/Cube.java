package com.jhelper.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Cube {
  public int volume(int side) {
    return side * side * side;
  }
}
