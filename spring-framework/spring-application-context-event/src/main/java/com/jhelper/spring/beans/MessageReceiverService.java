package com.jhelper.spring.beans;

import com.jhelper.spring.event.MessageEvent;
import com.jhelper.spring.event.MessageResponseEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiverService {

  @EventListener
  public MessageResponseEvent handleMessageEvent(MessageEvent event) {
    System.out.println("MessageEvent received : " + event.getMessage());
    return new MessageResponseEvent(this, 200, "Message received");
  }
}
