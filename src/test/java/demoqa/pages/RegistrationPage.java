package demoqa.pages;

import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.ModalDialogComponent;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameLocator = $("#firstName"),
            lastNameLocator = $("#lastName"),
            emailLocator = $("#userEmail"),
            genterWrapperLocator = $("#genterWrapper"),
            userNumberLocator = $("#userNumber"),
            dateOfBirthLocator = $("#dateOfBirthInput"),
            subjectsLocator = $("#subjectsInput"),
            hobbiesLocator = $("#hobbiesWrapper"),
            uploadPictureLocator = $("#uploadPicture"),
            currentAddressLocator = $("#currentAddress"),
            stateLocator = $("#state"),
            cityLocator =  $("#city"),
            stateCityWrapperLocator = $("#stateCity-wrapper"),
            submitButtonLocator = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ModalDialogComponent modalDialogComponent = new ModalDialogComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameLocator.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameLocator.setValue(lastName);

        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailLocator.setValue(email);

        return this;
    }

    public RegistrationPage setGenter(String genter) {
        genterWrapperLocator.$(byText(genter)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String number) {
        userNumberLocator.setValue(number);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthLocator.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsLocator.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesLocator.$(byText(hobbies)).click();

        return this;
    }

    public RegistrationPage uploadFile(String path) {
        uploadPictureLocator.uploadFromClasspath(path);

        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressLocator.setValue(address);

        return this;
    }

    public RegistrationPage setState(String state) {
        stateLocator.click();
        stateCityWrapperLocator.$(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityLocator.click();
        stateCityWrapperLocator.$(byText(city)).click();

        return this;
    }

    public RegistrationPage submitForm() {
        submitButtonLocator.click();

        return this;
    }

    public RegistrationPage checkModalTableExists() {
        modalDialogComponent.checkModalDialogVisible();

        return this;
    }

    public RegistrationPage checkModalTableNotExists() {
        modalDialogComponent.checkModalDialogNotVisible();

        return this;
    }

    public RegistrationPage checkModalTableHeader(String headerText) {
        modalDialogComponent.checkModalDialogHeader(headerText);

        return this;
    }

    public RegistrationPage checkModalTableResult(String key, String value) {
        modalDialogComponent.checkModalDialogTable(key, value);

        return this;
    }
}
