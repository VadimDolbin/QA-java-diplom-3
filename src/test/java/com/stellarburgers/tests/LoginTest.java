package com.stellarburgers.tests;

import com.UserOperations;
import com.codeborne.selenide.WebDriverRunner;
import com.stellarburgers.pageobjects.ForgotPasswordPage;
import com.stellarburgers.pageobjects.LoginPage;
import com.stellarburgers.pageobjects.MainPage;
import com.stellarburgers.pageobjects.RegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LoginTest {
    Map<String, String> responseData;
    MainPage mainPage;
    LoginPage loginPage = page(LoginPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);

    private final String browser;

    public LoginTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Object[][] selectBrowser() {
        return new Object[][]{
                {"src\\main\\resources\\chromedriver.exe"},
                {"src\\main\\resources\\yandexdriver.exe"}
        };
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", browser);
        mainPage = open(MainPage.URL, MainPage.class);
        responseData = new UserOperations().register();
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
        new UserOperations().delete();
    }

    @Test
    @DisplayName("Login using 'Login Into Account' button")
    @Description("Check that a new user can be logged in using 'Login Into Account' button on main page")
    public void testUserIsLoggedInUsingLoginIntoAccountButton() {
        mainPage.clickLoginIntoAccountButton();
        loginPage.setEmail(responseData.get("email"));
        loginPage.setPassword(responseData.get("password"));
        loginPage.clickLoginButton();
        assertTrue("'Place order' button is not displayed on Main page", mainPage.isPlaceOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Login using 'Personal Account' button")
    @Description("Check that a new user can be logged in using 'Personal Account' button on main page")
    public void testUserIsLoggedInUsingPersonalAccountButton() {
        mainPage.clickPersonalAccountButton();
        loginPage.setEmail(responseData.get("email"));
        loginPage.setPassword(responseData.get("password"));
        loginPage.clickLoginButton();
        assertTrue("'Place order' button is not displayed on Main page", mainPage.isPlaceOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Login using 'Login' link on registration page")
    @Description("Check that a new user can be logged in using 'Login' link on registration page")
    public void testUserIsLoggedInUsingLoginLinkOnRegistrationPage() {
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegisterLink();
        registrationPage.clickLoginLink();
        loginPage.setEmail(responseData.get("email"));
        loginPage.setPassword(responseData.get("password"));
        loginPage.clickLoginButton();
        assertTrue("'Place order' button is not displayed on Main page", mainPage.isPlaceOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Login using 'Login' link on forgot password page")
    @Description("Check that a new user can be logged in using 'Login' link on forgot password page")
    public void testUserIsLoggedInUsingLoginLinkOnForgotPasswordPage() {
        mainPage.clickPersonalAccountButton();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.clickLoginLink();
        loginPage.setEmail(responseData.get("email"));
        loginPage.setPassword(responseData.get("password"));
        loginPage.clickLoginButton();
        assertTrue("'Place order' button is not displayed on Main page", mainPage.isPlaceOrderButtonDisplayed());
    }
}