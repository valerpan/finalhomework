package ru.lanit.at.steps.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.By;
import ru.lanit.at.steps.web.AbstractWebSteps;
import ru.lanit.at.utils.web.pagecontext.PageManager;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TicketPageWebSteps extends AbstractWebSteps {

    public TicketPageWebSteps(PageManager pageManager) {
        super(pageManager);
    }

    @Если("загрузить файл {string}")
    public void uploadFile(String fileName) {
        SelenideElement fileInput = $("#file0");
        fileInput.uploadFromClasspath(fileName);
        LOGGER.info("загружен файл '{}'", fileName);
    }

    @Если("проверить что на странице прикреплен файл {string}")
    public void checkFileAttached(String fileName) {
        $("#selectedfilename0").shouldBe(text(fileName));
    }

    @Когда("на странице присутствует часть текста {string}")
    public void textContainsOnPage(String text) {
        $x(".//*[contains(text(), '" + text + "')]").shouldBe(Condition.visible);
        LOGGER.info("на странице присутствует часть текста '{}'", text);
    }

    @Когда("кликнуть на элемент где присутствует часть текста {string}")
    public void clickOnElementByContainsText(String text) {
        $x(".//*[contains(text(), '" + text + "')]")
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент, содержащий текст '{}'", text);
    }

    @Если("на странице есть название поискового запроса {string}")
    public void checkTitle(String title) {
        $x("//a[@class='dropdown-item small' and normalize-space(.)='" + title + "']")
                .shouldBe(Condition.visible);
    }

    @Если("кликнуть на название поискового запроса {string}")
    public void clickSearchQuery(String title) {
        $x("//a[@class='dropdown-item small' and normalize-space(.)='" + title + "']")
                .shouldBe(Condition.visible)
                .click();
    }
}
