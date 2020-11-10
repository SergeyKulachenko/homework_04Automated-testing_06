package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelp;
import ru.netology.page.LoginPage_2;
import ru.netology.page.VerificationPage_2;

import static com.codeborne.selenide.Selenide.open;

public class MonTransfer_2 {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
//       val loginPage = open("http://localhost:9999", LoginPage.class);
        open("http://localhost:9999");
        var loginPage = new LoginPage_2();
        val log_Pass = DataHelp.getAuthInf();
        loginPage.validLogin(log_Pass);
        var verPage = new VerificationPage_2();
        verPage.validVerify(DataHelp.getVerificationCodeFor(log_Pass));
//        var verCode_SMS = DataHelp.getVerificationCodeFor(log_Pass);
//        verPage.validVerify(verCode_SMS);
    }
}
