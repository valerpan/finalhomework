package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.lanit.at.utils.web.pagecontext.WebPage;
import ru.lanit.at.utils.web.annotations.Name;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;

/** Страница отдельного тикета (авторизированный пользователь) */
@Name(value = "Страница тикета")
public class TicketPage extends WebPage {

    @Name("заголовок тикета")
    private SelenideElement title = $x("//th[@colspan='4']/h3");

    @Name("очередь")
    private SelenideElement queue = $x("//th[contains(text(), 'Queue:')]");

    @Name("дата выполнения")
    private SelenideElement dueDate = $x("//th[text()='Due Date']/following-sibling::td[1]");

    @Name("email")
    private SelenideElement email = $x("//th[text()='Submitter E-Mail']/following-sibling::td[1]");

    @Name("приоритет")
    private SelenideElement priority = $x("//th[text()='Priority']/following-sibling::td[1]");

    @Name("описание")
    private SelenideElement description = $x("//td[@id='ticket-description']/p");

    @Name("добавить файлы")
    private SelenideElement buttonAddFiles = $x("//button[@id='ShowFileUpload']");

    @Name("выбрать файл")
    private SelenideElement selectFile = $(".btn-file");

}

