package screens;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SearchResultScreen {

    private final ElementsCollection resultCollection = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Проверить что поисковой результат не пустой")
    public void checkResultSizeIsNotEmpty(){
        resultCollection.shouldHave(sizeGreaterThan(0));
    }

    @Step("Перейти по первому элементу в списке")
    public void clickFirstResult(){
        resultCollection.first().click();
    }
}
