package com.jhelper.spring.beans.twod;

import org.springframework.stereotype.Component;

@Component
public class Square {
  public int area(int side) {
    return side * side;
  }
}
