package com.vytrack.test.page;

import com.vytrack.test.utilities.Driver;
import com.vytrack.test.utilities.VyTrack_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.TreeMap;

public class VyTrackHomePage {

    public VyTrackHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void navigate_to_submodule(String module, String subModule) throws InterruptedException {
        Thread.sleep(3000);
        String moduleLocator = "//span[contains(text(),'"+module+"') and @class='title title-level-1']";
        String subModuleLocator = "//span[.='"+subModule+"']";
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath(moduleLocator)).click();
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath(subModuleLocator)).click();
        Thread.sleep(3000);





    }

    //span[contains(text(),'System') and @class='title title-level-1']


    //span[.='Vehicle Odometer']


}
