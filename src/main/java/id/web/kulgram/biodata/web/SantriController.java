package id.web.kulgram.biodata.web;

import id.web.kulgram.biodata.dao.SantriAPI;
import id.web.kulgram.biodata.dao.SantriDAO;
import id.web.kulgram.biodata.model.Santri;
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

@Controller
public class SantriController {

    private BaseUrl baseUrl;

    @Autowired
    private SantriDAO santriDAO;

    @GetMapping("/santri")
    public String index(Model model) {
        model.addAttribute("datas", santriDAO.findAll());
        return "santri";
    }

    @GetMapping("/santri/retrofit")
    public String retrofit(Santri santri) throws IOException {
        LoginPedatren loginPedatren = new LoginPedatren();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SantriAPI santriAPI = retrofit.create(SantriAPI.class);
        Call<List<SantriRetrofit>> santriRetrofit = santriAPI.getSantri(loginPedatren.login());
        santriRetrofit.enqueue(new Callback<List<SantriRetrofit>>() {
            @Override
            public void onResponse(Call<List<SantriRetrofit>> call, Response<List<SantriRetrofit>> response) {
                try {
                    santriDAO.deleteAll();
                    int total = response.body().size();
                    for(int i = 0; i < total; i++) {
                        String niup = response.body().get(i).getWargaRetrofit().getNiup();
                        String namaLengkap = response.body().get(i).getNamaLengkap();
                        String jenisKelamin = response.body().get(i).getJenisKelamin();
                        String wilayah = response.body().get(i).getDomisiliRetrofit().getWilayah();
                        Object pendidikan = response.body().get(i).getPendidikanRetrofit();

                        santri.setId((long) 0);
                        if(niup != null) {
                            santri.setNiup(niup);
                        } else {
                            santri.setNiup("0");
                        }

                        if(namaLengkap != null) {
                            santri.setNamaLengkap(namaLengkap);
                        } else {
                            santri.setNamaLengkap("0");
                        }

                        if(jenisKelamin != null) {
                            santri.setJenisKelamin(jenisKelamin);
                        } else {
                            santri.setJenisKelamin("0");
                        }

                        if(wilayah != null) {
                            santri.setWilayah(wilayah);
                        } else {
                            santri.setWilayah("0");
                        }

                        if(pendidikan != null) {
                            String lembaga = response.body().get(i).getPendidikanRetrofit().getLembaga();
                            String jurusan = response.body().get(i).getPendidikanRetrofit().getJurusan();
                            String kelas = response.body().get(i).getPendidikanRetrofit().getKelas();
                            String rombel = response.body().get(i).getPendidikanRetrofit().getRombel();
                            String tanggal = response.body().get(i).getPendidikanRetrofit().getTanggalMulai();

                            if(lembaga != null) {
                                santri.setLembaga(lembaga);
                            } else {
                                santri.setLembaga("0");
                            }

                            if(jurusan != null) {
                                santri.setJurusan(jurusan);
                            } else {
                                santri.setJurusan("0");
                            }

                            if(kelas != null) {
                                santri.setKelas(kelas);
                            } else {
                                santri.setKelas("0");
                            }

                            if(rombel != null) {
                                santri.setRombel(rombel);
                            } else {
                                santri.setRombel("0");
                            }

                            if(tanggal != null) {
                                santri.setTanggalMulai(tanggal);
                            } else {
                                santri.setTanggalMulai("0");
                            }
                        }
                        santriDAO.save(santri);
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
        return "redirect:/santri";
    }
}
