package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


public class PracticeFormWithPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String name = "John";
    String lastName = "Doe";
    String email = "John_Doe@jd.com";
    String gender = "Male";
    String phone = "1234567890";
    String hobby = "Reading";
    String image = "img/image.img";
    String address = "221b, Baker Street, London, NW1 6XE, UK";
    String state = "Haryana";
    String city = "Panipat";
    String day = "27";
    String month = "June";
    String year = "1990";
    String subject = "Maths";


    @Test
    void successTest() {

        registrationPage.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .setBirthDay(day, month, year)
                .setSubjects("M", subject)
                .setHobbies(hobby)
                .setUploadPicture(image)
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
                .verifyResult("Picture", "image.img")
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }

}
