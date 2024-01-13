package com.jhelper.spring.test;

import com.jhelper.spring.beans.Circle;
import com.jhelper.spring.beans.Cone;
import com.jhelper.spring.beans.Cube;
import com.jhelper.spring.beans.Rectangle;
import com.jhelper.spring.beans.Square;
import com.jhelper.spring.beans.Triangle;
import com.jhelper.spring.config.AppConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BeanSingletonScopeTest {

  private ApplicationContext applicationContext;

  @BeforeAll
  void setup() {
    applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
  }

  @Test
  void testBeanDefaultScope() {
    String[] circleBeanNames = applicationContext.getBeanNamesForType(Circle.class);
    assertEquals(1, circleBeanNames.length);
    assertEquals("circle", circleBeanNames[0]);
    assertTrue(applicationContext.isSingleton(circleBeanNames[0]));

    String[] rectangleBeanNames = applicationContext.getBeanNamesForType(Rectangle.class);
    assertEquals(1, rectangleBeanNames.length);
    assertEquals("rectangle", rectangleBeanNames[0]);
    assertTrue(applicationContext.isSingleton(rectangleBeanNames[0]));
  }

  @Test
  void testBeanSingletonScope() {
    String[] squareBeanNames = applicationContext.getBeanNamesForType(Square.class);
    assertEquals(1, squareBeanNames.length);
    assertEquals("square", squareBeanNames[0]);
    assertTrue(applicationContext.isSingleton(squareBeanNames[0]));

    String[] triangleBeanNames = applicationContext.getBeanNamesForType(Triangle.class);
    assertEquals(1, triangleBeanNames.length);
    assertEquals("triangle", triangleBeanNames[0]);
    assertTrue(applicationContext.isSingleton(triangleBeanNames[0]));

    String[] coneBeanNames = applicationContext.getBeanNamesForType(Cone.class);
    assertEquals(1, coneBeanNames.length);
    assertEquals("cone", coneBeanNames[0]);
    assertTrue(applicationContext.isSingleton(coneBeanNames[0]));

    String[] cubeBeanNames = applicationContext.getBeanNamesForType(Cube.class);
    assertEquals(1, cubeBeanNames.length);
    assertEquals("cube", cubeBeanNames[0]);
    assertTrue(applicationContext.isSingleton(cubeBeanNames[0]));
  }
}
