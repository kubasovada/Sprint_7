import io.restassured.http.ContentType;
import org.junit.Test;

import java.net.HttpURLConnection;

import static io.restassured.RestAssured.given;

public class CourierTest {

    private final CourierClient client = new CourierClient();

    @Test
    public void courier() {
        Courier courier = CourierGenerator.random();
        //File json = new File("src/test/resources/newCard.json");
        boolean created = client.createCourier(courier)
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("ok");

        Credentials creds = Credentials.from(courier);
        int id = given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(CourierClient.BASE_URI)
                .body(creds)
                .when()
                .post(CourierClient.COURIER_PATH + "/login") // LOGIN
                .then().log().all()
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("id");

        assert created;
        assert id != 0;
    }

}
