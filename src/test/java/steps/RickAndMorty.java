package steps;

import io.cucumber.java.Before;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class RickAndMorty extends TestBase {

    @Before
    public void initFilters() {
        RestAssured.filters(new AllureRestAssured());
    }

    @Когда("запросить информацию по персонажам Морти в сериале \"Рик и Морти\"")
    public void characterInfo() {
        characterInfo = getApi("https://rickandmortyapi.com/api/", "character/?name=morty smith&status=alive", 200);
    }
    @Когда("найти персонажа Морти Смита")
    public void locateMorty() {
        mortyId = characterInfo.jsonPath().get("results[0].id");
        infoMorty = getApi("https://rickandmortyapi.com/api/", "character/" + mortyId, 200);
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
    @Тогда("Сравнирть локации и расу Морти Смита и последнего персанажа")
    public void compareCharacter() {
        Assertions.assertNotEquals(locationMorty, locationLastCharacter);
        Assertions.assertEquals(speciesMorty, speciesLastCharacter);
    }
}
