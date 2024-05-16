package restassured;

import dto.UserDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

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
                .when()
                .post("/v1/user/login/usernamepassword")
                .thenReturn();
    }

}
