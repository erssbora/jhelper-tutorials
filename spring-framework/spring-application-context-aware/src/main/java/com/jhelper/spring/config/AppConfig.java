package com.jhelper.spring.config;

import com.jhelper.spring.beans.User;
import com.jhelper.spring.beans.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public User user() {
    User user = new User();
    user.setName("John Doe");
    return user;
  }

  @Bean
  public UserService userService() {
    return new UserService();
  }
}
