package com.stellarburgers.tests;

import com.UserOperations;
import com.codeborne.selenide.WebDriverRunner;
import com.stellarburgers.pageobjects.LoginPage;
import com.stellarburgers.pageobjects.MainPage;
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
public class ConstructorTest {
    Map<String, String> responseData;
    MainPage mainPage;
    LoginPage loginPage = page(LoginPage.class);

    private final String browser;

    public ConstructorTest(String browser) {
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
    @DisplayName("Transition to 'Buns' tab")
    @Description("Check that a new user can successfully proceed to 'Buns' tab of 'Constructor' using 'Buns' button")
    public void testUserIsProceededToBunsTabOfConstructor() {
        mainPage.clickLoginIntoAccountButton();
        loginPage.setEmail(responseData.get("email"));
        loginPage.setPassword(responseData.get("password"));
        loginPage.clickLoginButton();
        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        assertTrue(mainPage.isBunsHeaderDisplayed());
    }

    @Test
    @DisplayName("Transition to 'Sauces' tab")
    @Description("Check that a new user can successfully proceed to 'Sauces' tab of 'Constructor' using 'Sauces' button")
    public void testUserIsProceededToSaucesTabOfConstructor() {
        mainPage.clickLoginIntoAccountButton();
        loginPage.setEmail(responseData.get("email"));
        loginPage.setPassword(responseData.get("password"));
        loginPage.clickLoginButton();
        mainPage.clickSaucesButton();
        assertTrue(mainPage.isSaucesHeaderDisplayed());
    }

    @Test
    @DisplayName("Transition to 'Fillings' tab")
    @Description("Check that a new user can successfully proceed to 'Fillings' tab of 'Constructor' using 'Fillings' button")
    public void testUserIsProceededToFillingsTabOfConstructor() {
        mainPage.clickLoginIntoAccountButton();
        loginPage.setEmail(responseData.get("email"));
        loginPage.setPassword(responseData.get("password"));
        loginPage.clickLoginButton();
        mainPage.clickFillingsButton();
        assertTrue(mainPage.isFillingsHeaderDisplayed());
    }
}