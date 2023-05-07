package com.peenc.consultalol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.peenc.consultalol.controllers","com.peenc.consultalol.services","com.peenc.consultalol.config"})	
public class ConsultaLolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaLolApplication.class, args);
	}

}
