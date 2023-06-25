package com.demoqa.tests.old;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTestWithDataTest extends TestBase {
//    String name = "John";
//    String lastName = "Doe";
//    String email = "Jogn_Doe@jd.com";
//    String phone = "1234567890";
//    String address = "221b, Baker Street, London, NW1 6XE, UK";

    String name;
    String lastName;
    String email;
    String phone;
    String address;

//    @BeforeEach
//    void prepareTestData() {
//        name = "John";
//        lastName = "Doe";
//        email = "Jogn_Doe@jd.com";
//        phone = "1234567890";
//        address = "221b, Baker Street, London, NW1 6XE, UK";
//    }

    @Test
    void successTest() {


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

        $("#uploadPicture").uploadFromClasspath("img/image.img");

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
