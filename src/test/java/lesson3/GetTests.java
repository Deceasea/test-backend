package lesson3;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class GetTests extends AbstractTest {
    @Test
    void getRec1() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("instructionsRequired", "false")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }
    @Test
    void getRec2() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("excludeCuisine", "greek")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }
    @Test
    void getRec3() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("includeIngredients", "cheese")
                .queryParam("number", "10")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }
    @Test
    void getRec4() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("equipment", "pan")
                .queryParam("query", "pizza")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }
    @Test
    void getTime() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("offset", "0")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }
}