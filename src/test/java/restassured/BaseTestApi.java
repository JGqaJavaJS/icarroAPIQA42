package restassured;

import dto.UserDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.util.Random;

import static io.restassured.RestAssured.given;


public class BaseTestApi {

    UserDTO user = UserDTO.builder()
            .username("testqa20@gmail.com")
            .password("123456Aa$")
            .build();

    String token = "";

    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void preconditions() {
        RestAssured.baseURI = "https://ilcarro-backend.herokuapp.com";
        token = requestLogin(user).then().extract().path("accessToken");
    }

    public Response requestLogin(UserDTO methodUser) {
        return given()
                .body(methodUser)
               // .contentType(ContentType.JSON)
                .when()
                .post("/v1/user/login/usernamepassword")
                .thenReturn();
    }

    public String extractRandomSerNumber() {
        Random random = new Random();
        int number = random.nextInt(10000, 99999);
        return "1234567" + number;
    }
}
