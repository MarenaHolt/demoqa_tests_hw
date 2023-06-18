package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.component.ModalContentComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    String url = "/text-box";

    SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress");

    SelenideElement outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");


    public TextBoxPage openTextBoxPage() {
        open(url);
        return this;
    }

    public TextBoxPage setName(String name) {
        userName.setValue(name);

        return this;
    }

    public TextBoxPage setEmail(String email) {
        userEmail.setValue(email);

        return this;
    }

    public TextBoxPage setCurrentAddress(String address) {
        currentAddress.setValue(address);

        return this;
    }

    public TextBoxPage setPermanentAddress(String address) {
        permanentAddress.setValue(address);

        return this;
    }


    public TextBoxPage verifyResult(String name, String email, String currentAddress, String permanentAddress) {
        outputName.shouldHave(text(name));
        outputEmail.shouldHave(text(email));
        outputCurrentAddress.shouldHave(text(currentAddress));
        outputPermanentAddress.shouldHave(text(permanentAddress));

        return this;
    }

}
