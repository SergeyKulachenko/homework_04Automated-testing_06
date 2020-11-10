package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelp;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage_2 {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");

    public void validLogin(DataHelp.AuthInfo authInfo_LogPass) {
        loginField.setValue(authInfo_LogPass.getLogin());
        passwordField.setValue(authInfo_LogPass.getPassword());
        loginButton.click();
    }
}
