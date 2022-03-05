package com.stellarburgers.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import com.stellarburgers.pageobjects.LoginPage;
import com.stellarburgers.pageobjects.MainPage;
import com.stellarburgers.pageobjects.PersonalAccountPage;
import com.stellarburgers.pageobjects.RegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationTest {
    MainPage mainPage;
    LoginPage loginPage = page(LoginPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);

    private final String browser;

    public RegistrationTest(String browser) {
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
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    @DisplayName("Successful user registration")
    @Description("Check that a new user can be created using all valid required fields")
    public void testUserIsRegisteredSuccessfullyUsingValidData() {
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegisterLink();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.clickRegisterButton();
        loginPage.isLoginLabelDisplayed();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        assertTrue("'Place order' button is not displayed on Main page", mainPage.isPlaceOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Incorrect password validation")
    @Description("Check that a new user can not be created using password less than 6 characters")
    public void testUserIsNotRegisteredUsingShortPassword() {
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegisterLink();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password().substring(1,5);
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.clickRegisterButton();
        assertTrue("'Incorrect password' label is not displayed on Registration page", registrationPage.isIncorrectPasswordLabelDisplayed());
    }
}