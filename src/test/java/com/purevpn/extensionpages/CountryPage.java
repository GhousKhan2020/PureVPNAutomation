package com.purevpn.extensionpages;

import com.purevpn.configs.Configuration;
import org.apache.log4j.Logger;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CountryPage {
    WebDriver driver;
    final static Logger log = Logger.getLogger(CountryPage.class);


    public CountryPage(WebDriver driver){
        this.driver = driver;
    }

    //@FindBy(css="a[href*='countries']")
    @FindBy(css= Configuration.selectCountryButton)
    WebElement selectCountryButton;

    // @FindBy(xpath="/html/body/section/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/ul/li[2]/span/span")
    @FindBy(xpath=Configuration.netherlandsButton)
    WebElement netherlandsButton;

   // @FindBy(id="countryFlagDefault")
   @FindBy(id=Configuration.dutchFlag)
    WebElement dutchFlag;

    public String getDutchFlag(){

       return dutchFlag.findElement(By.tagName("img")).getAttribute("src").toString();
    }
    public void clickSelectCountry(){
        log.debug("select country button is displayed: "+selectCountryButton.isDisplayed()+" and is enabled"+selectCountryButton.isEnabled());
        selectCountryButton.click();
        Timeout.millis(100);
    }
    public  void selectNetherland(){
        log.debug("netherlands is enabled: "+netherlandsButton.isEnabled()+" and is displayed"+ netherlandsButton.isDisplayed());
        netherlandsButton.click();
    }

}

