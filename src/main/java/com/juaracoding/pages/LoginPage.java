package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//p[contains(@class,'userdropdown')]")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement btnLogout;

    @FindBy(xpath = "//h6[contains(@class,'topbar-header-breadcrumb')]")
    private WebElement txtDashboard;

    @FindBy(xpath = "//p[contains(@class,'alert-content-text')]")
    private WebElement txtInvalidCredentials;

    @FindBy(xpath = "//span[contains(@class,'input-field-error-message oxd-input-group__message')]")
    private WebElement txtUsernameRequired;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    public void clearUsername(){

    }

    public void logout(){
        userDropdown.click();
        btnLogout.click();
    }

    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    public String getTxtInvalidCredentials(){
        return txtInvalidCredentials.getText();
    }

    public String getTxtUsernameRequired(){
        return txtUsernameRequired.getText();
    }
}
