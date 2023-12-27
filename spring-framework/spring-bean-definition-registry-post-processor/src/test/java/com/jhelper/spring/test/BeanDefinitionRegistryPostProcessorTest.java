package com.jhelper.spring.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jhelper.spring.beans.Rectangle;
import com.jhelper.spring.beans.Square;
import com.jhelper.spring.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class BeanDefinitionRegistryPostProcessorTest {

  @Test
  void testBeanDefinitionRegistryPostProcessor() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    assertNotNull(applicationContext);

    // Assert removed bean
    assertFalse(applicationContext.containsBean("circle"));

    // Assert modified bean
    assertTrue(applicationContext.isPrototype("rectangle"));
    Rectangle rectangle=applicationContext.getBean(Rectangle.class);
    assertNotNull(rectangle);

    // Assert newly added bean
    Square square = applicationContext.getBean(Square.class);
    assertNotNull(square);
  }
}
