package com.jhelper.spring.config;

import com.jhelper.spring.beans.Circle;
import com.jhelper.spring.beans.Rectangle;
import com.jhelper.spring.beans.Square;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig implements BeanDefinitionRegistryPostProcessor {

  @Bean
  public Circle circle() {
    return new Circle();
  }

  @Bean
  public Rectangle rectangle() {
    return new Rectangle();
  }

  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
      throws BeansException {

    // Modify the definition of a exiting bean
    BeanDefinition beanDefinition = registry.getBeanDefinition("rectangle");
    beanDefinition.setScope("prototype");
    beanDefinition.setPrimary(true);

    // check and remove a bean definition if available
    if (registry.containsBeanDefinition("circle")) {
      registry.removeBeanDefinition("circle");
    }

    // Add new bean definition
    GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
    genericBeanDefinition.setBeanClass(Square.class);
    registry.registerBeanDefinition("square", genericBeanDefinition);
  }
}
