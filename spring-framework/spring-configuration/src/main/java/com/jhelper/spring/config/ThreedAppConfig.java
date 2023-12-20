package com.jhelper.spring.config;

import com.jhelper.spring.beans.threed.Sphere;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreedAppConfig {

  @Bean
  public Sphere sphere() {
    return new Sphere();
  }
}
