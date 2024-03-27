package steps;

import io.restassured.response.Response;
import org.json.JSONObject;

public class TestBase extends RestSteps {
    public static Response characterInfo;
    public static int mortyId;
    public static Response infoMorty;
    public static  String locationMorty;
    public static String speciesMorty;
    public static String lastEpisodeMorty;
    public static Response goToLastEpisodeMorty;
    public static String lastCharacterLastEpisode;
    public static Response infoLastCharacterLastEpisode;
    public static String locationLastCharacter;
    public static String speciesLastCharacter;
    public static JSONObject body;
    public static Response response;
}
