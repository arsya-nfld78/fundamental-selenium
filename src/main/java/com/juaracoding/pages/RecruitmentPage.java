package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

    private WebDriver driver;

    public RecruitmentPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement menuRecruitment;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")
    private WebElement email;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement resume;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div[2]/div/div/h6")
    private WebElement txtCandidateProfile;

    @FindBy(xpath = "//div[contains(text(),'')]")
    private WebElement txtFullNameFromList;

    public void setMenuRecruitment(){
        menuRecruitment.click();
    }

    public void setAdd(){
        btnAdd.click();
    }

    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email){
        this.email.sendKeys(email);
    }

    public void setResume(String resume){
        this.resume.sendKeys(resume);
    }

    public void setSave(){
        btnSubmit.click();
    }

    public String getTxtCandidateProfile(){
        return txtCandidateProfile.getText();
    }

    public String gettxtFullNameFromList(){
        return txtFullNameFromList.getText();
    }
}
