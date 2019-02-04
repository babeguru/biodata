package id.web.kulgram.biodata.dao;

import id.web.kulgram.biodata.model.SantriRetrofit;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface SantriAPI {

    @GET("pesertadidik")
    Call<List<SantriRetrofit>> getSantri();
}
