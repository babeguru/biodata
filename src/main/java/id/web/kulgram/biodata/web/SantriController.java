package id.web.kulgram.biodata.web;

import id.web.kulgram.biodata.dao.SantriAPI;
//import id.web.kulgram.biodata.dao.SantriDAO;
//import id.web.kulgram.biodata.model.Santri;
import id.web.kulgram.biodata.model.SantriRetrofit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@RestController
public class SantriController {

    private BaseUrl baseUrl;

//    @Autowired
//    private SantriDAO santriDAO;

    @GetMapping("/santri")
    public String index(Model model) {
//        model.addAttribute("datas", santriDAO.findAll());
        return "santri";
    }

    @GetMapping("/santri/retrofit")
    public String retrofit() throws IOException {
        LoginPedatren loginPedatren = new LoginPedatren();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SantriAPI santriAPI = retrofit.create(SantriAPI.class);
        Call<List<SantriRetrofit>> santriRetrofit = santriAPI.getSantri();
        santriRetrofit.enqueue(new Callback<List<SantriRetrofit>>() {
            @Override
            public void onResponse(Call<List<SantriRetrofit>> call, Response<List<SantriRetrofit>> response) {
                try {
//                    santriDAO.deleteAll();
                    int total = response.body().size();
                    for(int i = 0; i < total; i++) {
                        System.out.println(response.body().get(i).getWargaRetrofit().getNiup());
                        System.out.println(response.body().get(i).getNamaLengkap());
                        System.out.println(response.body().get(i).getJenisKelamin());
                        System.out.println(response.body().get(i).getDomisiliRetrofit().getWilayah());
                        System.out.println(response.body().get(i).getPendidikanRetrofit().getLembaga());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<SantriRetrofit>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return "oke";
    }
}
