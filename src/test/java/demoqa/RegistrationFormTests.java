package demoqa;

import demoqa.pages.RegistrationPage;

import demoqa.utils.TestData;
import org.junit.jupiter.api.Test;

public class RegistrationFormTests extends TestBase {
    @Test
    void successSubmitWholeFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        TestData data = new TestData();

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setUserNumber(data.phone)
                .setBirthDate(data.day, data.month, data.year)
                .setSubjects(data.subject)
                .setHobbies(data.hobbie)
                .uploadFile(data.picture)
                .setCurrentAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .submitForm();

        registrationPage.checkModalTableExists();
        registrationPage.checkModalTableHeader("Thanks for submitting the form");
        registrationPage.checkModalTableResult("Student Name", data.firstName + " " + data.lastName)
                .checkModalTableResult("Student Email", data.email)
                .checkModalTableResult("Gender", data.gender)
                .checkModalTableResult("Mobile", data.phone)
                .checkModalTableResult("Date of Birth", data.formattedDate)
                .checkModalTableResult("Subjects", data.subject)
                .checkModalTableResult("Hobbies", data.hobbie)
                .checkModalTableResult("Picture", data.picture)
                .checkModalTableResult("Address", data.address)
                .checkModalTableResult("State and City", data.state + " " + data.city);
    }

    @Test
    void successSubmitShortFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        TestData data = new TestData();

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setUserNumber(data.phone)
                .setBirthDate(data.day, data.month, data.year)
                .submitForm();

        registrationPage.checkModalTableExists();
        registrationPage.checkModalTableHeader("Thanks for submitting the form");
        registrationPage.checkModalTableResult("Student Name", data.firstName + " " + data.lastName)
                .checkModalTableResult("Student Email", " ")
                .checkModalTableResult("Gender", data.gender)
                .checkModalTableResult("Mobile", data.phone)
                .checkModalTableResult("Date of Birth", data.formattedDate)
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
