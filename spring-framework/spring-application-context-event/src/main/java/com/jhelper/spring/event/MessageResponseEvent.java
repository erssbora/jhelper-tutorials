package com.jhelper.spring.event;

import org.springframework.context.ApplicationEvent;

public class MessageResponseEvent extends ApplicationEvent {
  private final int responseCode;
  private final String responseMessage;

  public MessageResponseEvent(Object source, int responseCode, String responseMessage) {
    super(source);
    this.responseCode = responseCode;
    this.responseMessage = responseMessage;
  }

  public int getResponseCode() {
    return responseCode;
  }

  public String getResponseMessage() {
    return responseMessage;
  }
}
