package com.vytrack.test.userstory3;

import com.vytrack.test.page.VyTrackHomePage;
import com.vytrack.test.utilities.VyTrack_Utilities;
import org.testng.annotations.Test;

public class Mikail {

    VyTrackHomePage vyTrackHomePage = new VyTrackHomePage();

    @Test
    public void submodule_test() throws InterruptedException {
        VyTrack_Utilities.vyTrackLogin();
        Thread.sleep(5000);
        vyTrackHomePage.navigate_to_submodule("Fleet", "Vehicles Fuel Logs");

    }

}
