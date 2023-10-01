import org.apache.commons.lang.RandomStringUtils;

import java.time.LocalDateTime;

public class CourierGenerator {
    public static Courier genericCourier() {
            return new Courier("ninja!0qw", "123", "whois");
    }

    public static Courier random() {
        //return new Courier("Marvin" + LocalDateTime.now(), "123", "Marvin");
        return new Courier("Test" + RandomStringUtils.randomAlphanumeric(5), "123", "Marvin");
    }
}
