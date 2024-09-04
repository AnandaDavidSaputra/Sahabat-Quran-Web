package com.sahabatquran.app.web.selenium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.UseMainMethod;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;

import com.sahabatquran.app.web.TestcontainersConfiguration;
import com.sahabatquran.app.web.selenium.pages.RegisterPage;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(useMainMethod = UseMainMethod.WHEN_AVAILABLE, webEnvironment = WebEnvironment.RANDOM_PORT)
class RegisterPageTests extends BaseSeleniumTests {

	@Test
	void testRegisterPage() {
		RegisterPage page = new RegisterPage(webDriver, 
			getHostUrl() + "/register", 
			"Sahabat Quran | Register");
		page.setFullName("Udin");
		page.setEmail("udin@yopmail.com");
		page.setPhone("123456789");
		page.setPassword("admin");
		page.setConfirmPassword("admin");
		page.verifyRegistrationSuccess();
	}
}
