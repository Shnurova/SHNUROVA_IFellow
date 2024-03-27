package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({"classpath:test.properties"})
public interface PropertiesConfig extends Config{
    PropertiesConfig config = ConfigFactory.create(PropertiesConfig.class);

    @Key("base.uri.reqres")
    String baseUriReqres();

    @Key("base.uri.rick.and.morty")
    String baseUriRaM();

    @Key("body.data")
    String bodyDataPath();
}
