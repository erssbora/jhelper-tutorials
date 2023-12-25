package com.jhelper.spring.beans;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class Van {
  private Engine engine;

  @Inject
  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  public int getMaxTorque() {
    return engine.getMaxTorque();
  }
}
