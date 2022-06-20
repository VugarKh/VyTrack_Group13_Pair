package com.vytrack.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack_Utilities {

    public static void vyTrackLogin(WebDriver driver, String username, String password) {

        driver.get("https://qa2.vytrack.com/");

        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(username);

        WebElement passWord = driver.findElement(By.id("prependedInput2"));
        passWord.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();
    }
}
