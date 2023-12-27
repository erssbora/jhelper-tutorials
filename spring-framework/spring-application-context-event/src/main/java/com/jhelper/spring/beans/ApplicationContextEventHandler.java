package com.jhelper.spring.beans;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextEventHandler {

  @EventListener
  public void handleEvent(ContextStartedEvent event) {
    System.out.println("ContextStartedEvent received");
  }

  @EventListener(value = {ContextRefreshedEvent.class})
  public void handleEvent() {
    System.out.println("ContextRefreshedEvent received");
  }

  @EventListener
  @Async
  public void handleEvent(ContextClosedEvent event) {
    System.out.println("ContextStartedEvent received");
  }

  @EventListener
  public void handleEvent(ContextStoppedEvent event) {
    System.out.println("ContextStoppedEvent received");
  }
}
