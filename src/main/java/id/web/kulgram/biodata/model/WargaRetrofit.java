package id.web.kulgram.biodata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WargaRetrofit {

    @SerializedName("niup")
    @Expose
    private String niup;

    public String getNiup() {
        return niup;
    }

    public void setNiup(String niup) {
        this.niup = niup;
    }
}
