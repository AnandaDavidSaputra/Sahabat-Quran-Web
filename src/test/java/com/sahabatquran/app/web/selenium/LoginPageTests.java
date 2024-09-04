package com.sahabatquran.app.web.selenium;

import org.junit.jupiter.api.Test;

import com.sahabatquran.app.web.selenium.pages.LoginPage;

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
