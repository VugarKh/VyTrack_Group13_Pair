package com.vytrack.test.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VyTrack_Utilities {


    public static void vyTrackLogin() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        WebElement userName = Driver.getDriver().findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement passWord =Driver.getDriver().findElement(By.id("prependedInput2"));
        passWord.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginBtn = Driver.getDriver().findElement(By.id("_submit"));
        loginBtn.click();
    }
}
