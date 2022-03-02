package com.stellarburgers.tests;

import com.UserOperations;
import com.codeborne.selenide.WebDriverRunner;
import com.stellarburgers.pageobjects.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TransitionToPersonalAccountPageTest {
    Map<String, String> responseData;
    MainPage mainPage;
    LoginPage loginPage = page(LoginPage.class);
    PersonalAccountPage personalAccountPage= page(PersonalAccountPage.class);

    private final String browser;

    public TransitionToPersonalAccountPageTest(String browser) {
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
    @DisplayName("Transition to 'Personal Account' page")
    @Description("Check that a new user can successfully proceed to 'Personal Account' page using corresponding button on main page")
    public void testUserIsSuccessfullyProceededToPersonalAccount() {
        mainPage.clickLoginIntoAccountButton();
        loginPage.setEmail(responseData.get("email"));
        loginPage.setPassword(responseData.get("password"));
        loginPage.clickLoginButton();
        mainPage.clickPersonalAccountButton();
        assertTrue(personalAccountPage.isUserProfileLinkDisplayed());
    }
}