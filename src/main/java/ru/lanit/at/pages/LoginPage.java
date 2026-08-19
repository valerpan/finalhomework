package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.lanit.at.utils.web.pagecontext.WebPage;
import ru.lanit.at.utils.web.annotations.Name;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;
/** Страница логина */
@Name(value = "Авторизация")
public class LoginPage extends WebPage {

    @Name("поле логина")
    private SelenideElement username = $x("//*[@id='username']");

    @Name("поле пароля")
    private SelenideElement password = $("#password");

    @Name("кнопка входа")
    private SelenideElement loginButton = $("[type='submit']");

    /**
     * Авторизация пользователя
     *
     * @param user     логин пользователя
     * @param pass     пароль пользователя
     */
    public LoginPage login(String user, String pass) {
        setUser(user);
        setPassword(pass);
        clickOnLoginButton();
        return this;
    }

    public LoginPage setUser(String user) {
        getElement("поле логина").setValue(user);
        return this;
    }

    public LoginPage setPassword(String pass) {
        getElement("поле пароля").setValue(pass);
        return this;
    }

    public LoginPage clickOnLoginButton() {
        getElement("кнопка входа").click();
        return this;
    }
}
