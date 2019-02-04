package id.web.kulgram.biodata.web;

import id.web.kulgram.biodata.dao.WilayahAPI;
import id.web.kulgram.biodata.dao.WilayahDAO;
import id.web.kulgram.biodata.model.Wilayah;
import id.web.kulgram.biodata.model.WilayahRetrofit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@Controller
public class WilayahController {

    private BaseUrl baseUrl;

    @Autowired
    private WilayahDAO wilayahDAO;

    @GetMapping("/wilayah")
    public String index(Model model) {
        model.addAttribute("datas", wilayahDAO.findAll());
        return "wilayah";
    }

    @GetMapping("/wilayah/retrofit")
    public String retrofit(Wilayah wilayah) throws IOException {
        LoginPedatren loginPedatren = new LoginPedatren();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WilayahAPI wilayahAPI = retrofit.create(WilayahAPI.class);
        Call<List<WilayahRetrofit>> wilayahRetrofit = wilayahAPI.getWilayah();
        wilayahRetrofit.enqueue(new Callback<List<WilayahRetrofit>>() {
            @Override
            public void onResponse(Call<List<WilayahRetrofit>> call, Response<List<WilayahRetrofit>> response) {
                try {
                    wilayahDAO.deleteAll();
                    int total = response.body().size();
                    for(int i = 0; i < total; i++) {
                        wilayah.setIdWilayah(response.body().get(i).getId());
                        wilayah.setNamaWilayah(response.body().get(i).getNama());
                        wilayah.setAlias(response.body().get(i).getAlias());
                        wilayah.setJenis(response.body().get(i).getJenis());
                        wilayahDAO.save(wilayah);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<WilayahRetrofit>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return "redirect:/wilayah";
    }
}
