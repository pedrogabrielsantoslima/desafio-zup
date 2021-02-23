package br.com.desafio.zup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.desafio.zup")
public class DesafioZupApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioZupApplication.class, args);
	}

}
