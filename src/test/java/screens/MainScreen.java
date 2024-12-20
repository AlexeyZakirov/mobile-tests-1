package screens;

import io.qameta.allure.Step;
import screens.components.SearchInputComponent;

public class MainScreen {
    @Step("Ввести поисковой запрос - {0}")
    public void searchQuery(String query) {
        new SearchInputComponent().clickSearchField().searchQuery(query);
    }
}
