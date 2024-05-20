package restassured;

import dto.CarDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddNewCarTests extends BaseTestApi{

    @Test
    public void addNewCarPositive() {
        String serNumber = extractRandomSerNumber();
        CarDTO car = CarDTO.builder()
                .serialNumber(serNumber)
                .manufacture("opel")
                .model("prius")
                .year("2005")
                .fuel("Gas")
                .seats(2)
                .carClass("99")
                .pricePerDay(2.99)
                .about("oiiii")
                .city("Tel Aviv")
                .build();

        given()
                .header("Authorization", token)
                .body(car)
                .contentType(ContentType.JSON)
                .when()
                .post("/v1/cars")
                .then()
                .assertThat()
                .statusCode(200);
    }

}
