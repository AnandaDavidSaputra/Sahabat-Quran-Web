package com.sahabatquran.app.web.selenium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.UseMainMethod;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;

import com.sahabatquran.app.web.TestcontainersConfiguration;
import com.sahabatquran.app.web.selenium.pages.LoginPage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Import(TestcontainersConfiguration.class)
@SpringBootTest(useMainMethod = UseMainMethod.WHEN_AVAILABLE, webEnvironment = WebEnvironment.RANDOM_PORT)
class LoginPageTests extends BaseSeleniumTests {

	@Test
	void testLoginPage() {
		LoginPage page = new LoginPage(webDriver, 
			getHostUrl() + "/login");
		page.setUsername("udin@yopmail.com");
		page.setPassword("admin");
		page.clickLoginBtn();
		page.checkPageTitle("Sahabat Quran");
	}
}
