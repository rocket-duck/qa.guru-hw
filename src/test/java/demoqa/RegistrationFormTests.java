package demoqa;

import demoqa.pages.RegistrationPage;

import org.junit.jupiter.api.Test;

public class RegistrationFormTests extends TestBase {
    @Test
    void successSubmitWholeFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage()
                .setFirstName("Pupa")
                .setLastName("Lupa")
                .setEmail("pupa@lupa.com")
                .setGender("Other")
                .setUserNumber("8005553535")
                .setBirthDate("3", "January", "1900")
                .setSubjects("Math")
                .setHobbies("Reading")
                .uploadFile("SCR-20.png")
                .setCurrentAddress("Lupa's street")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .submitForm();

        registrationPage.checkModalTableExists();
        registrationPage.checkModalTableHeader("Thanks for submitting the form");
        registrationPage.checkModalTableResult("Student Name", "Pupa Lupa")
                .checkModalTableResult("Student Email", "pupa@lupa.com")
                .checkModalTableResult("Gender", "Other")
                .checkModalTableResult("Mobile", "8005553535")
                .checkModalTableResult("Date of Birth", "03 January,1900")
                .checkModalTableResult("Subjects", "Math")
                .checkModalTableResult("Hobbies", "Reading")
                .checkModalTableResult("Picture", "SCR-20.png")
                .checkModalTableResult("State and City", "Rajasthan Jaipur");
    }

    @Test
    void successSubmitShortFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage()
                .setFirstName("Pupa")
                .setLastName("Lupa")
                .setGender("Other")
                .setUserNumber("8005553535")
                .setBirthDate("1", "March", "2024")
                .submitForm();

        registrationPage.checkModalTableHeader("Thanks for submitting the form");
        registrationPage.checkModalTableResult("Student Name", "Pupa Lupa")
                .checkModalTableResult("Student Email", " ")
                .checkModalTableResult("Gender", "Other")
                .checkModalTableResult("Mobile", "8005553535")
                .checkModalTableResult("Date of Birth", "01 March,2024")
                .checkModalTableResult("Subjects", " ")
                .checkModalTableResult("Hobbies", " ")
                .checkModalTableResult("Picture", " ")
                .checkModalTableResult("Address", " ")
                .checkModalTableResult("State and City", " ");
    }

    @Test
    void submitEmptyFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage()
                .submitForm();

        registrationPage.checkModalTableNotExists();
    }
}
