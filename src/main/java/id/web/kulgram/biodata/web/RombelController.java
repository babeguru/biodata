package id.web.kulgram.biodata.web;

import id.web.kulgram.biodata.dao.RombelAPI;
import id.web.kulgram.biodata.dao.RombelDAO;
import id.web.kulgram.biodata.model.Rombel;
import id.web.kulgram.biodata.model.RombelRetrofit;
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
public class RombelController {

    private BaseUrl baseUrl;

    @Autowired
    private RombelDAO rombelDAO;

    @GetMapping("/rombel")
    public String index(Model model) {
        model.addAttribute("datas", rombelDAO.findAll());
        return "rombel";
    }

    @GetMapping("/rombel/retrofit")
    public String retrofit(Rombel rombel) throws IOException {
        LoginPedatren loginPedatren = new LoginPedatren();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RombelAPI rombelAPI = retrofit.create(RombelAPI.class);
        Call<List<RombelRetrofit>> rombelRetrofit = rombelAPI.getRombel();
        rombelRetrofit.enqueue(new Callback<List<RombelRetrofit>>() {
            @Override
            public void onResponse(Call<List<RombelRetrofit>> call, Response<List<RombelRetrofit>> response) {
                try {
                    rombelDAO.deleteAll();
                    int total = response.body().size();
                    for(int i = 0; i < total; i++) {
                        rombel.setIdRombel(response.body().get(i).getId());
                        rombel.setNamaRombel(response.body().get(i).getNama());
                        rombel.setIdKelas(response.body().get(i).getIdKelas());
                        rombel.setKelas(response.body().get(i).getKelas());
                        rombelDAO.save(rombel);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<RombelRetrofit>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return "redirect:/rombel";
    }
}
