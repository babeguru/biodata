package id.web.kulgram.biodata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WilayahRetrofit {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("jenis")
    @Expose
    private String jenis;

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
