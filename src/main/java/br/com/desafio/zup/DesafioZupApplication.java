package br.com.desafio.zup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "br.com.desafio.zup.models"})
@EnableJpaRepositories(basePackages = { "br.com.desafio.zup.repository"})
@ComponentScan(basePackages = {"br.com.desafio.zup"})
public class DesafioZupApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioZupApplication.class, args);
	}

}
