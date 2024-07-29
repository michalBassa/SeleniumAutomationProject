package Pages;


import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class AboutPage {
    WebDriver driver;
    //the class same to all pages why?
    @FindBy(xpath = "//*[contains(@class,'moving-tab')]")
    private WebElement title;

    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(id="firstname-error")
    private WebElement errorFirstName;
    @FindBy(name = "lastname")
    private WebElement lastName;
@FindBy(id="lastname-error")
    private WebElement errorLastName;
    @FindBy(name = "email")
    private WebElement email;
    @FindBy(id="email-error")
    private WebElement errorEmail;
    @FindBy(id = "next")
    private WebElement nextBtn;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
         //   wait.(ExpectedConditions.visibilityOf(getTitle()));
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}