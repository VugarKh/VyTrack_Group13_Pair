package com.vytrack.test.userstory3;

import com.vytrack.test.base.TestBase;
import com.vytrack.test.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002 extends TestBase {

    @Test
    public void test001() {
        VyTrack_Utilities.vyTrackLogin(driver, "user37", "UserUser123");

        WebElement fleetHeader = driver.findElement(By.xpath("//h1[@class='logo logo-text']"));
        String actualHeader = fleetHeader.getText();
        String expectedHeader = "FLEET MANAGEMENT";

        //Assert.assertEquals(actualHeader, expectedHeader, "Failed!");

        WebElement fleetBtn = driver.findElement(By.xpath("(//a[@href='#']//span)[1]"));
        fleetBtn.click();

        WebElement vehicleOdometer = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[2]"));
        vehicleOdometer.click();

        WebElement odometerRow = driver.findElement(By.xpath("//tr[@class='grid-row row-click-action']"));
        odometerRow.click();

        WebElement editBtn = driver.findElement(By.xpath("//a[@title='Edit Vehicle Odometer']"));
        editBtn.click();

        WebElement odometerValue = driver.findElement(By.xpath("//input[@name='custom_entity_type[OdometerValue]']"));
        odometerValue.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,"99");

        WebElement saveAndCloseBtn = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        saveAndCloseBtn.click();

        WebElement editMessage = driver.findElement(By.xpath("//div[@class='message']"));
        String actualEditMessage = editMessage.getText();
        String expectedEditMessage = "Entity saved";

        Assert.assertEquals(actualEditMessage, expectedEditMessage, "Not match!!!");





    }
}