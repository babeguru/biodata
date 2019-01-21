package id.web.kulgram.biodata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Biodata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namaLengkap;
    private String namaPengguna;
    private String kataKunci;
    private String jenisKelamin;
    private String daerah;
    private String fotoPengguna;

    public Biodata() {
    }

    public Biodata(Long id, String namaLengkap, String namaPengguna, String kataKunci, String jenisKelamin, String daerah, String fotoPengguna) {
        this.id = id;
        this.namaLengkap = namaLengkap;
        this.namaPengguna = namaPengguna;
        this.kataKunci = kataKunci;
        this.jenisKelamin = jenisKelamin;
        this.daerah = daerah;
        this.fotoPengguna = fotoPengguna;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
    }

    public String getKataKunci() {
        return kataKunci;
    }

    public void setKataKunci(String kataKunci) {
        this.kataKunci = kataKunci;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public String getFotoPengguna() {
        return fotoPengguna;
    }

    public void setFotoPengguna(String fotoPengguna) {
        this.fotoPengguna = fotoPengguna;
    }
}
