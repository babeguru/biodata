package id.web.kulgram.biodata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lembaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLembaga;
    private String kodeLembaga;
    private String namaLembaga;
    private String alias;

    public Lembaga() {
    }

    public Lembaga(Long idLembaga, String kodeLembaga, String namaLembaga, String alias) {
        this.idLembaga = idLembaga;
        this.kodeLembaga = kodeLembaga;
        this.namaLembaga = namaLembaga;
        this.alias = alias;
    }

    public Long getIdLembaga() {
        return idLembaga;
    }

    public void setIdLembaga(Long idLembaga) {
        this.idLembaga = idLembaga;
    }

    public String getKodeLembaga() {
        return kodeLembaga;
    }

    public void setKodeLembaga(String kodeLembaga) {
        this.kodeLembaga = kodeLembaga;
    }

    public String getNamaLembaga() {
        return namaLembaga;
    }

    public void setNamaLembaga(String namaLembaga) {
        this.namaLembaga = namaLembaga;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
