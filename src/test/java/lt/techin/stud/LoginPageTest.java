package lt.techin.stud;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginPageTest extends BasePageTest {

    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.titleIs("Expected Title After Login"));

    @Test
    @DisplayName("Login test with Valid Credentials")
    @Tag("valid-Test")
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("ValidUser");
        loginPage.enterPassword("ValidUser123*");
        loginPage.clickLoginButton();

        assertEquals("http://localhost:8080/prisijungti", loginPage.getPageTitle());
    }

    @Test
    @DisplayName("Login Test with random Invalid Name")
    @Tag("invalid_Test")
    public void invalidLoginName() {
        LoginPage loginPage = new LoginPage(driver);
        String username = RandomUtils.generateRandomUsername();
        String password = RandomUtils.generateRandomPassword();

        loginPage.enterUsername("a");
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        assertTrue(loginPage.isUsernameErrorMessage(), "Username error message should be present for invalid username.");

    }

    @Test
    @DisplayName("Login Test with random Invalid Password")
    @Tag("invalid_Test")
    public void invalidLoginPassword() {
        LoginPage loginPage = new LoginPage(driver);
        String username = RandomUtils.generateRandomUsername();
        String password = RandomUtils.generateRandomPassword();

        loginPage.enterUsername(username);
        loginPage.enterPassword("a");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isPasswordErrorMessage(), "Password error message should be present for invalid username.");

    }

}
