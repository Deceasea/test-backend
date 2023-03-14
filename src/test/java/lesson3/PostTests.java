package lesson3;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostTests extends AbstractTest {
    @Test
    void getResponseData() {
        Response response = given()
                .when()
                .get(getBaseUrl() + "recipes/cuisine" +
                        "includeNutrition=false&apiKey=" + getApiKey());

        System.out.println("StatusLine: " + response.getStatusLine());
        System.out.println("Code: " + response.getStatusCode());
    }

    @Test
    void addMealTest() {
        String id = given()
                .queryParam("hash", "4b5v4398573406")
                .queryParam("apiKey", getApiKey())
                .body("{\n"
                        + " \"date\": 1589500800,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 banana\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .when()
                .post(getBaseUrl()+"mealplanner/dsky/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();
    }

    @Test
    void getTypeCuisine1() {
        String cuisine = given()
                .queryParam("apiKey", getApiKey())
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .path("Mediterranean");

        System.out.println("cuisine: " + cuisine);

    }

    @Test
    void getTypeCuisine2() {
        String cuisine = given()
                .queryParam("apiKey", getApiKey())
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .path("European");

    }

    @Test
    void getConf() {
        String confidence = given()
                .queryParam("apiKey", getApiKey())
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then().extract()
                .jsonPath()
                .get("confidence")
                .toString();

    }
    @Test
    void getTypeCuisine3() {
        String cuisine = given()
                .queryParam("apiKey", getApiKey())
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .path("Italian");
    }
}
