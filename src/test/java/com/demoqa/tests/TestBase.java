package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

//    String name = "John";
//    String lastName = "Doe";
//    String email = "Jogn_Doe@jd.com";
//    String phone = "1234567890";
//    String address = "221b, Baker Street, London, NW1 6XE, UK";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
        //Configuration.pageLoadStrategy = "eager";
    }
}
