package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;


public class PracticeFormTestWithFakerHWTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    RandomUtils randomUtils = new RandomUtils();
    String name = randomUtils.getFirstName(),
            lastName = randomUtils.getLastName(),
            email = randomUtils.getEmail(),
            gender = randomUtils.getRandomGender(),
            phone = randomUtils.getPhone(),
            hobby = randomUtils.getRandomHobbies(),
            image = "image.img",
            address = randomUtils.getAddress(),
            state = randomUtils.getRandomState(),
            city = randomUtils.getRandomCity(state),
            month = randomUtils.getRandomMonth(),
            day = randomUtils.getDay(month),
            year = randomUtils.getYear(),
            subject = randomUtils.getSubjects();


    @Test
    void successTest() {

        registrationPage.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .setBirthDay(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setUploadPicture("img/"+ image)
                .setCurrentAddress(address)
                .setStateAndCity(state, city)
                .clickSubmit();

        registrationPage.verifyTitle("Thanks for submitting the form")
                .verifyResult("Student Name", name + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", image)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }


}
