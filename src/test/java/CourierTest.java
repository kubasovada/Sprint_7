import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CourierTest {

    private final CourierClient client = new CourierClient();
    private final CourierAssertions check = new CourierAssertions();
    protected int courierId;


    @After
    public void deleteCourier() {
        ValidatableResponse delete = client.delete(courierId);
        check.deletedSuccessfully(delete);

    }


    @Test
    public void courier() {
        Courier courier = CourierGenerator.random();
        ValidatableResponse response = client.createCourier(courier);
        check.createdSuccessfully(response);

        Credentials creds = Credentials.from(courier);
        ValidatableResponse loginResponse = client.login(creds);
        courierId = check.loggedInSuccessfully(loginResponse);

        assert courierId != 0;
    }

}
