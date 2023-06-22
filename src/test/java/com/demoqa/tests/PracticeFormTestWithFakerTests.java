package com.demoqa.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.demoqa.utils.RandomUtils.getRandomEmail;
import static com.demoqa.utils.RandomUtils.getRandomString;

public class PracticeFormTestWithFakerTests extends TestBase {

    @Test
    void successTest() {
        Faker faker = new Faker();
       // Faker faker = new Faker(new Locale("ru"));
    String name = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress();
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
