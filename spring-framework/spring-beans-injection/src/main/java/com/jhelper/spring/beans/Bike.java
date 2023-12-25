package com.jhelper.spring.beans;

import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike {

  @Inject private Engine engine;

  public int getMaxTorque() {
    return engine.getMaxTorque();
  }
}
