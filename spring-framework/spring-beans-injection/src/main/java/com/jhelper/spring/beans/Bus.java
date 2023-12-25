package com.jhelper.spring.beans;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.Resource;

@ManagedBean
public class Bus {

  @Resource private Engine engine;

  public int getMaxTorque() {
    return engine.getMaxTorque();
  }
}
