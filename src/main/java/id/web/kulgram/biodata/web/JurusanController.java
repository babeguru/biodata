package id.web.kulgram.biodata.web;

import id.web.kulgram.biodata.dao.JurusanAPI;
import id.web.kulgram.biodata.dao.JurusanDAO;
import id.web.kulgram.biodata.model.Jurusan;
import id.web.kulgram.biodata.model.JurusanRetrofit;
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
public class JurusanController {

    private BaseUrl baseUrl;

    @Autowired
    private JurusanDAO jurusanDAO;

    @GetMapping("/jurusan")
    public String index(Model model) {
        model.addAttribute("datas", jurusanDAO.findAll());
        return "jurusan";
    }

    @GetMapping("/jurusan/retrofit")
    public String retrofit(Jurusan jurusan) throws IOException {
        LoginPedatren loginPedatren = new LoginPedatren();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JurusanAPI jurusanAPI = retrofit.create(JurusanAPI.class);
        Call<List<JurusanRetrofit>> jurusanRetrofit = jurusanAPI.getJurusan(loginPedatren.login());
        jurusanRetrofit.enqueue(new Callback<List<JurusanRetrofit>>() {
            @Override
            public void onResponse(Call<List<JurusanRetrofit>> call, Response<List<JurusanRetrofit>> response) {
                try {
                    jurusanDAO.deleteAll();
                    int total = response.body().size();
                    for(int i = 0; i < total; i++) {
                        jurusan.setIdJurusan(response.body().get(i).getId());
                        jurusan.setNamaJurusan(response.body().get(i).getNama());
                        jurusan.setIdLembaga(response.body().get(i).getIdLembaga());
                        jurusan.setLembaga(response.body().get(i).getLembaga());
                        jurusanDAO.save(jurusan);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<JurusanRetrofit>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return "redirect:/jurusan";
    }
}
