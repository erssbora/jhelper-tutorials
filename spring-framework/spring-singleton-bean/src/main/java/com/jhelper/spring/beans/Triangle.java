package com.jhelper.spring.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Triangle {
  public double area(int base, int height) {

    return 0.5 * base * height;
  }
}
