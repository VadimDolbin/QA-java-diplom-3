package com.stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {
    @FindBy(how = How.XPATH, using = "//a[text() = 'Профиль']")
    private SelenideElement userProfileLink;

    @FindBy(how = How.XPATH, using = "//p[text() = 'Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'header__logo')]")
    private SelenideElement stellarBurgersIcon;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Выход']")
    private SelenideElement logoutButton;

    @Step("Check that 'User profile' link is displayed")
    public boolean isUserProfileLinkDisplayed() {
        return userProfileLink.shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Click on 'Constructor' button")
    public void clickConstructorButton() {
        constructorButton.shouldBe(Condition.visible).click();
    }

    @Step("Click on 'Stellar Burgers' icon")
    public void clickStellarBurgersIcon() {
        stellarBurgersIcon.shouldBe(Condition.visible).click();
    }

    @Step("Click on 'Logout' button")
    public void clickLogoutButton() {
        logoutButton.shouldBe(Condition.visible).click();
    }
}