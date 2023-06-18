package com.demoqa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.demoqa.pages.component.CalendarComponent;
import com.demoqa.pages.component.ModalContentComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ModalContentComponent modalContentComponent = new ModalContentComponent();

    SelenideElement
            firstNameInput = $("#userName-wrapper #firstName"),
            lastNameInput = $("#userName-wrapper #lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictures = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateCityWrapperState = $("#stateCity-wrapper #state"),
            stateCityWrapperCity = $("#stateCity-wrapper #city"),
            buttonSubmit =  $("#submit");



    public RegistrationPage openPage(){
        open("/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String phone) {
        phoneNumberInput.setValue(phone);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String letter, String word) {
        subjectsInput.setValue(letter);
        $(byText(word)).click();

        return this;
    }

    public RegistrationPage setHobbies(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage setUploadPicture(String fileName) {
        uploadPictures.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddress.setValue(address);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateCityWrapperState.click();
        stateCityWrapperState.$(byText(state)).click();
        stateCityWrapperCity.click();
        stateCityWrapperCity.$(byText(city)).click();

        return this;
    }

    public RegistrationPage clickSubmit() {
        $(buttonSubmit).click();

        return this;
    }

    public RegistrationPage verifyTitle(String title) {
        modalContentComponent.verifyTitle(title);

        return this;
    }

    public RegistrationPage verifyResult(String label, String value) {
        modalContentComponent.verifyResult(label, value);

        return this;
    }







}
