package com.vytrack.test.userstory3;

import com.vytrack.test.utilities.Driver;
import com.vytrack.test.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class B26G13_22 {

    @Test
    public void test001() throws InterruptedException {
        VyTrack_Utilities.vyTrackLogin();

        WebElement fleetHeader = Driver.getDriver().findElement(By.xpath("//h1[@class='logo logo-text']"));
        String actualHeader = fleetHeader.getText();
        String expectedHeader = "FLEET MANAGEMENT";

        Assert.assertEquals(actualHeader, expectedHeader, "Failed!");

        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//a[@href='#']//span)[1]"));
        fleetBtn.click();

        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[2]"));
        vehicleOdometer.click();

        WebElement odometerRow = Driver.getDriver().findElement(By.xpath("//tr[@class='grid-row row-click-action']"));
        odometerRow.click();

        WebElement editBtn = Driver.getDriver().findElement(By.xpath("//a[@title='Edit Vehicle Odometer']"));
        editBtn.click();

        WebElement odometerValue = Driver.getDriver().findElement(By.xpath("//input[@name='custom_entity_type[OdometerValue]']"));
        odometerValue.clear();
        odometerValue.sendKeys("115599");

        String actualOdometerValue = odometerValue.getAttribute("value");
        String expectedOdometerValue = "115599";
        Assert.assertEquals(actualOdometerValue, expectedOdometerValue,
                "Expected odometer value [" + expectedOdometerValue + "] doesn't match with actual value [" + actualOdometerValue +
                        "]");

        WebElement saveAndCloseBtn = Driver.getDriver().findElement(By.xpath("(//button[@type='submit'])[1]"));
        saveAndCloseBtn.click();

        WebElement editMessage = Driver.getDriver().findElement(By.xpath("//div[@class='message']"));
        String actualEditMessage = editMessage.getText();
        String expectedEditMessage = "Entity saved";

        Assert.assertEquals(actualEditMessage, expectedEditMessage, "Not match!!!");

        Driver.closeDriver();
    }
}