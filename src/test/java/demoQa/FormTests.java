package demoQa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successSubmitFullFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Pupa");
        $("#lastName").setValue("Lupa");
        $("#userEmail").setValue("pupa@lupa.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("8005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1900");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("SCR-20.png");
        $("#currentAddress").setValue("Lupa's street");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                Condition.text("Student Name Pupa Lupa"),
                Condition.text("Student Email pupa@lupa.com"),
                Condition.text("Gender Other"),
                Condition.text("Mobile 8005553535"),
                Condition.text("Date of Birth 01 January,1900"),
                Condition.text("Subjects Math"),
                Condition.text("Hobbies Reading"),
                Condition.text("Picture SCR-20.png"),
                Condition.text("Address Lupa's street"),
                Condition.text("State and City Rajasthan Jaipur")
        );
    }

    @Test
    void successSubmitShortFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Pupa");
        $("#lastName").setValue("Lupa");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("8005553535");
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                Condition.text("Student Name Pupa Lupa"),
                Condition.text("Student Email"),
                Condition.text("Gender Other"),
                Condition.text("Mobile 8005553535"),
                Condition.text("Date of Birth 14 June,2024"), //upd date for test
                Condition.text("Subjects"),
                Condition.text("Hobbies"),
                Condition.text("Picture"),
                Condition.text("Address"),
                Condition.text("State and City")
        );
    }
}

