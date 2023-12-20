package com.jhelper.spring.config;

import com.jhelper.spring.beans.twod.Circle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Circle circle() {
    return new Circle();
  }
}
