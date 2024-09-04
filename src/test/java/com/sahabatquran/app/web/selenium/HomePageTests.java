package com.sahabatquran.app.web.selenium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.UseMainMethod;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;

import com.sahabatquran.app.web.TestcontainersConfiguration;
import com.sahabatquran.app.web.selenium.pages.HomePage;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(useMainMethod = UseMainMethod.WHEN_AVAILABLE, webEnvironment = WebEnvironment.RANDOM_PORT)
class HomePageTests extends BaseSeleniumTests {

	@Test
	void testMainPage() {
        HomePage page = new HomePage(webDriver, 
			getHostUrl() + "/", 
			"Sahabat Quran");
        page.checkTitle("Sahabat Quran");
	}
}
