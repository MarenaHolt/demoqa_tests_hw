package com.demoqa.tests.test_with_allure;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.TextBoxPage;
import com.demoqa.tests.TestBase;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TextboxWithFakerHwTestWithAllure extends TestBaseWithAllure {

    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    String name = randomUtils.getFirstName(),
            email = randomUtils.getEmail(),
            currentAddress = randomUtils.getAddress(),
            permanentAddress = randomUtils.getAddress();

    @Test
    @Tag("simple")
    @DisplayName("Successful text BoxPage")
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
