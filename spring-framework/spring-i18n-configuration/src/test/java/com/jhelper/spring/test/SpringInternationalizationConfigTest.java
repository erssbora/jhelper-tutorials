package com.jhelper.spring.test;

import com.jhelper.spring.beans.ViewMessage;
import com.jhelper.spring.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpringInternationalizationConfigTest {

  @Test
  void testI18nConfigForLocaleEnUSWithApplicationContext() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    String welcomeMessage =
        applicationContext.getMessage("welcome.message", new Object[] {"John Deo"}, Locale.US);
    assertEquals("Good Morning John Deo! Welcome to our website.", welcomeMessage);

    String cookieConsentMessage =
        applicationContext.getMessage("cookie.consent.message", null, Locale.US);
    assertEquals(
        "This website uses cookies to ensure you get the best experience.", cookieConsentMessage);
  }

  @Test
  void testI18nConfigForLocaleEsESWithApplicationContext() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    String welcomeMessage =
        applicationContext.getMessage(
            "welcome.message", new Object[] {"John Deo"}, Locale.of("es", "ES"));
    assertEquals("¡Buenos días John Deo! Bienvenido a nuestro sitio web.", welcomeMessage);

    String cookieConsentMessage =
        applicationContext.getMessage("cookie.consent.message", null, Locale.of("es", "ES"));
    assertEquals(
        "Este sitio web utiliza cookies para garantizar que obtenga la mejor experiencia.",
        cookieConsentMessage);
  }

  @Test
  void testI18nConfigForLocaleEnUSWithMessageSourceInjectionInBean() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    ViewMessage viewMessage = applicationContext.getBean(ViewMessage.class);

    assertEquals(
        "Good Morning John Deo! Welcome to our website.",
        viewMessage.getWelcomeMessage("John Deo", Locale.US));
    assertEquals(
        "This website uses cookies to ensure you get the best experience.",
        viewMessage.getCookieConsentMessage(Locale.US));
  }

  @Test
  void testI18nConfigForLocaleEsESWithMessageSourceInjectionInBean() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    ViewMessage viewMessage = applicationContext.getBean(ViewMessage.class);

    assertEquals(
        "¡Buenos días John Deo! Bienvenido a nuestro sitio web.",
        viewMessage.getWelcomeMessage("John Deo", Locale.of("es", "ES")));
    assertEquals(
        "Este sitio web utiliza cookies para garantizar que obtenga la mejor experiencia.",
        viewMessage.getCookieConsentMessage(Locale.of("es", "ES")));
  }
}
