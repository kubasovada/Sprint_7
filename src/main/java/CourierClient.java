import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CourierClient {
    public static final String BASE_URI = "http://qa-scooter.praktikum-services.ru";
    public static final String COURIER_PATH = "/api/v1/courier";

    public ValidatableResponse login(Credentials creds) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(creds)
                .when()
                .post(COURIER_PATH + "/login") // LOGIN
                .then().log().all();
    }

    public ValidatableResponse createCourier(Courier courier) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(courier)
                .when()
                .post(COURIER_PATH) // CREATE
                .then().log().all();
    }

    public ValidatableResponse delete(int courierId) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(Map.of("id", courierId))
                .when()
                .delete(COURIER_PATH + "/" + courierId) // DELETE
                .then().log().all();
    }
}
