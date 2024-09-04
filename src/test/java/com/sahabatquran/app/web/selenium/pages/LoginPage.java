package com.sahabatquran.app.web.selenium.pages;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[@id='loginBtn']")
    WebElement loginBtn;

    private WebDriver webDriver;

    public LoginPage(WebDriver wd, String url) {
        this.webDriver = wd;
        webDriver.get(url);
        PageFactory.initElements(webDriver, this);
    }

    public void setUsername(String username) {
        this.username.clear();
        this.username.sendKeys(username);
    }

    public void setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }


    public void clickLoginBtn() {
        this.loginBtn.click();
        new WebDriverWait(this.webDriver, Duration.ofSeconds(5))
        .until(ExpectedConditions.titleIs("Sahabat Quran"));
    }

    public void checkPageTitle(String title) {
        Assertions.assertTrue(webDriver.getPageSource().contains(title));
    }


}
