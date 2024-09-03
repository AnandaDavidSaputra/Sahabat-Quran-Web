package com.sahabatquran.app.web.selenium.pages;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(xpath = "//*[@id='pageTitle']")
    private String pageTitle;

    private WebDriver webDriver;

    public HomePage(WebDriver wd, String url){
        this.webDriver = wd;
        webDriver.get(url);
        PageFactory.initElements(webDriver, this);
    }

    public void checkTitle(String title){
        Assertions.assertEquals(title, webDriver.getTitle());
        Assertions.assertEquals(title, new WebDriverWait(webDriver, Duration.ofSeconds(5))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pageTitle']")))
        .getText());
    }
}
