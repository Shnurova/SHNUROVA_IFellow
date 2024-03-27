package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import config.PropertiesConfig;

public class RickAndMorty extends TestBase {

    @Когда("запросить информацию по персонажам {string} в сериале \"Рик и Морти\"")
    public void characterInfo(String characterName) {
        String postUri = "character/?name=" + characterName + "&status=alive";
        characterInfo = getApi(PropertiesConfig.config.baseUriRaM(), postUri, 200);
    }
    @Когда("найти персонажа Морти Смита")
    public void locateMorty() {
        mortyId = characterInfo.jsonPath().get("results[0].id");
        infoMorty = getApi(PropertiesConfig.config.baseUriRaM(), "character/" + mortyId, 200);
    }
    @Когда("запомнить локацию и расу Морти Смита")
    public void memorizeCharacter() {
        locationMorty = infoMorty.jsonPath().getString("location.name");
        speciesMorty = infoMorty.jsonPath().getString("species");
    }
    @Когда("найти последний эпизод с участием Морти Смита")
    public void lastEpisode() {
        lastEpisodeMorty = infoMorty.jsonPath().getString("episode[-1]");
        goToLastEpisodeMorty = getApi(lastEpisodeMorty, "", 200);
    }
    @Когда("получить из списка последнего эпизода последнего персонажа")
    public void lastCharacter() {
        lastCharacterLastEpisode = goToLastEpisodeMorty.jsonPath().getString("characters[-1]");
        infoLastCharacterLastEpisode = getApi(lastCharacterLastEpisode, "", 200);
    }
    @Когда("запомнить локацию и расу последнего персонажа")
    public void memorizeNewCharacter() {
        locationLastCharacter = infoLastCharacterLastEpisode.jsonPath().getString("location.name");
        speciesLastCharacter = infoLastCharacterLastEpisode.jsonPath().getString("species");
    }
    @Тогда("Сравнить локации и расу Морти Смита и последнего персанажа")
    public void compareCharacter() {
        Assertions.assertNotEquals(locationMorty, locationLastCharacter);
        Assertions.assertEquals(speciesMorty, speciesLastCharacter);
    }
}
