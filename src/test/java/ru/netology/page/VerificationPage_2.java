package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelp;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage_2 {

    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public VerificationPage_2() {
        codeField.shouldBe(visible);
    }

    public void validVerify(DataHelp.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
    }
}
