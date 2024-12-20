import org.junit.jupiter.api.Test;
import screens.ErrorScreen;
import screens.MainScreen;
import screens.SearchResultScreen;

public class WikipediaTests extends TestBase {
    private final SearchResultScreen searchResultScreen = new SearchResultScreen();
    private final ErrorScreen errorScreen = new ErrorScreen();
    private final MainScreen mainScreen = new MainScreen();

    @Test
    void androidSuccessfulSearchTest() {
        mainScreen.searchQuery("Appium");
        searchResultScreen.checkResultSizeIsNotEmpty();
    }

    @Test
    void androidUnsuccessfulAeroflotTest() {
        mainScreen.searchQuery("Java");
        searchResultScreen.clickFirstResult();
        errorScreen.checkError("An error occurred");
    }
}
