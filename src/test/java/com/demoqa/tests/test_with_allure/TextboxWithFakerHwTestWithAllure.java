package com.demoqa.tests.test_with_allure;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.TextBoxPage;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

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
        step("Open form and fill form", () -> {
            textBoxPage.openTextBoxPage()
                    .setName(name)
                    .setEmail(email)
                    .setCurrentAddress(currentAddress)
                    .setPermanentAddress(permanentAddress);

            registrationPage.clickSubmit();
        });

        step("Verify result", () -> {
            textBoxPage.verifyResult(name, email, currentAddress, permanentAddress);
        });
    }
}
