package com.jhelper.spring.test;

import com.jhelper.spring.beans.Cone;
import com.jhelper.spring.beans.Cylinder;
import com.jhelper.spring.beans.Pyramid;
import com.jhelper.spring.config.AppConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RetrieveBeanTest {
  private ApplicationContext applicationContext;

  @BeforeAll
  public void setup() {
    applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
  }

  @Test
  void testRetrieveBeanByType() {
    // Retrieve bean by class type
    Cone coneBean = applicationContext.getBean(Cone.class);
    assertNotNull(coneBean);
    assertEquals(130.89969389957471, coneBean.volume(5, 5));
  }

  @Test
  void testRetrieveBeanByName() {
    // Retrieve bean by name
    Object coneBean = applicationContext.getBean("cone");
    assertTrue(coneBean instanceof Cone);
    assertEquals(130.89969389957471, ((Cone) coneBean).volume(5, 5));

    // Retrieve bean by user-defined name
    Object cylinderBean = applicationContext.getBean("cylinderBean");
    assertTrue(cylinderBean instanceof Cylinder);
    assertEquals(251.32741228718345, ((Cylinder) cylinderBean).volume(4, 5));

    // Retrieve a bean by user-defined multiple names
    Object sphereBean = applicationContext.getBean("sphereBean");
    Object beanSphere = applicationContext.getBean("beanSphere");
    assertEquals(sphereBean, beanSphere);
  }

  @Test
  void testRetrieveBeanByNameAndType() {
    // Retrieve bean by name and type
    Cylinder cylinderBean = applicationContext.getBean("cylinderBean", Cylinder.class);
    assertNotNull(cylinderBean);
    assertEquals(251.32741228718345, cylinderBean.volume(4, 5));
  }

  @Test
  void testRetrieveBeanByTypeWithConstructorArgs() {
    // Retrieve bean by class type with constructor arguments
    Pyramid pyramidBean = applicationContext.getBean(Pyramid.class, 5, 4, 3);
    assertNotNull(pyramidBean);
    assertEquals(20.0, pyramidBean.volume());
  }

  @Test
  void testRetrieveBeanByNameWithConstructorArgs() {
    // Retrieve bean by name  with constructor arguments
    Object pyramidBean = applicationContext.getBean("pyramid", 5, 4, 3);
    assertTrue(pyramidBean instanceof Pyramid);
    assertEquals(20.0, ((Pyramid) pyramidBean).volume());
  }
}
