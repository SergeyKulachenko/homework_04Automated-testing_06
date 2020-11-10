package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelp;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.*;

public class MonTransfer {

    @Test
    void shouldTransferMoneyBetweenOwnCardsFrom2To_1() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelp.getAuthInf();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelp.getVerificationCodeFor(authInfo);
        var dashboardCardPage = verificationPage.validVerify(verificationCode);
        int numbeCardForRep = 1; //номер карты для пополнения счёта
        String sumRep = "2846";  //сумма пополнения
        var dashboardCardReplPage = dashboardCardPage.replenishCard(numbeCardForRep);
        dashboardCardReplPage.replenishCard(sumRep, numbeCardForRep);
        System.out.println("Баланс " + numbeCardForRep + " карты =" + dashboardCardPage.infoBalansCard(numbeCardForRep) + " руб.");
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsFrom1To_2() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelp.getAuthInf();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelp.getVerificationCodeFor(authInfo);
        var dashboardCardPage = verificationPage.validVerify(verificationCode);
        int numbeCardForRep = 2; //номер карты для пополнения счёта
        String sumRep = "1264";  //сумма пополнения
        var dashboardCardReplPage = dashboardCardPage.replenishCard(numbeCardForRep);
        dashboardCardReplPage.replenishCard(sumRep, numbeCardForRep);
        System.out.println("Баланс " + numbeCardForRep + " карты =" + dashboardCardPage.infoBalansCard(numbeCardForRep) + " руб.");
    }
}
