package id.web.kulgram.biodata.dao;

import id.web.kulgram.biodata.model.KelasRetrofit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.util.List;

public interface KelasAPI {

    @GET("setting/lembaga/kelas")
    Call<List<KelasRetrofit>> getKelas(@Header("x-token") String token);
}
