package com.jhelper.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailServerProperties {

  @Value("${jhelper.mail.host}")
  private String host;

  @Value("${jhelper.mail.port}")
  private int port;

  public String getHost() {
    return host;
  }

  public int getPort() {
    return port;
  }
}
