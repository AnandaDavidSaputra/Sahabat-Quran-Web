package com.sahabatquran.app.web.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    @FindBy(xpath = "//input[@name='fullName']")
    WebElement fullName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement phone;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='confPassword']")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@id='submitBtn']")
    WebElement submitBtn;

    private WebDriver webDriver;

    public RegisterPage(WebDriver wd, String url) {
        this.webDriver = wd;
        webDriver.get(url);
        PageFactory.initElements(webDriver, this);
    }

    public void setFullName(String fullname) {
        this.fullName.clear();
        this.fullName.sendKeys(fullname);
    }

    public void setEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void setPhone(String phone) {
        this.phone.clear();
        this.phone.sendKeys(phone);
    }

    public void setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        this.confirmPassword.clear();
        this.confirmPassword.sendKeys(password);
    }

    public void clickSubmitBtn() {
        this.submitBtn.click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public boolean isVerifyPageOpen()
    {
        String expected_title = "Registration Success";
        String win_title = webDriver.getTitle();
        return win_title.contains(expected_title);
    }


}
