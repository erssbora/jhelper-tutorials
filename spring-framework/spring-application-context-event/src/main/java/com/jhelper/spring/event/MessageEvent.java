package com.jhelper.spring.event;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {

  private String message;

  public MessageEvent(Object source, String message) {
    super(source);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
