package ru.lanit.at.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.lanit.at.utils.web.pagecontext.WebPage;
import ru.lanit.at.utils.web.annotations.Name;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

/** Страница с таблицей тикетов и фильтрами */
@Name(value = "Список тикетов")
public class TicketsPage extends WebPage {

    @Name("ссылки на тикеты")
    private ElementsCollection ticketsHref = $$x("//div[@class='tickettitle']/a");

    @Name("поле поиска")
    private SelenideElement search = $("#search_query");

    @Name("кнопка поиска")
    private SelenideElement searchButton = $x("//i[@class='fas fa-search']/parent::button");

    public TicketsPage clickOnSearch(String title) {
        getElement("поле поиска").clear();
        getElement("поле поиска").setValue(title);
        getElement("кнопка поиска").click();
        return this;
    }
    @Name("сортировка")
    private SelenideElement sortingBy = $x("//select[@id='id_sortx']");

    @Name("сортировка по названию")
    private SelenideElement sortingByField = $x("//select[@id='id_sortx']/option[@value='title']");

    @Name("чекбокс обратного порядка")
    private SelenideElement inputReverse = $x("//input[@id='id_sortreverse']");

    @Name("выпадающий список добавления фильтра")
    private SelenideElement addFilter = $x("//select[@id='filterBuilderSelect']");

    @Name("фильтр на очередь")
    private SelenideElement addFilterQueue = $x("//select[@id='filterBuilderSelect']/option[@id='filterBuilderSelect-Queue']");

    @Name("очередь тикета")
    private SelenideElement addFilterQueueValue = $x("//select[@id='id_queues']/option[@value='1']");

    @Name("статус тикета")
    private SelenideElement statusTicket = $x("//select[@id='id_statuses']/option[@value='1']");

    @Name("кнопка для применения фильтра")
    private SelenideElement buttonApply = $x("//input[@value='Apply Filters']");

    @Name("таба для сохранения поискового запроса")
    private SelenideElement queryTab = $x("//button[@data-target='#collapseTwo']");

    @Name("название сохраненного поискового запроса")
    private SelenideElement queryTitle = $x("//input[@id='id_title']");

    @Name("кнопка сохранить поисковый запрос")
    private SelenideElement querySaveButton = $x("//input[@value='Save Query']");

    @Name("кнопка для отображения сохраненных запросов")
    private SelenideElement savedQueries = $x("//a[@id='ticketsDropdown']");
    /**
     * @param ticket
     */
}
