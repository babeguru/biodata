package id.web.kulgram.biodata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JurusanRetrofit {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("id_lembaga")
    @Expose
    private String idLembaga;
    @SerializedName("lembaga")
    @Expose
    private String lembaga;

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

    public String getIdLembaga() {
        return idLembaga;
    }

    public void setIdLembaga(String idLembaga) {
        this.idLembaga = idLembaga;
    }

    public String getLembaga() {
        return lembaga;
    }

    public void setLembaga(String lembaga) {
        this.lembaga = lembaga;
    }
}
