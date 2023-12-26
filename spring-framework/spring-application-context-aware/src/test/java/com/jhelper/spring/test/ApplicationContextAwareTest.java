package com.jhelper.spring.test;

import com.jhelper.spring.beans.UserService;
import com.jhelper.spring.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApplicationContextAwareTest {

  @Test
  void testApplicationContextAware() throws IOException {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    UserService userService = applicationContext.getBean(UserService.class);
    assertNotNull(userService);
    assertEquals("John Doe", userService.getUserName());
    assertEquals("user100", userService.getUserId());
  }
}
