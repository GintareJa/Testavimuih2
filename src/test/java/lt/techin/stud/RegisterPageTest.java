package lt.techin.stud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/*import utils.RandomStringUtils;*/

public class RegisterPageTest extends BasePageTest {

    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.titleIs("Expected Title After Registration"));
    private RegisterPage registerPage;

    @BeforeEach
    public void setUpTest() {
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("Test Registration with Random Data")
    @Tag("valid_Test")
    public void testRegistrationWithRandomData() {
        RegisterPage registerPage = new RegisterPage(driver);
        String username = RandomUtils.generateRandomUsername();
        String password = RandomUtils.generateRandomPassword();

        registerPage.navigateRegistration();
        registerPage.enterUsername(username);
        registerPage.enterPassword(password);
        registerPage.confirmPassword(password);
        registerPage.clickRegisterButton();


        assertEquals("Expected Title After Registration", registerPage.getPageTitle());
    }


        @Test
        @Tag("invalid_Test")
        @DisplayName("Register with Invalid Name")
        public void registerWithInvalidName() {
            RegisterPage registerPage = new RegisterPage(driver);
            String username = RandomUtils.generateRandomUsername();
            String password = RandomUtils.generateRandomPassword();

            registerPage.navigateRegistration();
            registerPage.enterUsername("a");
            registerPage.enterPassword(password);
            registerPage.confirmPassword(password);
            registerPage.clickRegisterButton();

            assertTrue(registerPage.isUserNameErrorMessagePresent(), "Username error message should be present for invalid username.");

        }
        @Test
        @Tag("invalid_Test")
        @DisplayName("Register with Invalid Password")
        public void registerWithInvalidPassword() {
            RegisterPage registerPage = new RegisterPage(driver);
            String username = RandomUtils.generateRandomUsername();
            String password = RandomUtils.generateRandomPassword();

            registerPage.navigateRegistration();
            registerPage.enterUsername(username);
            registerPage.enterPassword("a");
            registerPage.confirmPassword(password);
            registerPage.clickRegisterButton();


            assertTrue(registerPage.isPasswordErrorMessagePresent(), "Email error message should be present for invalid email.");
//
        }

        @Test
        @Tag("invalid_Test")
        @DisplayName("Register with Invalid Confirm Password")
        public void registerWithInvalidConfirmPassword() {
         RegisterPage registerPage = new RegisterPage(driver);
            String username = RandomUtils.generateRandomUsername();
            String password = RandomUtils.generateRandomPassword();

            registerPage.navigateRegistration();
            registerPage.enterUsername(username);
            registerPage.enterPassword(password);
            registerPage.confirmPassword("a");
            registerPage.clickRegisterButton();


            assertTrue(registerPage.isConfirmPasswordErrorMessagePresent(), "Password error message should be present for invalid password.");
        }
        @Test
        @Tag("invalid_Test")
        @DisplayName("Register with an empty Name Credentials")
        public void registerWithEmptyName() {
            RegisterPage registerPage = new RegisterPage(driver);
            String username = RandomUtils.generateRandomUsername();
            String password = RandomUtils.generateRandomPassword();

            registerPage.navigateRegistration();
            registerPage.enterUsername("");
            registerPage.enterPassword(password);
            registerPage.confirmPassword(password);
            registerPage.clickRegisterButton();

            assertTrue(registerPage.isUserNameErrorMessagePresent(), "Confirm name error message should be present for mismatched confirm password.");
        }
    @Test
    @Tag("invalid_Test")
    @DisplayName("Register with an empty Password Credentials")
    public void registerWithEmptyPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        String username = RandomUtils.generateRandomUsername();
        String password = RandomUtils.generateRandomPassword();

        registerPage.navigateRegistration();
        registerPage.enterUsername(username);
        registerPage.enterPassword("");
        registerPage.confirmPassword(password);
        registerPage.clickRegisterButton();

            assertTrue(registerPage.isPasswordErrorMessagePresent(), "Confirm password error message should be present for mismatched confirm password.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Register with an empty Confirm Password Credentials")
    public void registerWithEmptyConfirmPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        String username = RandomUtils.generateRandomUsername();
        String password = RandomUtils.generateRandomPassword();

        registerPage.navigateRegistration();
        registerPage.enterUsername(username);
        registerPage.enterPassword(password);
        registerPage.confirmPassword("");
        registerPage.clickRegisterButton();

            assertTrue(registerPage.isConfirmPasswordErrorMessagePresent(), "Confirm password error message should be present for mismatched confirm password.");
    }
}