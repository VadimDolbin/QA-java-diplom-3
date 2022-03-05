package com.stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Set value for 'Email' field")
    public void setEmail(String email) {
        emailField.shouldBe(Condition.visible).click();
        emailField.shouldBe(Condition.visible).sendKeys(Keys.CONTROL + "a");
        emailField.shouldBe(Condition.visible).sendKeys(Keys.BACK_SPACE);
        emailField.shouldBe(Condition.visible).setValue(email);
    }

    @Step("Set value for 'Password' field")
    public void setPassword(String password) {
        passwordField.shouldBe(Condition.visible).click();
        passwordField.shouldBe(Condition.visible).sendKeys(Keys.CONTROL + "a");
        passwordField.shouldBe(Condition.visible).sendKeys(Keys.BACK_SPACE);
        passwordField.shouldBe(Condition.visible).setValue(password);
    }

    @Step("Click on 'Register' link")
    public void clickRegisterLink() {
        registerLink.shouldBe(Condition.visible).click();
    }

    @Step("Click on 'Forgot password' link")
    public void clickForgotPasswordLink() {
        forgotPasswordLink.shouldBe(Condition.visible).click();
    }

    @Step("Click on 'Login' button")
    public void clickLoginButton() {
        loginButton.shouldBe(Condition.visible).click();
    }

    @Step("Check that 'Login label' is displayed")
    public boolean isLoginLabelDisplayed() {
        return loginLabel.shouldBe(Condition.visible).isDisplayed();
    }
}