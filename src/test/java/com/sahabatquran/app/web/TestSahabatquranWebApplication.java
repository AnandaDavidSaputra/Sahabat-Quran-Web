package com.sahabatquran.app.web;

import org.springframework.boot.SpringApplication;

public class TestSahabatquranWebApplication {

	public static void main(String[] args) {
		SpringApplication.from(SahabatquranWebApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
