package com.jhelper.spring.beans;

import jakarta.inject.Singleton;
import org.springframework.stereotype.Component;

@Component
@Singleton
public class Cube {
  public int area(int side) {
    return 6 * side;
  }
}
