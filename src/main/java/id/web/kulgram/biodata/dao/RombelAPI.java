package id.web.kulgram.biodata.dao;

import id.web.kulgram.biodata.model.RombelRetrofit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.util.List;

public interface RombelAPI {

    @GET("setting/lembaga/rombel")
    Call<List<RombelRetrofit>> getRombel(@Header("x-token") String token);
}
