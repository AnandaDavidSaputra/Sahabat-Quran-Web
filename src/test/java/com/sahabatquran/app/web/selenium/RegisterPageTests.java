package com.sahabatquran.app.web.selenium;

import org.junit.jupiter.api.Test;

import com.sahabatquran.app.web.selenium.pages.RegisterPage;

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
