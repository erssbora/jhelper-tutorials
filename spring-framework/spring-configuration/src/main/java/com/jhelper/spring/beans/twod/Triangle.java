package com.jhelper.spring.beans.twod;

import org.springframework.stereotype.Component;

@Component
public class Triangle {
  public double area(int base, int height) {

    return 0.5 * base * height;
  }
}
