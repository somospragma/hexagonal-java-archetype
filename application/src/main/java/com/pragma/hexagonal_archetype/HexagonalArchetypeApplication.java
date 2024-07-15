package com.pragma.hexagonal_archetype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class HexagonalArchetypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchetypeApplication.class, args);
	}
}
