package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardCardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement battonReplenish_1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").$("[type=button]");
    private SelenideElement battonReplenish_2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").$("[type=button]");
    private SelenideElement battonReload = $("[data-test-id='action-reload']");
    private SelenideElement infoStr1Card = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement infoStr2Card = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public DashboardCardReplPage replenishCard(int numbeCard) {
        if (numbeCard == 1) battonReplenish_1.click();
        else battonReplenish_2.click();
        return new DashboardCardReplPage();
    }

    public String infoBalansCard(int nambeCard) {
        if (nambeCard == 1) {
            var balansTemp = infoStr1Card.getText();
            var balans = balansTemp.substring(28, balansTemp.length() - 13);
            return balans;
        } else {
            var balansTemp = infoStr2Card.getText();
            var balans = balansTemp.substring(28, balansTemp.length() - 13);
            return balans;
        }
    }

    public DashboardCardPage() {
        heading.shouldBe(visible);
    }
}
