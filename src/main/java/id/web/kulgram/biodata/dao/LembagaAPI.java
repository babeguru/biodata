package id.web.kulgram.biodata.dao;

import id.web.kulgram.biodata.model.LembagaRetrofit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.util.List;

public interface LembagaAPI {

    @GET("setting/lembaga")
    Call<List<LembagaRetrofit>> getLembaga(@Header("x-token") String token);
}
