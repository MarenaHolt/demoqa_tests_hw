package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextboxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationPage registrationPage = new RegistrationPage();

    String name = "Some name";
    String email = "some_email@someemail.com";
    String currentAddress = "Some address";
    String permanentAddress = "Another address";

    @Test
    void successTest() {
        textBoxPage.openTextBoxPage()
                .setName(name)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress);

        registrationPage.clickSubmit();

        textBoxPage.verifyResult(name, email, currentAddress, permanentAddress);
    }
}
