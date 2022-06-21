package com.vytrack.test.userstory3;


import com.vytrack.test.utilities.ConfigurationReader;
import com.vytrack.test.utilities.Driver;
import com.vytrack.test.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC001 {

    @Test
    public void test001() throws InterruptedException {
       VyTrack_Utilities.vyTrackLogin();

        WebElement fleetHeader = Driver.getDriver().findElement(By.xpath("//h1[@class='logo logo-text']"));
        //Thread.sleep(500);
        String actualHeader = fleetHeader.getText();
        String expectedHeader = "FLEET MANAGEMENT";

        Assert.assertEquals(actualHeader, expectedHeader, "Failed!");

        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//a[@href='#']//span)[1]"));
        fleetBtn.click();

        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[2]"));
        vehicleOdometer.click();

        WebElement odometerRow = Driver.getDriver().findElement(By.xpath("//tr[@class='grid-row row-click-action']"));
        odometerRow.click();

        WebElement userName = Driver.getDriver().findElement(By.xpath("//h1[@class='user-name']"));
        String actualUserName = userName.getText();
        String expectedUserName = userName.getText();

        Assert.assertEquals(actualUserName, expectedUserName, "Username not match!");

        WebElement deleteBtn = Driver.getDriver().findElement(By.xpath("//a[@title='Delete Vehicle Odometer']"));
        deleteBtn.click();

        WebElement yesDeleteBtn = Driver.getDriver().findElement(By.xpath("//a[@class='btn ok btn-danger']"));
        yesDeleteBtn.click();

        WebElement deleteMessage = Driver.getDriver().findElement(By.xpath("//div[@class='message']"));
        deleteMessage.isDisplayed();
        Assert.assertEquals(deleteMessage.getText(), "Vehicle Odometer deleted","Not match!!!");

        Driver.closeDriver();

    }
}
