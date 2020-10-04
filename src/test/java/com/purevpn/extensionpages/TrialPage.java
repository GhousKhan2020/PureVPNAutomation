package com.purevpn.extensionpages;

import com.purevpn.configs.Configuration;
import org.apache.log4j.Logger;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrialPage {
    WebDriver driver;
    final static Logger log = Logger.getLogger(HomePage.class);
    //@FindBy(id = "email")
    @FindBy(id = Configuration.emailElement)
    public WebElement emailElement;
  //$('#agree_terms_policy')
    //document.querySelector("#agree_terms_policy")
   // @FindBy(xpath="//*[@id='agree_terms_policy']")
   // @FindBy(xpath = "/html/body/section/div[2]/div/div[3]/label")
  @FindBy(xpath = Configuration.checBox)
    public WebElement checBox;

    //@FindBy(id="signupError")
    @FindBy(id=Configuration.errorMsg)
    public  WebElement errorMsg;

    //@FindBy(id="btnSignup")
    @FindBy(id=Configuration.signUpButton)
    public WebElement signUpButton;


    public TrialPage(WebDriver driver){
        this.driver = driver;
    }

    public String getErrorText(){

        log.debug("error msg: "+errorMsg.getText());
       
        return errorMsg.getText().toString();

    }

    /*
    *   public TrialPage clickOnSignUpButton(){

        signupButton.click();

        log.debug("signupButton is displayed = "+signupButton.isDisplayed());
        log.debug("signupButton is displayed = "+signupButton.isEnabled());

        return PageFactory.initElements(driver, TrialPage.class);
    }*/
    public CountryPage clickSignUpButton(){
        log.debug("signupbutton is displayed : "+signUpButton.isDisplayed()+" and is enabled:  "+signUpButton.isEnabled());
        signUpButton.click();
        Timeout.millis(100);
        return PageFactory.initElements(driver, CountryPage.class);
    }


    public void checkTermsAndConditions(){
       log.debug("Terms and Condition check box is displayed: "+checBox.isDisplayed());

       checBox.click();
    }
//    public void getFreeTrial(){
//        enterEmailAddress();
//
//        checkTermsAndConditions();
//        clickSignUpButton();
//
//
//    }

    public void enterEmailAddress(){
        log.debug("email button is : "+emailElement.isDisplayed());
        emailElement.sendKeys(Configuration.emailAddress);
        Timeout.millis(100);

    }
}
