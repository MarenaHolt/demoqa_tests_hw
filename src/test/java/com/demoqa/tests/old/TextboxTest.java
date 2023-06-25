package com.demoqa.tests.old;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.TextBoxPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.Test;

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
