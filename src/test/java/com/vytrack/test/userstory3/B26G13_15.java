package com.vytrack.test.userstory3;


import com.vytrack.test.utilities.Driver;
import com.vytrack.test.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class B26G13_15 {

    @Test
    public void test001() throws InterruptedException {
        VyTrack_Utilities.vyTrackLogin();

        WebElement fleetHeader = Driver.getDriver().findElement(By.xpath("//h1[@class='logo logo-text']"));
        Thread.sleep(1000);
        String actualHeader = fleetHeader.getText();
        String expectedHeader = "FLEET MANAGEMENT";

        System.out.println(actualHeader);
        Assert.assertEquals(actualHeader, expectedHeader, "Failed!");

        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//a[@href='#']//span)[1]"));
        fleetBtn.click();

        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[2]"));
        vehicleOdometer.click();

        Thread.sleep(1000);
        WebElement filter = Driver.getDriver().findElement(By.xpath("//i[@class='fa-filter hide-text']"));
        filter.click();

        WebElement manageFilter = Driver.getDriver().findElement(By.xpath("//a[@class='add-filter-button']"));
        manageFilter.click();

        WebElement driverCheckBox = Driver.getDriver().findElement(By.xpath("//input[@id='ui-multiselect-0-0-option-2']"));
        driverCheckBox.click();

        WebElement driverAllBtn = Driver.getDriver().findElement(By.xpath("//div[@class='btn filter-criteria-selector" +
                " oro-drop-opener oro-dropdown-toggle filter-default-value']"));
        driverAllBtn.click();

        WebElement searchDriver = Driver.getDriver().findElement(By.xpath("//input[@name='value']"));
        searchDriver.sendKeys("Vugar" + Keys.ENTER);

        Thread.sleep(1000);

        WebElement odometerRow = Driver.getDriver().findElement(By.xpath("(//td[@data-column-label='Odometer Value'])[1]"));
        odometerRow.click();

        WebElement userName = Driver.getDriver().findElement(By.xpath("//h1[@class='user-name']"));

        String actualUserName = userName.getText();
        String expectedUserName = "Vugar";

        Assert.assertEquals(actualUserName, expectedUserName, "Username not match!");

        WebElement deleteBtn = Driver.getDriver().findElement(By.xpath("//a[@title='Delete Vehicle Odometer']"));
        deleteBtn.click();

        WebElement yesDeleteBtn = Driver.getDriver().findElement(By.xpath("//a[@class='btn ok btn-danger']"));
        yesDeleteBtn.click();

        WebElement deleteMessage = Driver.getDriver().findElement(By.xpath("//div[@class='message']"));
        deleteMessage.isDisplayed();
        Assert.assertEquals(deleteMessage.getText(), "Vehicle Odometer deleted", "Not match!!!");

        Driver.closeDriver();

    }
}
