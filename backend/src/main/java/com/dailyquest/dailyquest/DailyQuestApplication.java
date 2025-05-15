package com.dailyquest.dailyquest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DailyQuestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyQuestApplication.class, args);
	}

}
