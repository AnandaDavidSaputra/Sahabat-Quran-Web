package com.sahabatquran.app.web.selenium;

import org.junit.jupiter.api.Test;

import com.sahabatquran.app.web.selenium.pages.HomePage;

class HomePageTests extends BaseSeleniumTests {

	@Test
	void testMainPage() {
        HomePage page = new HomePage(webDriver, 
			getHostUrl() + "/", 
			"Sahabat Quran");
        page.checkTitle("Sahabat Quran");
	}
}
