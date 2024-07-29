package Pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class AccountPage {
    WebDriver driver;
    @FindBy(xpath = "//*[contains(@class,'moving-tab')]")
    private WebElement title;

    @FindBy(name="Beginner")
    private  WebElement inputBeginner;
    @FindBy(name="Intermediate")
    private  WebElement inputIntermediate;
    @FindBy(name="Advanced")
    private  WebElement inputAdvanced;
    @FindBy(id = "next")
    private WebElement nextBtn;
    @FindBy(id = "previous")
    private WebElement previousBtn;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
        //    wait.(ExpectedConditions.visibilityOf(getTitle()));
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
