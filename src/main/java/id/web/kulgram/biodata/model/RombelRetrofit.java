package id.web.kulgram.biodata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RombelRetrofit {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("id_kelas")
    @Expose
    private int idKelas;
    @SerializedName("kelas")
    @Expose
    private String kelas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
