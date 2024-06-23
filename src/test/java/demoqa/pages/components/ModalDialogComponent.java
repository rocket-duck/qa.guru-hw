package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalDialogComponent {
    private final SelenideElement modalDialog = $(".modal-content");
    private final SelenideElement modalDialogHeader = modalDialog.$("#example-modal-sizes-title-lg");
    private final SelenideElement modalDialogTable = modalDialog.$(".table-responsive");

    public void checkModalDialogVisible() {
        modalDialog.shouldBe(visible);
    }

    public void checkModalDialogNotVisible() {
        modalDialog.shouldNot(visible);
    }

    public void checkModalDialogHeader(String headerText) {
        modalDialogHeader.shouldHave(text(headerText));
    }

    public void checkModalDialogTable(String key, String value) {
        modalDialogTable.$(byText(key))
                .parent()
                .shouldHave(text(value));
    }
}
