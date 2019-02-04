package id.web.kulgram.biodata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SantriRetrofit {

    @SerializedName("warga_pesantren")
    @Expose
    private WargaRetrofit wargaRetrofit;
    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;
    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("domisili_santri")
    @Expose
    private DomisiliRetrofit domisiliRetrofit;
    @SerializedName("pendidikan")
    @Expose
    private PendidikanRetrofit pendidikanRetrofit;

    public WargaRetrofit getWargaRetrofit() {
        return wargaRetrofit;
    }

    public void setWargaRetrofit(WargaRetrofit wargaRetrofit) {
        this.wargaRetrofit = wargaRetrofit;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public DomisiliRetrofit getDomisiliRetrofit() {
        return domisiliRetrofit;
    }

    public void setDomisiliRetrofit(DomisiliRetrofit domisiliRetrofit) {
        this.domisiliRetrofit = domisiliRetrofit;
    }

    public PendidikanRetrofit getPendidikanRetrofit() {
        return pendidikanRetrofit;
    }

    public void setPendidikanRetrofit(PendidikanRetrofit pendidikanRetrofit) {
        this.pendidikanRetrofit = pendidikanRetrofit;
    }
}
