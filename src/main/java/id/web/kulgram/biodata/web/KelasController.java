package id.web.kulgram.biodata.web;

import id.web.kulgram.biodata.dao.KelasAPI;
import id.web.kulgram.biodata.dao.KelasDAO;
import id.web.kulgram.biodata.model.Kelas;
import id.web.kulgram.biodata.model.KelasRetrofit;
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
public class KelasController {

    private BaseUrl baseUrl;

    @Autowired
    private KelasDAO kelasDAO;

    @GetMapping("/kelas")
    public String index(Model model) {
        model.addAttribute("datas", kelasDAO.findAll());
        return "kelas";
    }

    @GetMapping("/kelas/retrofit")
    public String retrofit(Kelas kelas) throws IOException {
        LoginPedatren loginPedatren = new LoginPedatren();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        KelasAPI kelasAPI = retrofit.create(KelasAPI.class);
        Call<List<KelasRetrofit>> kelasRetrofit = kelasAPI.getKelas(loginPedatren.login());
        kelasRetrofit.enqueue(new Callback<List<KelasRetrofit>>() {
            @Override
            public void onResponse(Call<List<KelasRetrofit>> call, Response<List<KelasRetrofit>> response) {
                try {
                    kelasDAO.deleteAll();
                    int total = response.body().size();
                    for(int i = 0; i < total; i++) {
                        kelas.setIdKelas(response.body().get(i).getId());
                        kelas.setNamaKelas(response.body().get(i).getNama());
                        kelas.setIdLembaga(response.body().get(i).getIdLembaga());
                        kelas.setLembaga(response.body().get(i).getLembaga());
                        kelasDAO.save(kelas);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<KelasRetrofit>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return "redirect:/kelas";
    }
}
