package com.stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = "//p[text() = 'Личный Кабинет']")
    private SelenideElement personalAccountButton;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Войти в аккаунт']")
    private SelenideElement loginIntoAccountButton;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Оформить заказ']")
    private SelenideElement placeOrderButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Булки']/parent::div[contains(@class, 'tab')]")
    private SelenideElement bunsButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']/parent::div[contains(@class, 'tab')]")
    private SelenideElement saucesButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']/parent::div[contains(@class, 'tab')]")
    private SelenideElement fillingsButton;

    @FindBy(how = How.XPATH, using = "//h2[text()='Булки']")
    private SelenideElement bunsHeader;

    @FindBy(how = How.XPATH, using = "//h2[text()='Соусы']")
    private SelenideElement saucesHeader;

    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    private SelenideElement fillingsHeader;

    public void clickPersonalAccountButton() {
        personalAccountButton.shouldBe(Condition.visible).click();
    }

    public void clickLoginIntoAccountButton() {
        loginIntoAccountButton.shouldBe(Condition.visible).click();
    }

    public boolean isPlaceOrderButtonDisplayed() {
        return placeOrderButton.shouldBe(Condition.visible).isDisplayed();
    }

    public void clickBunsButton() {
        bunsButton.shouldBe(Condition.visible).click();
    }

    public void clickSaucesButton() {
        saucesButton.shouldBe(Condition.visible).click();
    }

    public void clickFillingsButton() {
        fillingsButton.shouldBe(Condition.visible).click();
    }

    public boolean isBunsHeaderDisplayed() {
        return bunsHeader.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isSaucesHeaderDisplayed() {
        return saucesHeader.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isFillingsHeaderDisplayed() {
        return fillingsHeader.shouldBe(Condition.visible).isDisplayed();
    }
}