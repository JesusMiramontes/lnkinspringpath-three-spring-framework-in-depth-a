package com.miramontes.three.linkin.becomespringdev.a;

import com.miramontes.three.linkin.becomespringdev.a.config.ApplicationConfig;
import com.miramontes.three.linkin.becomespringdev.a.service.GreetingService;
import com.miramontes.three.linkin.becomespringdev.a.service.OutputService;
import com.miramontes.three.linkin.becomespringdev.a.service.TimeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		OutputService outputService = context.getBean(OutputService.class);

		for (int i=0;i<5;i++){
			outputService.generateOutput();
			Thread.sleep(5000);
		}
	}

}
