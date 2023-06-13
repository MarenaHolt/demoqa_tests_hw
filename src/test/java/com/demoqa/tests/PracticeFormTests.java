package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successTest() {
        String name = "John";
        String lastName = "Doe";
        String email = "Jogn_Doe@jd.com";
        String phone = "1234567890";
        String address = "221b, Baker Street, London, NW1 6XE, UK";

        open("/automation-practice-form");

        WebDriverRunner.getWebDriver().manage().window().maximize();

        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#userName-wrapper #firstName").setValue(name);
        $("#userName-wrapper #lastName").setValue(lastName);

        $("#userEmail").setValue(email);

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue(phone);

        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--027:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("M");
        $(byText("Maths")).click();


        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("image.img");

        $("#currentAddress").setValue(address);

        $("#stateCity-wrapper #state").click();
        $("#stateCity-wrapper #state").$(byText("Haryana")).click();
        $("#stateCity-wrapper #city").click();
        $("#stateCity-wrapper #city").$(byText("Panipat")).click();

        $("#submit").click();


        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text((name + " " + lastName))).shouldHave(text((email)))
                .shouldHave(text((address)))
                .shouldHave(text((phone)))
                .shouldHave(text(("image.img")))
                .shouldHave(text(("Maths")))
                .shouldHave(text(("Haryana")))
                .shouldHave(text(("Panipat")))
                .shouldHave(text(("Reading")))
                .shouldHave(text(("June")))
                .shouldHave(text(("1990")))
                .shouldHave(text(("27")))
                .shouldHave(text(("Male")));
    }

}
