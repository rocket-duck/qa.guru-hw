package demoqa.utils;

import com.github.javafaker.Faker;
import java.util.Locale;

import static demoqa.utils.RandomUtils.*;

public class TestData {
    public String firstName = getFirstName(),
        lastName = getLastName(),
        email = getEmail(),
        gender = getGender(),
        phone = getPhone(),
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

    private static final Faker faker = new Faker(new Locale("pl"));

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

        return genders[getRandomInt(genders.length)];
    }

    private String getPhone() {
        int phoneLength = 10;

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

        return monthNames[Integer.parseInt(getRandomDate()[1]) - 1];
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

        return subjects[getRandomInt(subjects.length)];
    }

    private String getHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return hobbies[getRandomInt(hobbies.length)];
    }

    private String getPicture() {
        String[] pictures = {"SCR-10.png", "SCR-20.png", "SCR-30.png", "SCR-40.png"};

        return pictures[getRandomInt(pictures.length)];
    }

    private String getAddress() {
        return faker.address().fullAddress();
    }

    private String getState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return states[getRandomInt(states.length)];
    }

    private String getCity(String state) {
        String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
        String[] uttarPradeshCities = {"Agra", "Lucknow", "Merrut"};
        String[] haryanaCities = {"Karnal", "Panipat"};
        String[] rajasthanCities = {"Jaipur", "Jaiselmer"};

        return switch (state) {
            case ("NCR") -> ncrCities[getRandomInt(ncrCities.length)];
            case ("Uttar Pradesh") -> uttarPradeshCities[getRandomInt(uttarPradeshCities.length)];
            case ("Haryana") -> haryanaCities[getRandomInt(haryanaCities.length)];
            case ("Rajasthan") -> rajasthanCities[getRandomInt(rajasthanCities.length)];
            default -> throw new IllegalStateException("Unexpected value: " + state);
        };
    }
}
