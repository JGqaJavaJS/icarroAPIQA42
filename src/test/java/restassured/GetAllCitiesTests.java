package restassured;

import dto.CitiesDTO;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetAllCitiesTests extends BaseTestApi{

    @Test
    public void getAllCitiesPositiveTest() {
        CitiesDTO allCities = RestAssured.given()
                .when()
                .get("/v1/cars/cities")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().as(CitiesDTO.class);

        System.out.println(allCities
                .getCities()
                .get(3)
                .getCity()
        );
    }
}
