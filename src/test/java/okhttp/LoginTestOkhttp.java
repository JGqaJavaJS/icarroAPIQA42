package okhttp;

import com.google.gson.Gson;
import dto.ErrorDTO;
import dto.UserDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestOkhttp {

    public static final MediaType JSON = MediaType.get("application/json");
    Gson gson = new Gson();
    OkHttpClient okHttpClient = new OkHttpClient();
    public static final String BASE_URI = "https://ilcarro-backend.herokuapp.com";

    @Test
    public void positiveLoginTest() throws IOException {
        UserDTO user = UserDTO.builder()
                .username("testqa20@gmail.com")
                .password("123456Aa$")
                .build();

// create JSON body for request
        RequestBody requestBody = RequestBody.create(gson.toJson(user), JSON);
        // create request
        Request request = new Request.Builder()
                // take uri and add endpoint
                .url(BASE_URI + "/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();
        // send request and get response
        Response response = okHttpClient.newCall(request).execute();

        Assert.assertEquals(response.code(), 200);
        System.out.println("message: " + response.message());
        /*
        response
        - code and status word (OK, unauthorized)
        - body
         */
    }

    @Test
    public void negativeEmailLoginTest() throws IOException {
        UserDTO user = UserDTO.builder()
                .username("testqa@gmail.com")
                .password("123456Aa$")
                .build();

// create JSON body for request
        RequestBody requestBody = RequestBody.create(gson.toJson(user), JSON);
        // create request
        Request request = new Request.Builder()
                // take uri and add endpoint
                .url(BASE_URI + "/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();
        // send request and get response
        Response response = okHttpClient.newCall(request).execute();

        Assert.assertEquals(response.code(), 401);
        System.out.println(response.message());

        ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
        System.out.println(errorDTO.getMessage());
        System.out.println(errorDTO.getError());
        System.out.println(errorDTO.getStatus());
    }
}
