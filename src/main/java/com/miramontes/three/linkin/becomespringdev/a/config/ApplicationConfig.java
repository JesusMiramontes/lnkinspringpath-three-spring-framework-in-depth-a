package com.miramontes.three.linkin.becomespringdev.a.config;

import com.miramontes.three.linkin.becomespringdev.a.service.GreetingService;
import com.miramontes.three.linkin.becomespringdev.a.service.OutputService;
import com.miramontes.three.linkin.becomespringdev.a.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    @Value("${app.greeting}")
    private String greeting;
    @Value("${app.name}")
    private String name;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private TimeService timeService;

    @Bean
    public TimeService timeService(){
        return new TimeService(true);
    }

    @Bean
    public OutputService outputService(){
        return new OutputService(greetingService, timeService, name);
    }

    @Bean
    public GreetingService greetingService(){
        return new GreetingService(greeting);
    }
}
