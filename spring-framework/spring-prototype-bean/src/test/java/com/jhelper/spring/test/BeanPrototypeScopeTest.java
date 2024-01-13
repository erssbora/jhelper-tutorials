package com.jhelper.spring.test;

import com.jhelper.spring.beans.Circle;
import com.jhelper.spring.beans.Rectangle;
import com.jhelper.spring.config.AppConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BeanPrototypeScopeTest {
  private ApplicationContext applicationContext;

  @BeforeAll
  void setup() {
    applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
  }

  @Test
  void testBeanPrototypeScope() {
    String[] circleBeanNames = applicationContext.getBeanNamesForType(Circle.class);
    assertNotNull(circleBeanNames);
    assertEquals(1, circleBeanNames.length);
    assertTrue(applicationContext.isPrototype(circleBeanNames[0]));

    String[] rectangleBeanNames = applicationContext.getBeanNamesForType(Rectangle.class);
    assertNotNull(circleBeanNames);
    assertEquals(1, rectangleBeanNames.length);
    assertTrue(applicationContext.isPrototype(rectangleBeanNames[0]));
  }

  @Test
  void testGetPrototypeBeans() {
    Circle circle1 = applicationContext.getBean(Circle.class);
    Circle circle2 = applicationContext.getBean(Circle.class);
    assertNotEquals(circle1, circle2);

    Rectangle rectangle1 = applicationContext.getBean(Rectangle.class);
    Rectangle rectangle2 = applicationContext.getBean(Rectangle.class);
    assertNotEquals(rectangle1, rectangle2);
  }
}
