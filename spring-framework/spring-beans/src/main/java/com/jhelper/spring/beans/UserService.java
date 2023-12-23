package com.jhelper.spring.beans;

import org.springframework.stereotype.Service;

@Service
public class UserService {

  public void info() {
    System.out.println("This is a service class");
  }
}
