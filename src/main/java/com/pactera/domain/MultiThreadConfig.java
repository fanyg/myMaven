package com.pactera.domain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

 @Configuration
 @ComponentScan(basePackages = { "com.pactera" })
 @ImportResource(value = { "classpath*:spring-mvc.xml" })
 @EnableScheduling
 public class MultiThreadConfig {

 }
