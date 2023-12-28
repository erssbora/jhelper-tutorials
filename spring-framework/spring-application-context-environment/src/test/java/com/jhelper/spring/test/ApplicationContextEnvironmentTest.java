package com.jhelper.spring.test;

import com.jhelper.spring.beans.MailServerProperties;
import com.jhelper.spring.config.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationContextEnvironmentTest {

  @Test
  void testApplicationContextWithDevEnvironment() {
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    applicationContext.getEnvironment().setActiveProfiles("development");
    applicationContext.register(AppConfig.class);
    applicationContext.refresh();

    MailServerProperties mailServerProperties =
        applicationContext.getBean(MailServerProperties.class);
    Assertions.assertEquals("smtp.stage.example.com", mailServerProperties.getHost());
    Assertions.assertEquals(587, mailServerProperties.getPort());
  }

  @Test
  void testApplicationContextWithProdEnvironment() {
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    applicationContext.getEnvironment().setActiveProfiles("production");
    applicationContext.register(AppConfig.class);
    applicationContext.refresh();

    MailServerProperties mailServerProperties =
        applicationContext.getBean(MailServerProperties.class);
    Assertions.assertEquals("smtp.example.com", mailServerProperties.getHost());
    Assertions.assertEquals(587, mailServerProperties.getPort());
  }
}
