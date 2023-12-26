package com.jhelper.spring.beans;

import java.io.IOException;
import java.nio.charset.Charset;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class UserService implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  public String getUserName() {
    // Get bean from applicationContext
    if (applicationContext.containsBean("user")) {
      User user = applicationContext.getBean(User.class);
      return user.getName();
    }
    return null;
  }

  public String getUserId() throws IOException {
    // Get Resource from applicationContext to read files
    Resource resource = applicationContext.getResource("classpath:userid.txt");
    return resource.getContentAsString(Charset.defaultCharset());
  }
}
