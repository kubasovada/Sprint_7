import io.restassured.response.ValidatableResponse;

import java.util.Map;

public class CourierClient extends Client {

    static final String COURIER_PATH = "/courier";

    public ValidatableResponse login(Credentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(COURIER_PATH + "/login") // LOGIN
                .then().log().all();
    }

    public ValidatableResponse createCourier(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH) // CREATE
                .then().log().all();
    }

    public ValidatableResponse delete(int courierId) {
        return spec()
                .body(Map.of("id", courierId))
                .when()
                .delete(COURIER_PATH + "/" + courierId) // DELETE
                .then().log().all();
    }
}
