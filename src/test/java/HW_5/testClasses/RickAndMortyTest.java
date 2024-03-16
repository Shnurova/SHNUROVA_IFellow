package HW_5.testClasses;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import HW_5.steps.RestSteps;


public class RickAndMortyTest extends RestSteps {
    @Test
    public void matchMortyInfoTest() {
        Response characterInfo = getApi("https://rickandmortyapi.com/api/", "character/?name=morty smith&status=alive", 200);
        int mortyId = characterInfo.jsonPath().get("results[0].id");

        Response infoMorty = getApi("https://rickandmortyapi.com/api/", "character/" + mortyId, 200);
        String locationMorty = infoMorty.jsonPath().getString("location.name");
        String speciesMorty = infoMorty.jsonPath().getString("species");
        String lastEpisodeMorty = infoMorty.jsonPath().getString("episode[-1]");

        Response goToLastEpisodeMorty = getApi(lastEpisodeMorty, "", 200);
        String lastCharacterLastEpisode = goToLastEpisodeMorty.jsonPath().getString("characters[-1]");

        Response infoLastCharacterLastEpisode = getApi(lastCharacterLastEpisode, "", 200);
        String locationLastCharacter = infoLastCharacterLastEpisode.jsonPath().getString("location.name");
        String speciesLastCharacter = infoLastCharacterLastEpisode.jsonPath().getString("species");

        Assertions.assertNotEquals(locationMorty, locationLastCharacter);
        Assertions.assertEquals(speciesMorty, speciesLastCharacter);
    }
}
