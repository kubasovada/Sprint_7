import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CourierClient {
    public static final String BASE_URI = "http://qa-scooter.praktikum-services.ru";
    public static final String COURIER_PATH = "/api/v1/courier";

    public ValidatableResponse createCourier(Courier courier) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(courier)
                .when()
                .post(COURIER_PATH) // CREATE
                .then().log().all();
    }
}
