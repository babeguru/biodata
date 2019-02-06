package id.web.kulgram.biodata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PendidikanRetrofit {

    @SerializedName("lembaga")
    @Expose
    private String lembaga;
    @SerializedName("jurusan")
    @Expose
    private String jurusan;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("rombel")
    @Expose
    private String rombel;
    @SerializedName("tanggal_mulai")
    @Expose
    private String tanggalMulai;

    public String getLembaga() {
        return lembaga;
    }

    public void setLembaga(String lembaga) {
        this.lembaga = lembaga;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getRombel() {
        return rombel;
    }

    public void setRombel(String rombel) {
        this.rombel = rombel;
    }

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }
}
