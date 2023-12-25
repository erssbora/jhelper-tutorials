package com.jhelper.spring.beans;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.Resource;

@ManagedBean
public class Boat {
  private Engine engine;

  @Resource
  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  public int getMaxTorque() {
    return engine.getMaxTorque();
  }
}
