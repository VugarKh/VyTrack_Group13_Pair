package com.vytrack.test.userstory3;

import com.vytrack.test.utilities.Driver;
import com.vytrack.test.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class B26G13_17 {


    @Test
    public void createVehicleOdometer() throws InterruptedException {

        VyTrack_Utilities.vyTrackLogin();
        Thread.sleep(3000);
        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleet.click();
        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']"));
        vehicleOdometer.click();

        //creating vehicle odometer
        Thread.sleep(3000);
        WebElement createVehicleOdometer = Driver.getDriver().findElement(By.xpath("(//a[@href='/entity/update/Extend_Entity_VehiclesOdometer/item'])[3]"));
        createVehicleOdometer.click();
        WebElement odometerValue = Driver.getDriver().findElement(By.cssSelector("input[id*='OdometerValue']"));
        odometerValue.sendKeys("123.234");
        String odometerValueText = odometerValue.getText();
        System.out.println("odometerValueText = " + odometerValueText);
        WebElement chooseADate = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Choose a date']"));
        chooseADate.click();
        Select selectMonth = new Select(Driver.getDriver().findElement(By.xpath("//select[@data-handler='selectMonth']")));
        selectMonth.selectByValue("8");
        Select selectYear = new Select(Driver.getDriver().findElement(By.xpath("//select[@data-handler='selectYear']")));
        selectYear.selectByValue("2021");
        //         Select selectDay = new Select(Driver.getDriver().findElement(By.xpath("//a[.='8']")));
        WebElement selectDay = Driver.getDriver().findElement(By.xpath("//a[.='8']"));
        selectDay.click();
        WebElement check = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Choose a date']"));
        System.out.println("check.getAttribute(\"value\") = " + check.getAttribute("value"));
        WebElement driverName = Driver.getDriver().findElement(By.xpath("//input[@data-name='field__driver']"));
        driverName.sendKeys("Anastasia");
        WebElement selectmilesOrKM = Driver.getDriver().findElement(By.xpath("(//span[@class='select2-arrow'])[1]"));
        selectmilesOrKM.click();
        WebElement km = Driver.getDriver().findElement(By.xpath("//div[.='km']"));
        km.click();
        WebElement addButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-medium add-btn']"));
        addButton.click();
        WebElement selectLisencePlate = Driver.getDriver().findElement(By.xpath("(//tbody[@class='grid-body']//td)[2]"));
        selectLisencePlate.click();
        WebElement clickSelect = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary']"));
        clickSelect.click();
        WebElement clickAndSave = Driver.getDriver().findElement(By.xpath("(//button[contains(text(),'Save and Close')])[1]"));
        clickAndSave.click();

        WebElement entitySavedMassage = Driver.getDriver().findElement(By.xpath("//div[.='Entity saved']"));
        String expected = "Entity saved";
        String actual = entitySavedMassage.getText();
        Assert.assertEquals(actual, expected);


        Driver.getDriver().quit();
    }

}
