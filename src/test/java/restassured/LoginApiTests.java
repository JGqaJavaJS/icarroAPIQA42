package restassured;

import dto.ErrorDTO;
import dto.UserDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginApiTests extends BaseTestApi{

    @Test(priority = 1)
    public void positiveLoginTest() {
        System.out.println("token: " + token);
    }

    @Test(description = "negative login API test with the wrong password and correct email",
    priority = 2)
    public void negativeTestWrongPassword() {
        UserDTO user1 = UserDTO.builder()
                .username("testqa20@gmail.com")
                .password("12356Aa$")
                .build();

        Response response = requestLogin(user1);

        Assert.assertEquals(response.statusCode(), 401);

        ErrorDTO errorDTO = response.getBody().as(ErrorDTO.class);

        softAssert.assertEquals(errorDTO.getError(), "Unauthorized");
        softAssert.assertEquals(errorDTO.getMessage(), "Login or Password incorrect");
        softAssert.assertEquals(errorDTO.getStatus(), 401);
        softAssert.assertAll();
        System.out.println("control");
    }
}
