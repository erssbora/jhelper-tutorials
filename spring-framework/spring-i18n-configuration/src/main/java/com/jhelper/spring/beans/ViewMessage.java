package com.jhelper.spring.beans;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ViewMessage {

  private final MessageSource messageSource;

  public ViewMessage(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  public String getWelcomeMessage(String username, Locale locale) {
    return messageSource.getMessage("welcome.message", new Object[] {username}, locale);
  }

  public String getCookieConsentMessage(Locale locale) {
    return messageSource.getMessage("cookie.consent.message", null, locale);
  }
}
