package id.web.kulgram.biodata.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wilayah {

    @Id
    private Long idWilayah;
    private String namaWilayah;
    private String alias;
    private String jenis;

    public Wilayah() {}

    public Wilayah(Long idWilayah, String namaWilayah, String alias, String jenis) {
        this.idWilayah = idWilayah;
        this.namaWilayah = namaWilayah;
        this.alias = alias;
        this.jenis = jenis;
    }

    public Long getIdWilayah() {
        return idWilayah;
    }

    public void setIdWilayah(Long idWilayah) {
        this.idWilayah = idWilayah;
    }

    public String getNamaWilayah() {
        return namaWilayah;
    }

    public void setNamaWilayah(String namaWilayah) {
        this.namaWilayah = namaWilayah;
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
