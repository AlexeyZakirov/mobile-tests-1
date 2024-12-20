package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    private final BrowserstackConfig config;

    public BrowserstackDriver(){
        this.config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    }
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", config.user());
        caps.setCapability("browserstack.key", config.key());

        caps.setCapability("app", config.app());
        caps.setCapability("device", config.device());
        caps.setCapability("os_version", config.osVersion());

        try{
            return new RemoteWebDriver(
                    new URL(config.remoteUrl()), caps
            );
        } catch (MalformedURLException e){
            throw new RuntimeException(e);
        }

    }
}
