package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public final SelenideElement yearLocator = $(".react-datepicker__year-select");
    public final SelenideElement monthLocator = $(".react-datepicker__month-select");
    public final SelenideElement dayLocator = $(".react-datepicker__month");

    public void setDate(String day, String month, String year) {
        yearLocator.selectOption(year);
        monthLocator.selectOption(month);
        dayLocator.find(byText(day)).click();
    }
}
