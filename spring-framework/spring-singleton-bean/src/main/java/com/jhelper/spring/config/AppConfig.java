package com.jhelper.spring.config;

import com.jhelper.spring.beans.Circle;
import com.jhelper.spring.beans.Cone;
import com.jhelper.spring.beans.Square;
import jakarta.inject.Singleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.jhelper.spring.beans")
public class AppConfig {

  @Bean
  public Circle circle() {
    return new Circle();
  }

  @Bean
  @Scope(value = "singleton")
  public Square square() {
    return new Square();
  }

  @Bean
  @Singleton
  public Cone cone() {
    return new Cone();
  }
}
