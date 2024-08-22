package lt.techin.stud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    //    locators
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "form#number > input[name='sk1']")
    private WebElement firstNumber;

    @FindBy(css = "form#number > input[name='sk2']")
    private WebElement secondNumber;

    @FindBy(css = "form#number > select[name='zenklas']")
    private WebElement operation;

    @FindBy(css = "form#number > input[value='skaičiuoti']")
    private WebElement clickCountButton;


    //    methods
    public void enterFirstNumber(int number) {
        firstNumber.sendKeys();
    }

    public void enterSecondNumber(int number) {
        secondNumber.sendKeys();
    }
    public void selectOperation() {
        operation.click();
    }

}

