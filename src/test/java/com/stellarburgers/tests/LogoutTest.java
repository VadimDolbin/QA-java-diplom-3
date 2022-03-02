package com.stellarburgers.tests;

import com.UserOperations;
import com.codeborne.selenide.WebDriverRunner;
import com.stellarburgers.pageobjects.LoginPage;
import com.stellarburgers.pageobjects.MainPage;
import com.stellarburgers.pageobjects.PersonalAccountPage;
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
public class LogoutTest {
    Map<String, String> responseData;
    MainPage mainPage;
    LoginPage loginPage = page(LoginPage.class);
    PersonalAccountPage personalAccountPage= page(PersonalAccountPage.class);

    private final String browser;

    public LogoutTest(String browser) {
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
    @DisplayName("Logout using 'Log out' button")
    @Description("Check that a new user can successfully logout using 'Log out' button on 'Personal Account' page")
    public void testUserIsLoggedOutUsingLogoutButton() {
        mainPage.clickLoginIntoAccountButton();
        loginPage.setEmail(responseData.get("email"));
        loginPage.setPassword(responseData.get("password"));
        loginPage.clickLoginButton();
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickLogoutButton();
        assertTrue(loginPage.isLoginLabelDisplayed());
    }
}