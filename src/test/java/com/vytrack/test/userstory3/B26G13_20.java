package com.vytrack.test.userstory3;

import com.vytrack.test.Utilities.Driver;
import com.vytrack.test.Utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class B26G13_20 {

    @Test
    public void B26G13_test() throws InterruptedException {
        // 1. Navigate to https://qa2.vytrack.com
        // 2. Enter username.
        // 3. Enter password
        // 4. Click log in button

        VyTrack_Utilities.vyTrackLogin();



        // 5. Verify user is on the Dashboard Page, "FLEET MANAGEMENT" dashboard page is displayed
        WebElement fleetMng = Driver.getDriver().findElement(By.xpath("(//a[@href='/'])[2]"));
        Thread.sleep(2000);

        String actualFleetMngBtn = fleetMng.getText();
        String expectedFleetMngBtn = "FLEET MANAGEMENT";

        Thread.sleep(1000);

        Assert.assertEquals(actualFleetMngBtn, expectedFleetMngBtn, "Failed!");

        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//a[@href='#']//span)[1]"));
        fleetBtn.click();

        // 6. Hover over Fleet model, "Vehicle Odometer" feature should be displayed
        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[2]"));
        vehicleOdometer.click();


        Thread.sleep(2000);
        String actualResult = vehicleOdometer.getText();
        String expectedResult = "Vehicle Odometer";
        //Assert.assertEquals(actualResult, expectedResult, "Failed!");
        System.out.println(actualResult);

        // 7. Click on "Vehicle Odometer" feature
        System.out.println("vehicleOdometer.isSelected() = " + vehicleOdometer.isSelected());


        // 8. User is redirected to the Vehicles Odometer page, "Vehicles Odometer" is displayed
        WebElement vehicleOdometerHeader = Driver.getDriver().findElement(By.xpath("//h1[.='Vehicles Odometers']"));

        String actualVehicleOdometer = vehicleOdometerHeader.getText();
        String expectedVehicleOdometer = "Vehicles Odometers";

        Thread.sleep(2000);

        Assert.assertEquals(actualVehicleOdometer, expectedVehicleOdometer, "Failed!");
        Driver.closeDriver();



    }
}
