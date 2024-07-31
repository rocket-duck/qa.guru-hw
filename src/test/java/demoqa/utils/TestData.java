package demoqa.utils;

import com.github.javafaker.Faker;
import java.util.Locale;

import static demoqa.utils.RandomDate.*;

public class TestData {
    private final Faker faker = new Faker(new Locale("pl"));

    public String firstName = getFirstName(),
        lastName = getLastName(),
        email = getEmail(),
        gender = getGender(),
        phone = getPhone(10),
        day = getDay(),
        month = getMonth(),
        year = getYear(),
        formattedDate = getFormattedDate(day, month, year),
        address = getAddress(),
        subject = getSubject(),
        hobbie = getHobbies(),
        picture = getPicture(),
        state = getState(),
        city = getCity(state);

    private String getFirstName() {
        return faker.name().firstName();
    }

    private String getLastName() {
        return faker.name().lastName();
    }

    private String getEmail() {
        return faker.internet().emailAddress();
    }

    private String getGender() {
        String[] genders = {"Male", "Female", "Other"};

        return faker.options().option(genders);
    }

    private String getPhone(int phoneLength) {
        return faker.phoneNumber().subscriberNumber(phoneLength);
    }

    private String getDay() {
        return getRandomDate()[0];
    }

    private String getMonth() {
        String[] monthNames = {"January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"};

        return monthNames[Integer.parseInt(getRandomDate()[1]) + 1];
    }

    private String getYear() {
        return getRandomDate()[2];
    }

    private String getFormattedDate(String day, String month, String year) {
        return day + " " + month + "," + year;
    }

    private String getSubject() {
        String[] subjects = {
                "Arts", "History", "English", "Chemistry",
                "Computer Science", "Commerce", "Economics", "Maths",
                "Social Studies", "Accounting", "Physics", "Biology",
                "Hindi", "Civics"
        };

        return faker.options().option(subjects);
    }

    private String getHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return faker.options().option(hobbies);
    }

    private String getPicture() {
        String[] pictures = {"SCR-10.png", "SCR-20.png", "SCR-30.png", "SCR-40.png"};

        return faker.options().option(pictures);
    }

    private String getAddress() {
        return faker.address().fullAddress();
    }

    private String getState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return faker.options().option(states);
    }

    private String getCity(String state) {
        String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
        String[] uttarPradeshCities = {"Agra", "Lucknow", "Merrut"};
        String[] haryanaCities = {"Karnal", "Panipat"};
        String[] rajasthanCities = {"Jaipur", "Jaiselmer"};

        return switch (state) {
            case ("NCR") -> faker.options().option(ncrCities);
            case ("Uttar Pradesh") -> faker.options().option(uttarPradeshCities);
            case ("Haryana") -> faker.options().option(haryanaCities);
            case ("Rajasthan") -> faker.options().option(rajasthanCities);
            default -> throw new IllegalStateException("Unexpected value: " + state);
        };
    }
}
