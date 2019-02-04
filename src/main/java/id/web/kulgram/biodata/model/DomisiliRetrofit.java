package id.web.kulgram.biodata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DomisiliRetrofit {

    @SerializedName("wilayah")
    @Expose
    private String wilayah;

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }
}
