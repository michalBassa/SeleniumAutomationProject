package Tests;

import Pages.AboutPage;
import Pages.AccountPage;
import Pages.AddressPage;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TestTutorials {
    static  WebDriver driver=new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @BeforeAll
    @Test
    public  static void beforeTest(){

        driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
        driver.manage().window().fullscreen();
    }
    @Test
    public  void  TestE2E ()throws InterruptedException{
        AboutPage aboutPage = new AboutPage(driver);
        //  Assertions.assertTrue(aboutPage.isOnPage(),"עמוד אודות עלה בהצלחה");
        wait.until(ExpectedConditions.visibilityOf(aboutPage.getFirstName())).sendKeys("michal");
        wait.until(ExpectedConditions.visibilityOf(aboutPage.getLastName())).sendKeys("levi");
        wait.until(ExpectedConditions.visibilityOf(aboutPage.getEmail())).sendKeys("m0507777@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(aboutPage.getNextBtn())).click();
        AccountPage accountPage =new AccountPage(driver);
        // Assertions.assertTrue(accountPage.isOnPage(),"עמוד חשבון עלה בהצלחה");
        //there is a problem in checkbox !!!!!!
        //wait.until(ExpectedConditions.visibilityOf(accountPage.getInputBeginner())).click();
        //wait.until(ExpectedConditions.visibilityOf(accountPage.getInputIntermediate())).click();
        //wait.until(ExpectedConditions.visibilityOf(accountPage.getInputAdvanced())).click();
        wait.until(ExpectedConditions.visibilityOf(accountPage.getNextBtn())).click();

        AddressPage addressPage=new AddressPage(driver);
        // Assertions.assertTrue(addressPage.isOnPage(),"עמוד כתובת עלה בהצלחה");
        wait.until(ExpectedConditions.visibilityOf(addressPage.getInputStreetName())).sendKeys("Rabi-Akiva");
        wait.until(ExpectedConditions.visibilityOf(addressPage.getInputStreetNumber())).sendKeys("100");
        wait.until(ExpectedConditions.visibilityOf(addressPage.getInputCity())).sendKeys("B-B");
        Select countrySelect= new Select(addressPage.getSelectCountry());
        countrySelect.selectByIndex(2);
        wait.until(ExpectedConditions.visibilityOf(addressPage.getFinishBtn())).click();
        String str=driver.getTitle();
        if(str.equalsIgnoreCase("קורס אוטומציה - טופס תרגול למתחילים"))
            Assert.isTrue(true, "correct page");
        else
            Assert.isTrue(false, "incorrect page");
    }


    @Test
    public void verifyFirstName() throws InterruptedException {

        AboutPage aboutPage =new AboutPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf( aboutPage.getFirstName())).sendKeys("");

        wait.until(ExpectedConditions.visibilityOf( aboutPage.getLastName())).sendKeys("levi");

        wait.until(ExpectedConditions.visibilityOf( aboutPage.getEmail())).sendKeys("m4894949@gmail.com");

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf( aboutPage.getNextBtn())).click();
        String error =wait.until(ExpectedConditions.visibilityOf( aboutPage.getFirstName())).getText();

        Assertions.assertTrue(error.equalsIgnoreCase("Please enter a valid first name address."),"error message isn't appears");

    }
    @Test
    public void verifyLastName() throws InterruptedException {

        //driver.navigate().to("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
        AboutPage aboutPage =new AboutPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf( aboutPage.getFirstName())).sendKeys("yael");

        wait.until(ExpectedConditions.visibilityOf( aboutPage.getLastName())).sendKeys("");

        wait.until(ExpectedConditions.visibilityOf( aboutPage.getEmail())).sendKeys("m4894949@gmail.com");

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf( aboutPage.getNextBtn())).click();
        String error =wait.until(ExpectedConditions.visibilityOf( aboutPage.getLastName())).getText();

        Assertions.assertTrue(error.equalsIgnoreCase("Please enter a valid email address."),"error message isn't appears");

    }
    @Test
    public void verifyEmail() throws InterruptedException {

        AboutPage aboutPage =new AboutPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf( aboutPage.getFirstName())).sendKeys("michal");

        wait.until(ExpectedConditions.visibilityOf( aboutPage.getLastName())).sendKeys("bassa");

        wait.until(ExpectedConditions.visibilityOf( aboutPage.getEmail())).sendKeys("m4894949");

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf( aboutPage.getNextBtn())).click();
        String error =wait.until(ExpectedConditions.visibilityOf( aboutPage.getErrorEmail())).getText();

        Assertions.assertTrue(error.equalsIgnoreCase("Please enter a valid email address."),"error message isn't appears");

    }

    @Test
    public  void  TestBackToStart()throws InterruptedException{

        AboutPage aboutPage = new AboutPage(driver);
        //  Assertions.assertTrue(aboutPage.isOnPage(),"עמוד אודות עלה בהצלחה");
        wait.until(ExpectedConditions.visibilityOf(aboutPage.getFirstName())).sendKeys("michal");
        wait.until(ExpectedConditions.visibilityOf(aboutPage.getLastName())).sendKeys("levi");
        wait.until(ExpectedConditions.visibilityOf(aboutPage.getEmail())).sendKeys("m0507777@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(aboutPage.getNextBtn())).click();
        AccountPage accountPage =new AccountPage(driver);
        // Assertions.assertTrue(accountPage.isOnPage(),"עמוד חשבון עלה בהצלחה");
        //there is a problem in checkbox !!!!!!
        //wait.until(ExpectedConditions.visibilityOf(accountPage.getInputBeginner())).click();
        //wait.until(ExpectedConditions.visibilityOf(accountPage.getInputIntermediate())).click();
        //wait.until(ExpectedConditions.visibilityOf(accountPage.getInputAdvanced())).click();
        wait.until(ExpectedConditions.visibilityOf(accountPage.getNextBtn())).click();
        AddressPage addressPage=new AddressPage(driver);
        // Assertions.assertTrue(addressPage.isOnPage(),"עמוד כתובת עלה בהצלחה");
        wait.until(ExpectedConditions.visibilityOf(addressPage.getInputStreetName())).sendKeys("Rabi-Akiva");
        wait.until(ExpectedConditions.visibilityOf(addressPage.getInputStreetNumber())).sendKeys("100");
        wait.until(ExpectedConditions.visibilityOf(addressPage.getInputCity())).sendKeys("B-B");
        Select countrySelect= new Select(addressPage.getSelectCountry());
        countrySelect.selectByIndex(2);
        wait.until(ExpectedConditions.visibilityOf(addressPage.getFinishBtn())).click();
        String str=driver.getTitle();
        if(str.equalsIgnoreCase("קורס אוטומציה - טופס תרגול למתחילים"))
            Assert.isTrue(true, "correct page");
        else
            Assert.isTrue(false, "incorrect page");
        wait.until(ExpectedConditions.visibilityOf(addressPage.getStartAgainBtn())).click();
        //  Assertions.assertTrue(aboutPage.isOnPage(),"עמוד אודות עלה בהצלחה");
      if(wait.until(ExpectedConditions.visibilityOf(aboutPage.getFirstName())).getText().equalsIgnoreCase("")&&
        wait.until(ExpectedConditions.visibilityOf(aboutPage.getLastName())).getText().equalsIgnoreCase("")&&
        wait.until(ExpectedConditions.visibilityOf(aboutPage.getEmail())).getText().equalsIgnoreCase(""))
          Assert.isTrue(true, "the inputs are empty");
      else
          Assert.isTrue(false, "the inputs are not empty");


    }
  @AfterAll
    @Test
    static void afterTest(){
        driver.close();
    }
}
