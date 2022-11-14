package edu.uco.stl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.uco.stl"})
public class StlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StlApiApplication.class, args);
	}

}
