package com.vytrack.test.base;

import com.vytrack.test.utilities.ConfigurationReader;
import com.vytrack.test.utilities.Driver;
import com.vytrack.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        Driver.getDriver().get(ConfigurationReader.getProperty("username"));
        Driver.getDriver().get(ConfigurationReader.getProperty("password"));

    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }
}

