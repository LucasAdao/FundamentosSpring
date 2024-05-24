package br.com.lucasadao.projeto_rocketseat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//Serve para definir o scopo que o Spring vai procurar as anotations
@ComponentScan(basePackages = "br.com.lucasadao")
public class ProjetoComSpringBootRocketseatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoComSpringBootRocketseatApplication.class, args);
	}

}
