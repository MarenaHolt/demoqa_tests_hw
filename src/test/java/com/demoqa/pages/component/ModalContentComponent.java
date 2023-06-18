package com.demoqa.pages.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalContentComponent {

    SelenideElement
            modalHeader = $(".modal-header"),
            tableResponsive = $(".table-responsive");

    public ModalContentComponent verifyTitle(String headerTitle) {
        modalHeader.shouldHave(text(headerTitle));

        return this;
    }

    public ModalContentComponent verifyResult(String label, String value) {
        tableResponsive.$(byText(label)).sibling(0).shouldHave(text(value));
        return this;
    }

}
