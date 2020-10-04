package com.purevpn.extensionpages;

import com.purevpn.configs.Configuration;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.sql.DriverManager;
import java.util.List;

import org.apache.log4j.Logger;

public class HomePage {
    final static Logger log = Logger.getLogger(HomePage.class);
    WebDriver driver;
//    String log4jConfigFile = System.getProperty("user.dir")
//            + File.separator + "log4j.properties";
//        PropertyConfigurator.configure(log4jConfigFile);

    //private WebDriver driver;

    //Page URL
   // private static String PAGE_URL="chrome-extension://bfidboloedlamgdmenmlbipfnccokknp/ui/popup/template.html";

    //Locators
    ///All the business logic goes herere in this class
    //Applyu for trial period
    //we can also use How functionality of POM
   // @FindBy(how = How.CSS, using = "a[href*='signup']")
//    @FindBy(css = "a[href*='signup']")
    @FindBy(css = Configuration.signupButton)
    private WebElement signupButton;

//    @FindBy(how = How.CLASS_NAME, using="wrap-buttons")
//    private List<WebElement> wrapButtons;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        BasicConfigurator.configure();
    }

    //we can use this to assert the total number of buttons present in oure PUREVPN UI
//    public int getWrapButtonsCount(){
//      return  wrapButtons.size();
//    }

    public TrialPage clickOnSignUpButton(){

        signupButton.click();

        log.debug("signupButton is displayed = "+signupButton.isDisplayed());
        log.debug("signupButton is displayed = "+signupButton.isEnabled());

        return PageFactory.initElements(driver, TrialPage.class);
    }
}