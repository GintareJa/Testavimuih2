package lt.techin.stud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //locators

    @FindBy(css = "input[name='username']")
    private WebElement usernameField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordField;

    @FindBy(css = ".btn.btn-block.btn-lg.btn-primary")
    private WebElement loginButton;

    @FindBy(css = ".form-group span:nth-child(4)")
    private WebElement usernameErrorMessage;

    @FindBy(css = ".form-group span:nth-child(4)")
    private WebElement passwordErrorMessage;

    //    methods

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    //    Assertions Methods
    public boolean isUsernameErrorMessage() {
        return usernameErrorMessage.isDisplayed();
    }

    public boolean isPasswordErrorMessage() {
        return passwordErrorMessage.isDisplayed();
    }


    public String getPageTitle() {
        return driver.getTitle();
    }
}
