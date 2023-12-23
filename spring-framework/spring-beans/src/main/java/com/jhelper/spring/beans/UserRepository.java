package com.jhelper.spring.beans;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  public void info() {
    System.out.println("This is a repository class");
  }
}
