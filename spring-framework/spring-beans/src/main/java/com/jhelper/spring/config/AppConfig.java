package com.jhelper.spring.config;

import com.jhelper.spring.beans.Cone;
import com.jhelper.spring.beans.Cylinder;
import com.jhelper.spring.beans.Pyramid;
import com.jhelper.spring.beans.Sphere;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.jhelper.spring.beans")
public class AppConfig {

  @Bean
  public Cone cone() {
    return new Cone();
  }

  @Bean(value = {"cylinderBean"})
  public Cylinder cylinder() {
    return new Cylinder();
  }

  @Bean(name = {"sphereBean", "beanSphere"})
  public Sphere sphere() {
    return new Sphere();
  }

  @Bean
  @Scope("prototype")
  public Pyramid pyramid(int baseLength, int baseHeight, int height) {
    return new Pyramid(baseLength, baseHeight, height);
  }
}
