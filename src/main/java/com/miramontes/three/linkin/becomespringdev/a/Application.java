package com.miramontes.three.linkin.becomespringdev.a;

import com.miramontes.three.linkin.becomespringdev.a.service.GreetingService;
import com.miramontes.three.linkin.becomespringdev.a.service.OutputService;
import com.miramontes.three.linkin.becomespringdev.a.service.TimeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException {
		GreetingService greetingService = new GreetingService("Hello");
		TimeService timeService = new TimeService(true);
		OutputService outputService = new OutputService(greetingService, timeService);

		for (int i=0;i<5;i++){
			outputService.generateOutput("Jesús");
			Thread.sleep(5000);
		}
	}

}
