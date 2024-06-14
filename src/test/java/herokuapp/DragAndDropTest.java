package herokuapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void dragAndDropWithActionTest() {
        open("/drag_and_drop");
        $("#column-a").shouldBe(text("A"));
        $("#column-b").shouldBe(text("B"));

        actions().moveToElement($("#column-a"))
                .clickAndHold()
                .moveToElement($("#column-b"))
                .release()
                .perform();

        $("#column-a").shouldBe(text("B"));
        $("#column-b").shouldBe(text("A"));
    }

    @Test
    void dragAndDropWithNativeTest() {
        open("/drag_and_drop");
        $("#column-a").shouldBe(text("A"));
        $("#column-b").shouldBe(text("B"));

        $("#column-a").dragAndDrop(to("#column-b"));

        $("#column-a").shouldBe(text("B"));
        $("#column-b").shouldBe(text("A"));
    }
}