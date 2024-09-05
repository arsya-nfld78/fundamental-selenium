package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class MainApp {
    public static void main(String[] args) {

        WebDriver driver;

        System.out.println("Page Object, Page Factory");
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        LoginPage loginPage = new LoginPage();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.login("Admin","admin123");
        System.out.println("Login");
        DriverSingleton.delay(4);
        loginPage.logout();
        System.out.println("Logout");
        DriverSingleton.delay(4);
        //negatif
        //loginPage.login("adm","pass12");

        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }
}