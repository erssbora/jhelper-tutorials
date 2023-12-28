package com.jhelper.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.jhelper.spring.beans")
@Import({DevAppConfig.class, ProdAppConfig.class})
public class AppConfig {}
