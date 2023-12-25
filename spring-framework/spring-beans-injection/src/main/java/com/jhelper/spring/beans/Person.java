package com.jhelper.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
  private Address address;

  @Autowired
  public void setAddress(Address address) {
    this.address = address;
  }

  public int getHouseNumber() {
    return address.getHouseNumber();
  }
}
