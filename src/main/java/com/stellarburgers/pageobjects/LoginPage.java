package com.stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.XPATH, using = "//label[text() = 'Email']//following-sibling::input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//label[text() = 'Пароль']//following-sibling::input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Войти']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = "//a[text() = 'Зарегистрироваться']")
    private SelenideElement registerLink;

    @FindBy(how = How.XPATH, using = "//a[text() = 'Восстановить пароль']")
    private SelenideElement forgotPasswordLink;

    @FindBy(how = How.XPATH, using = "//h2[text() = 'Вход']")
    private SelenideElement loginLabel;

    public void setEmail(String email) {
        emailField.shouldBe(Condition.visible).click();
        emailField.shouldBe(Condition.visible).sendKeys(Keys.CONTROL + "a");
        emailField.shouldBe(Condition.visible).sendKeys(Keys.BACK_SPACE);
        emailField.shouldBe(Condition.visible).setValue(email);
    }

    public void setPassword(String password) {
        passwordField.shouldBe(Condition.visible).click();
        passwordField.shouldBe(Condition.visible).sendKeys(Keys.CONTROL + "a");
        passwordField.shouldBe(Condition.visible).sendKeys(Keys.BACK_SPACE);
        passwordField.shouldBe(Condition.visible).setValue(password);
    }

    public void clickRegisterLink() {
        registerLink.shouldBe(Condition.visible).click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.shouldBe(Condition.visible).click();
    }

    public void clickLoginButton() {
        loginButton.shouldBe(Condition.visible).click();
    }

    public boolean isLoginLabelDisplayed() {
        return loginLabel.shouldBe(Condition.visible).isDisplayed();
    }
}