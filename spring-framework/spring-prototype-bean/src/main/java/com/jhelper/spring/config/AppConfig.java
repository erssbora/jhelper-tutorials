package com.jhelper.spring.config;

import com.jhelper.spring.beans.Circle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.jhelper.spring.beans")
public class AppConfig {

  @Bean
  @Scope("prototype")
  public Circle circle() {
    return new Circle();
  }
}
