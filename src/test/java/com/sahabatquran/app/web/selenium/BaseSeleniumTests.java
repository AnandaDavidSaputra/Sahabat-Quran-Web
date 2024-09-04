package com.sahabatquran.app.web.selenium;

import java.time.Duration;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.testcontainers.Testcontainers;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.lifecycle.TestDescription;

import com.sahabatquran.app.web.TestcontainersConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseSeleniumTests {

    WebDriver webDriver;

    @Autowired
    BrowserWebDriverContainer<?> browserContainer;

    @LocalServerPort Integer webappPort;

    @BeforeEach
	void setupWebDriver() throws Exception {
        Testcontainers.exposeHostPorts(webappPort); 
		webDriver = new RemoteWebDriver(browserContainer.getSeleniumAddress(), new FirefoxOptions());
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		log.info("VNC URL : {}", browserContainer.getVncAddress());
	}

    @AfterEach
	void stopWebDriver(){
		browserContainer.afterTest(
                new TestDescription() {
                    @Override
                    public String getTestId() {
                        return getFilesystemFriendlyName();
                    }

                    @Override
                    public String getFilesystemFriendlyName() {
                        return getTestName();
                    }
                },
                Optional.empty()
            );
		webDriver.quit();
	}

    String getHostUrl(){
        return TestcontainersConfiguration.TESTCONTAINER_HOST_URL + ":" + webappPort;
    }

    String getTestName(){
        return this.getClass().getSimpleName();
    }
}
