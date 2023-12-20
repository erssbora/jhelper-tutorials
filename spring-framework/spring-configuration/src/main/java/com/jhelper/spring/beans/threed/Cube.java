package com.jhelper.spring.beans.threed;

import org.springframework.stereotype.Component;

@Component
public class Cube {
  public int area(int side) {
    return 6 * side;
  }
}
