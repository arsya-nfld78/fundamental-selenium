package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 3)
    public void testValidLogin(){
        loginPage.login("Admin","admin123");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
    }

    @Test(priority = 2)
    public void testInvalidLogin(){
        loginPage.login("Adm","adm123");
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(),"Invalid credentials");
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1)
    public void testUsernameNull(){
        loginPage.login("","admin123");
        Assert.assertEquals(loginPage.getTxtUsernameRequired(),"Required");
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
