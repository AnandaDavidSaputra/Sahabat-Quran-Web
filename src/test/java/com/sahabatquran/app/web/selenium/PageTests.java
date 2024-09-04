package com.sahabatquran.app.web.selenium;

import com.sahabatquran.app.web.selenium.pages.LoginPage;
import com.sahabatquran.app.web.selenium.pages.RegisterPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.UseMainMethod;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.testcontainers.Testcontainers;
import org.testcontainers.containers.BrowserWebDriverContainer;

import com.sahabatquran.app.web.TestcontainersConfiguration;
import com.sahabatquran.app.web.selenium.pages.HomePage;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(useMainMethod = UseMainMethod.WHEN_AVAILABLE, webEnvironment = WebEnvironment.RANDOM_PORT)
class PageTests {
    @LocalServerPort
	private Integer webappPort;

	@Autowired 
	private BrowserWebDriverContainer<?> browserContainer;

	private RemoteWebDriver webDriver;

	@BeforeEach
	void setupWebDriver(){
		// supaya host.testcontainers.internal resolve ke IP host yang menjalankan webapp
		Testcontainers.exposeHostPorts(webappPort); 
		webDriver = new RemoteWebDriver(browserContainer.getSeleniumAddress(), new FirefoxOptions());
	}

	@Test
	void testMainPage() {
        HomePage page = new HomePage(webDriver, "http://host.testcontainers.internal:"+webappPort+"/");
        page.checkTitle("Sahabat Quran");
	}

	@Test
	void testRegisterPage() {
		RegisterPage page = new RegisterPage(webDriver, "http://host.testcontainers.internal:"+webappPort+"/register");
		page.setFullName("Udin");
		page.setEmail("udin@yopmail.com");
		page.setPhone("123456789");
		page.setPassword("admin");
		page.setConfirmPassword("admin");
		page.clickSubmitBtn();

		if(page.isVerifyPageOpen()){
			System.out.println("Email address verification page is open\n");
		}
	}

	@Test
	void testLoginPage() {
		LoginPage page = new LoginPage(webDriver, "http://host.testcontainers.internal:"+webappPort+"/login");
		page.setUsername("udin@yopmail.com");
		page.setPassword("admin");
		page.clickLoginBtn();

		if(page.isHomeOpen()){
			System.out.println("Home page is open\n");
		}
	}
}