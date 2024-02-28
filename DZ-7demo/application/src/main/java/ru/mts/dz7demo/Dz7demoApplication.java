package ru.mts.dz7demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class Dz7demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dz7demoApplication.class, args);

	}
}
