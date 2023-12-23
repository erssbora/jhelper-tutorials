package com.jhelper.spring.test;

import com.jhelper.spring.beans.threed.Cone;
import com.jhelper.spring.beans.threed.Cube;
import com.jhelper.spring.beans.threed.Sphere;
import com.jhelper.spring.beans.twod.Circle;
import com.jhelper.spring.beans.twod.Rectangle;
import com.jhelper.spring.beans.twod.Triangle;
import com.jhelper.spring.config.ThreedAppConfig;
import com.jhelper.spring.config.TwodAppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SpringMultiConfigurationTest {

  @Test
  void testXmlBasedMultipleConfiguration() {

    // Instantiate the Spring container with multiple configuration files
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("beans2d.xml", "beans3d.xml");

    // Retrieve bean
    Circle circleBean = applicationContext.getBean(Circle.class);
    assertNotNull(circleBean);
    assertEquals(78.53981633974483, circleBean.area(5));

    // Retrieve bean
    Cone coneBean = applicationContext.getBean(Cone.class);
    assertNotNull(coneBean);
    assertEquals(235.61944901923448, coneBean.area(5, 10));
  }

  @Test
  void testJavaBasedMultipleConfiguration() {

    // Instantiate the Spring container with multiple @Configuration files
    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(TwodAppConfig.class, ThreedAppConfig.class);

    // Retrieve bean
    Rectangle rectangleBean = applicationContext.getBean(Rectangle.class);
    assertNotNull(rectangleBean);
    assertEquals(50, rectangleBean.area(5, 10));

    // Retrieve bean
    Sphere sphereBean = applicationContext.getBean(Sphere.class);
    assertNotNull(sphereBean);
    assertEquals(50.26548245743669, sphereBean.area(2));
  }

  @Test
  void testAnnotationBasedMultipleConfiguration() {

    // Instantiate the Spring container by scanning the packages that contain the Spring components
    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(
            "com.jhelper.spring.beans.threed", "com.jhelper.spring.beans.twod");

    // Retrieve bean
    Triangle triangleBean = applicationContext.getBean(Triangle.class);
    assertNotNull(triangleBean);
    assertEquals(25, triangleBean.area(5, 10));

    // Retrieve bean
    Cube cubeBean = applicationContext.getBean(Cube.class);
    assertNotNull(cubeBean);
    assertEquals(48, cubeBean.area(8));
  }
}
