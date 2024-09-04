package com.sahabatquran.app.web.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

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
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public boolean isHomeOpen()
    {
        String expected_title = "Sahabat Quran | Home";
        String win_title = webDriver.getTitle();
        return win_title.contains(expected_title);
    }


}
