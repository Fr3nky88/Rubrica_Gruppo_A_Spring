package it.develhope.gruppoa.rubrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "it.develhope.gruppoa.rubrica")
public class RubricaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RubricaApplication.class, args);
	}

}
