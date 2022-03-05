package com.stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
    @FindBy(how = How.XPATH, using = "//label[text() = 'Имя']//following-sibling::input")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = "//label[text() = 'Email']//following-sibling::input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//label[text() = 'Пароль']//following-sibling::input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = "//p[text() = 'Некорректный пароль']")
    private SelenideElement incorrectPasswordLabel;

    @FindBy(how = How.XPATH, using = "//a[text() = 'Войти']")
    private SelenideElement loginLink;

    @Step("Set value for 'Name' field")
    public void setName(String name) {
        nameField.shouldBe(Condition.visible).setValue(name);
    }

    @Step("Set value for 'Email' field")
    public void setEmail(String email) {
        emailField.shouldBe(Condition.visible).setValue(email);
    }

    @Step("Set value for 'Password' field")
    public void setPassword(String password) {
        passwordField.shouldBe(Condition.visible).setValue(password);
    }

    @Step("Click on 'Register' button")
    public void clickRegisterButton() {
        registerButton.shouldBe(Condition.visible).click();
    }

    @Step("Check that 'Incorrect password' label is displayed")
    public boolean isIncorrectPasswordLabelDisplayed() {
        return incorrectPasswordLabel.shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Click on 'Login' link")
    public void clickLoginLink() {
        loginLink.shouldBe(Condition.visible).click();
    }
}