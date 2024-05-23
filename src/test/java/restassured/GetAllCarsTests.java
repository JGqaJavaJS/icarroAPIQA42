package restassured;

import dto.AllCarsDTO;
import dto.CarDTO;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetAllCarsTests extends BaseTestApi{

    @Test
    public void getAllCarsPositive() {
        AllCarsDTO allCarsDTO = RestAssured.given()
                .header("Authorization", token)
                .when()
                .get("/v1/cars/my")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().as(AllCarsDTO.class);

        System.out.println(allCarsDTO.getCars()
                .get(0).toString());

        for(CarDTO car : allCarsDTO.getCars()) {
            System.out.println(car.getSerialNumber());
        }

    }
}
