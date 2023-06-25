package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.TextBoxPage;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;

public class TextboxWithFakerHwTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    String name = randomUtils.getFirstName(),
            email = randomUtils.getEmail(),
            currentAddress = randomUtils.getAddress(),
            permanentAddress = randomUtils.getAddress();

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
