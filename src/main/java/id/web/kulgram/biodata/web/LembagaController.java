package id.web.kulgram.biodata.web;

import id.web.kulgram.biodata.dao.LembagaAPI;
import id.web.kulgram.biodata.dao.LembagaDAO;
import id.web.kulgram.biodata.model.Lembaga;
import id.web.kulgram.biodata.model.LembagaRetrofit;
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
public class LembagaController {

    private BaseUrl baseUrl;

    @Autowired
    private LembagaDAO lembagaDAO;

    @GetMapping("/lembaga")
    public String index(Model model) {
        model.addAttribute("datas", lembagaDAO.findAll());
        return "lembaga";
    }

    @GetMapping("/lembaga/retrofit")
    public String retrofit(Lembaga lembaga) throws IOException {
        LoginPedatren loginPedatren = new LoginPedatren();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LembagaAPI lembagaAPI = retrofit.create(LembagaAPI.class);
        Call<List<LembagaRetrofit>> lembagaRetrofit = lembagaAPI.getLembaga();
        lembagaRetrofit.enqueue(new Callback<List<LembagaRetrofit>>() {
            @Override
            public void onResponse(Call<List<LembagaRetrofit>> call, Response<List<LembagaRetrofit>> response) {
                try {
                    lembagaDAO.deleteAll();
                    int total = response.body().size();
                    for(int i = 0; i < total; i++) {
                        lembaga.setIdLembaga((long) 0);
                        lembaga.setKodeLembaga(response.body().get(i).getId());
                        lembaga.setNamaLembaga(response.body().get(i).getNama());
                        lembaga.setAlias(response.body().get(i).getAlias());
                        lembagaDAO.save(lembaga);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<LembagaRetrofit>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return "redirect:/lembaga";
    }
}
