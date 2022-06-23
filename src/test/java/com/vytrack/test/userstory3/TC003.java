package com.vytrack.test.userstory3;

import com.vytrack.test.utilities.ConfigurationReader;
import com.vytrack.test.utilities.Driver;
import com.vytrack.test.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003 {

    @Test

    public void test003() throws InterruptedException {
      VyTrack_Utilities.vyTrackLogin();
        // Locating (Fleet Management) web Element
        WebElement NavBar = Driver.getDriver().findElement(By.linkText("Fleet Management"));
        String actualHeader = NavBar.getText();
        String expectedHeader = "Fleet Management";
        // Asserting (Fleet Management) dashboard page is showing
        Assert.assertEquals(actualHeader, expectedHeader, "Assert Failed!!");

        // Locating(Fleet Tab)
        WebElement FleetTab = Driver.getDriver().findElement(By.xpath("(//a[@href='#']//span)[1]"));

        // using hover over method which is moveToElement() so we can move to (Fleet Tab)
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(2000);
        actions.moveToElement(FleetTab).perform();

        // using hover over method which is moveToElement() Then Chainning with click() method so we can move and
        // click on (Vehicle Odometer)
        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[2]"));
        Thread.sleep(2000);
        actions.moveToElement(vehicleOdometer).click().perform();


        //Locate and Asserting that Vehicles Odometers Header is showing
        Thread.sleep(2000);
        WebElement VehiclesOdometers = Driver.getDriver().findElement(By.xpath("//h1[@class='oro-subtitle']"));
       String ActualHeader = VehiclesOdometers.getText();
       String ExpectedHeader = "Vehicles Odometers";
       Assert.assertEquals(actualHeader, expectedHeader, "Assert Failed!!");

        // Locate and Asserting that the Vehicle odometer grid is showing
        WebElement OdometersGrid = Driver.getDriver().findElement(By.id("container"));





    }
}
