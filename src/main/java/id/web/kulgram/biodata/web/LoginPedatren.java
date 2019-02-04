package id.web.kulgram.biodata.web;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

public class LoginPedatren {

    public String login() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(BaseUrl.baseURL+"auth/login")
                .get()
                .header("Authorization", Credentials.basic("admin", "admin"))
                .build();

        Response response = client.newCall(request).execute();
        return response.header("x-token");
    }
}
