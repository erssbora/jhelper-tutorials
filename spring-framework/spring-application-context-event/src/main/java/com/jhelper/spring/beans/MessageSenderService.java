package com.jhelper.spring.beans;

import com.jhelper.spring.event.MessageEvent;
import com.jhelper.spring.event.MessageResponseEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderService {

  private ApplicationEventPublisher applicationEventPublisher;

  public MessageSenderService(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public void sendMessage(String message) {
    applicationEventPublisher.publishEvent(new MessageEvent(this, message));
  }

  @EventListener
  public void handleMessageEvent(MessageResponseEvent event) {
    System.out.println("MessageResponseEvent received : ");
    System.out.println("ResponseCode=" + event.getResponseCode());
    System.out.println("Message =" + event.getResponseMessage());
  }
}
