package id.web.kulgram.biodata.dao;

import id.web.kulgram.biodata.model.JurusanRetrofit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.util.List;

public interface JurusanAPI {

    @GET("setting/lembaga/jurusan")
    Call<List<JurusanRetrofit>> getJurusan(@Header("x-token") String token);
}
