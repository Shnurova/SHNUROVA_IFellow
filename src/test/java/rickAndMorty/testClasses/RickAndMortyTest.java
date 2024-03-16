package rickAndMorty.testClasses;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class RickAndMortyTest {
    @Test
    public void matchMortyInfoTest() {
        Response characterInfo = new BaseTest()
                .getApi("https://rickandmortyapi.com/api/character/?name=morty+smith&status=alive", 200);
        int mortyId = characterInfo.jsonPath().get("results.find{it.name == 'Morty Smith'}.id");
        System.out.println(mortyId);
       Response infoMorty = new BaseTest()
               .getApi("https://rickandmortyapi.com/api/character/"+ mortyId, 200);



    }
}
