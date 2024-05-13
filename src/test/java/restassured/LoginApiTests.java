package restassured;

import dto.UserDTO;
import org.testng.annotations.Test;

public class LoginApiTests {

    // TODO - show changes
    @Test
    public void positiveLoginTest() {
        UserDTO user = UserDTO.builder()
                .username("testqa20@gmail.com")
                .password("123456Aa$")
                .build();
    }
}
