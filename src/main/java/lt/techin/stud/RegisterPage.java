package lt.techin.stud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    //locators

    @FindBy(xpath = "/html//div[@class='container']/form[@action='/prisijungti']//a[@href='/registruoti']")
    private WebElement navigateToTheRegisterPage;
    @FindBy(css = "input#username")
    private WebElement usernameField;

    @FindBy(css = "input#password")
    private WebElement passwordField;

    @FindBy(css = "input#passwordConfirm")
    private WebElement passwordConfirmation;

    @FindBy(css = "form#userForm > .btn.btn-block.btn-lg.btn-primary")
    private WebElement registerButton;

    @FindBy(css = "#username\\.errors")
    private WebElement usernameErrorMessage;

    @FindBy(css = "#password\\.errors")
    private WebElement passwordErrorMessage;

    @FindBy(css = "#passwordConfirm\\.errors")
    private WebElement confirmPasswordErrorMessage;


    //    methods
    public void navigateRegistration() {
        navigateToTheRegisterPage.click();
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void confirmPassword(String password) {
        passwordConfirmation.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }


//        assertions Methods
    public boolean isUserNameErrorMessagePresent() {
        return usernameErrorMessage.isDisplayed();
    }
    public boolean isPasswordErrorMessagePresent() {
        return passwordErrorMessage.isDisplayed();
    }
    public boolean isConfirmPasswordErrorMessagePresent() {
        return confirmPasswordErrorMessage.isDisplayed();
    }
    public String getPageTitle() {
        return driver.getTitle();
    }
}
