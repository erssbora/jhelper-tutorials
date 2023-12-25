package com.jhelper.spring.test;

import com.jhelper.spring.beans.Cone;
import com.jhelper.spring.beans.Cube;
import com.jhelper.spring.beans.Cuboid;
import com.jhelper.spring.beans.Cylinder;
import com.jhelper.spring.beans.Hemisphere;
import com.jhelper.spring.beans.RectangularPrism;
import com.jhelper.spring.beans.UserController;
import com.jhelper.spring.beans.UserRepository;
import com.jhelper.spring.beans.UserService;
import com.jhelper.spring.config.AppConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BeanDefinitionTest {
  private ApplicationContext applicationContext;

  @BeforeAll
  public void setup() {
    applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
  }

  @Test
  void testGetBeanDefinedWithBeanAnnotation() {

    // Retrieve bean
    Cone coneBean = applicationContext.getBean(Cone.class);
    assertNotNull(coneBean);
    assertEquals(130.89969389957471, coneBean.volume(5, 5));

    // Retrieve bean by name
    Object cylinderBean = applicationContext.getBean("cylinderBean");
    assertTrue(cylinderBean instanceof Cylinder);
  }

  @Test
  void testGetBeanDefinedWithStereotypeAnnotation() {
    // Retrieve @Component object
    Cube cubeBean = applicationContext.getBean(Cube.class);
    assertNotNull(cubeBean);
    assertEquals(125, cubeBean.volume(5));

    // Retrieve @Controller object
    UserController userController = applicationContext.getBean(UserController.class);
    assertNotNull(userController);

    // Retrieve @Service object
    UserService userService = applicationContext.getBean(UserService.class);
    assertNotNull(userService);

    // Retrieve @Repository object
    UserRepository userRepository = applicationContext.getBean(UserRepository.class);
    assertNotNull(userRepository);

    // Retrieve @Component by name
    Object cuboidBean = applicationContext.getBean("cuboidBean");
    assertTrue(cuboidBean instanceof Cuboid);
    assertEquals(125, ((Cuboid) cuboidBean).volume(5, 5, 5));
  }

  @Test
  void testGetBeanDefinedWithXmlBeanElement() {
    ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");

    // Retrieve bean object
    Cylinder cylinderBean = xmlApplicationContext.getBean(Cylinder.class);
    assertNotNull(cylinderBean);
    assertEquals(785.3981633974483, cylinderBean.volume(5, 10));

    // Retrieve @Component object
    Cube cubeBean = xmlApplicationContext.getBean(Cube.class);
    assertNotNull(cubeBean);
    assertEquals(125, cubeBean.volume(5));
  }

  @Test
  void testGetBeanDefinedWithNamedAnnotation() {
    Hemisphere hemisphereBean = applicationContext.getBean(Hemisphere.class);
    assertNotNull(hemisphereBean);
    assertEquals(261.79938779914943, hemisphereBean.volume(5));
  }

  @Test
  void testGetBeanDefinedWithManagedBeanAnnotation() {
    RectangularPrism rectangularPrismBean = applicationContext.getBean(RectangularPrism.class);
    assertNotNull(rectangularPrismBean);
    assertEquals(60, rectangularPrismBean.volume(5, 4, 3));
  }
}
