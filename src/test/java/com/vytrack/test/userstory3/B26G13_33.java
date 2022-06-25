package com.vytrack.test.userstory3;

import com.vytrack.test.utilities.Driver;
import com.vytrack.test.utilities.VyTrack_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.TreeMap;

public class B26G13_33 {

    @Test
    public void reset_grid_test(){

        // Login as a truck driver
        VyTrack_Utilities.vyTrackLogin();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);

        // Verify user is on the Home Page. Quick Launchpad header is displayed
        String quickLaunchpadHeader = Driver.getDriver().findElement(By.cssSelector(".oro-subtitle")).getText();
        String expectedHeader = "Quick Launchpad";
        Assert.assertEquals(quickLaunchpadHeader, expectedHeader);

        // Hover over Fleet module. "Vehicle Odometer" feature should be displayed
        WebElement fleetModule = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Fleet')]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetModule).perform();

        // Verify "Vehicles Odometers" submodule is displayed

        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']"));
        wait.until(ExpectedConditions.visibilityOf(vehicleOdometer));
        Assert.assertTrue(vehicleOdometer.isDisplayed());

        // Click on "Vehicle Odometer" feature
        vehicleOdometer.click();

        // Click on "Grid Setting" button
        WebElement gridSetting = Driver.getDriver().findElement(By.xpath("//a[@title='Grid Settings']"));
        gridSetting.click();

        // Verify 'Grid Settings' menu is displayed
        WebElement gridSettingsMenu = Driver.getDriver().findElement(By.xpath("//div[.='Grid Settings']"));
        Assert.assertTrue(gridSettingsMenu.isDisplayed());

        // Verify user can see by default enabled menu columns: Odometer value, Date, Driver, Unit and Model (all except 'Id')
        List<WebElement> menuSelection = Driver.getDriver().findElements(By.xpath("//tbody[@class='ui-sortable']//tr"));

        WebElement id = Driver.getDriver().findElement(By.xpath("//label[.='Id']"));

        for (WebElement each : menuSelection) {
            if (!each.equals(id)){
                Assert.assertTrue(each.isEnabled());
            }
        }

        // Deselect all columns except 'Date'
        WebElement date = Driver.getDriver().findElement(By.xpath("//label[.='Date']"));
        for (WebElement each : menuSelection) {
            if (!each.equals(id) || !each.equals(date)){
                each.click();
            }
        }

        // Verify all columns except 'Date' are not Selected
        for (WebElement each : menuSelection) {
            if (!each.equals(date)){
                Assert.assertFalse(each.isSelected());
            }
        }

        // Close 'Grid Setting' menu by clicking 'X' button
        WebElement close = Driver.getDriver().findElement(By.xpath("//span[.='×']"));
        close.click();

        // Click 'Reset' button
        WebElement resetBtn = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'Reset')]"));

        // Verify all columns are selected except 'Id' as by default settings

        for (WebElement each : menuSelection) {
            if (!each.equals(id)){
                Assert.assertFalse(each.isSelected());
            }
        }
        Driver.closeDriver();
    }
}
