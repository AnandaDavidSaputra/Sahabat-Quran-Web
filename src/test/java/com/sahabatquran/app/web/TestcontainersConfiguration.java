package com.sahabatquran.app.web;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfiguration {

	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgresContainer() {
		return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16"));
	}

	@SuppressWarnings("resource")
	@Bean
	BrowserWebDriverContainer<?> browserContainer(){
		return new BrowserWebDriverContainer<>()
			.withAccessToHost(true)
    		.withCapabilities(new FirefoxOptions());
	}
}
