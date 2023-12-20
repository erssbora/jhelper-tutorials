package com.jhelper.spring.config;

import com.jhelper.spring.beans.twod.Rectangle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwodAppConfig {
  @Bean
  public Rectangle rectangle() {
    return new Rectangle();
  }
}
