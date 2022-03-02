package com.stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    public boolean isUserProfileLinkDisplayed() {
        return userProfileLink.shouldBe(Condition.visible).isDisplayed();
    }

    public void clickConstructorButton() {
        constructorButton.shouldBe(Condition.visible).click();
    }

    public void clickStellarBurgersIcon() {
        stellarBurgersIcon.shouldBe(Condition.visible).click();
    }

    public void clickLogoutButton() {
        logoutButton.shouldBe(Condition.visible).click();
    }
}