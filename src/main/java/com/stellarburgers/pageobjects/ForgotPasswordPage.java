package com.stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    @FindBy(how = How.XPATH, using = "//a[text() = 'Войти']")
    private SelenideElement loginLink;

    @Step("Click on 'Login' link")
    public void clickLoginLink() {
        loginLink.shouldBe(Condition.visible).click();
    }
}