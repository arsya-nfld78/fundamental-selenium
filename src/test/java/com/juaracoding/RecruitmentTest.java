package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RecruitmentTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private RecruitmentPage recruitmentPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage();
        recruitmentPage = new RecruitmentPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testAddCandidate(){
       loginPage.login("Admin","admin123");
       DriverSingleton.delay(5);
       recruitmentPage.setMenuRecruitment();
       recruitmentPage.setAdd();
       recruitmentPage.setFirstName("Neko");
       recruitmentPage.setLastName("Arc");
       recruitmentPage.setEmail("Neko12@email.com");
       recruitmentPage.setResume("");
       recruitmentPage.setSave();
       Assert.assertEquals(recruitmentPage.getTxtCandidateProfile(),"Candidate Profile");
    }
}
