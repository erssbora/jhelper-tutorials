package com.jhelper.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

  @Autowired private Engine engine;

  public int getMaxTorque() {
    return engine.getMaxTorque();
  }
}
