package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({"classpath:not.properties"})
public interface PropertiesConfig extends Config{
    PropertiesConfig config = ConfigFactory.create(PropertiesConfig.class);
    @Key("site")
    String site();
    @Key("login")
    String login();
    @Key("password")
    String password();
    @Key("task_summary")
    String taskSummary();
    @Key("task_description")
    String taskDescription();
}
