package com.sahabatquran.app.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SahabatquranWebApplicationTests {

	@Test
	void contextLoads() {
	}

}
