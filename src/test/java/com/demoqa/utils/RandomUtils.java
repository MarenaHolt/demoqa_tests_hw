package com.demoqa.utils;

import com.github.javafaker.Faker;


public class RandomUtils {
//    public static String getRandomString(int len) {
//        //String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        SecureRandom rnd = new SecureRandom();
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < len; i++)
//            sb.append(AB.charAt(rnd.nextInt(AB.length())));
//        return sb.toString();
//    }
//
//    public static String getRandomEmail() {
//        return getRandomString(10) + "@qa.guru";
//    }
//
//    public static int getRandomInt(int min, int max) {
//        return ThreadLocalRandom.current().nextInt(min, max + 1);
//    }
//
//    // +3 (263) 253 - 66 - 12
//    public static String getRandomPhone() {
//        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
//                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 90));
//    }
//
//    public static String getRandomGender() {
//        String[] genders = {"Male", "Female", "Other"};
//
//        return getRandomItemFromArray(genders);
//    }
//
//    private static String getRandomItemFromArray(String[] values) {
//        int index = getRandomInt(0, values.length - 1);
//
//        return values[index];
//    }
//
//    public static String getRandomUuid() {
//        return UUID.randomUUID().toString();
//    }

    Faker faker = new Faker();
    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public String getPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getAddress(){
        return faker.address().fullAddress();
    }

    public String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getRandomCity(String state) {
        switch (state) {
            case "NCR": {
                String[] city = {"Delhi", "Gurgaon", "Noida"};
                return faker.options().option(city);
            }
            case "Uttar Pradesh": {
                String[] city = {"Agra", "Lucknow", "Merrut"};
                return faker.options().option(city);
            }
            case "Haryana": {
                String[] city = {"Karnal", "Panipat"};
                return faker.options().option(city);
            }
            case "Rajasthan": {
                String[] city = {"Jaipur", "Jaiselmer"};
                return faker.options().option(city);
            }
        }
        return null;
    }

    public String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        return faker.options().option(months);
    }

    public String getYear() {
        return String.valueOf(faker.number().numberBetween(1900, 2100));
    }

    public String getDay(String month) {
        if (month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November")) {
           // return String.valueOf(faker.number().numberBetween(1, 30));
            return String.format("%02d", faker.number().numberBetween(1, 30));
        } else if (month.equals("February")) {
            return String.format("%02d", faker.number().numberBetween(1, 28));
           // return String.valueOf(faker.number().numberBetween(1, 28));
        } else {
           // return String.valueOf(faker.number().numberBetween(1, 31));
           return String.format("%02d", faker.number().numberBetween(1, 31));
        }
    }

    public String getSubjects() {
        return faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry",
                "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts",
                "Social Studies", "History", "Civics");
    }
}