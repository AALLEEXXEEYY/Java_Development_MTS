package ru.mts.dz7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Dz7Application {

	public static void main(String[] args) {
		SpringApplication.run(Dz7Application.class, args);

	}
}
