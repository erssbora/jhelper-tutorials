package com.jhelper.spring.test;

import com.jhelper.spring.beans.twod.Circle;
import com.jhelper.spring.beans.twod.Rectangle;
import com.jhelper.spring.beans.twod.Square;
import com.jhelper.spring.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SpringConfigurationTest {

  @Test
  void testXmlBasedConfiguration() {
    // Instantiate Spring container
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

    // Retrieve bean from the Spring container
    Rectangle rectangleBean = applicationContext.getBean(Rectangle.class);
    assertNotNull(rectangleBean);
    assertEquals(50, rectangleBean.area(10, 5));
  }

  @Test
  void testJavaBasedConfiguration() {
    // Instantiate Spring container
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    // Retrieve bean from the Spring container
    Circle circleBean = applicationContext.getBean(Circle.class);
    assertNotNull(circleBean);
    assertEquals(78.53981633974483, circleBean.area(5));
  }

  @Test
  void testAnnotationBasedConfiguration() {
    // Instantiate Spring container
    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext("com.jhelper.spring.beans");

    // Retrieve bean from the Spring container
    Square squareBean = applicationContext.getBean(Square.class);
    assertNotNull(squareBean);
    assertEquals(25, squareBean.area(5));
  }
}
