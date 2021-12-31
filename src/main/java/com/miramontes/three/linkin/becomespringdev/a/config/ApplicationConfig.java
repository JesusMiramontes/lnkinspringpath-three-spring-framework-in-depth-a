package com.miramontes.three.linkin.becomespringdev.a.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.miramontes.three.linkin.becomespringdev.a")
public class ApplicationConfig {

}
