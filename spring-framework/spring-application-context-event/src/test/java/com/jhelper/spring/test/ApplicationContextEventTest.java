package com.jhelper.spring.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jhelper.spring.beans.MessageSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextEventTest {

  @Test
  void testApplicationContextEvents() {

    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext("com.jhelper.spring.beans");
    assertNotNull(applicationContext);

    applicationContext.start();
    applicationContext.stop();
    applicationContext.close();
  }

  @Test
  void testCustomApplicationEvents() {

    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext("com.jhelper.spring.beans");
    assertNotNull(applicationContext);

    MessageSenderService messageSenderService =
        applicationContext.getBean(MessageSenderService.class);
    assertNotNull(messageSenderService);
    messageSenderService.sendMessage("Hi there! this is an example of publishing custom event.");
  }
}
