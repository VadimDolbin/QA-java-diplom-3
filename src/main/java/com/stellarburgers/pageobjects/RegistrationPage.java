package com.stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    public void setName(String name) {
        nameField.shouldBe(Condition.visible).setValue(name);
    }

    public void setEmail(String email) {
        emailField.shouldBe(Condition.visible).setValue(email);
    }

    public void setPassword(String password) {
        passwordField.shouldBe(Condition.visible).setValue(password);
    }

    public void clickRegisterButton() {
        registerButton.shouldBe(Condition.visible).click();
    }

    public boolean isIncorrectPasswordLabelDisplayed() {
        return incorrectPasswordLabel.shouldBe(Condition.visible).isDisplayed();
    }

    public void clickLoginLink() {
        loginLink.shouldBe(Condition.visible).click();
    }
}