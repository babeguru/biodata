package id.web.kulgram.biodata.dao;

import id.web.kulgram.biodata.model.SantriRetrofit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.util.List;

public interface SantriAPI {

    @GET("santri")
    Call<List<SantriRetrofit>> getSantri(@Header("x-token") String token);
}
