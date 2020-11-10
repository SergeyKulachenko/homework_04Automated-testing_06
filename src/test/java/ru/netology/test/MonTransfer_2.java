package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelp;
import ru.netology.page.DashboardCardPage;
import ru.netology.page.DashboardCardReplPage;
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
        var dashboardCardPage = new DashboardCardPage();
        dashboardCardPage.replenishCard(1);
        DashboardCardReplPage dashboardCardReplPage = new DashboardCardReplPage();
        dashboardCardReplPage.replenishCard("456", 1);
        System.out.println("Баланс 1 карты =" + dashboardCardPage.infoBalansCard(1) + " руб.");
    }
}
