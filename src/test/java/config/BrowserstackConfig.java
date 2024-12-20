package config;

import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:properties/${os}.properties"
)
public interface BrowserstackConfig extends Config {

    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();

    @DefaultValue("bs://sample.app")
    String app();

    String remoteUrl();

    String device();

    @Key("os_version")
    String osVersion();
}
