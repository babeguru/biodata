package id.web.kulgram.biodata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Santri {

    @Id
    @GeneratedValue
    private Long id;
    private String niup;
    private String namaLengkap;
    private String jenisKelamin;
    private String wilayah;
    private String lembaga;
    private String jurusan;
    private String kelas;
    private String rombel;
    private String tanggalMulai;

    public Santri() {
    }

    public Santri(Long id, String niup, String namaLengkap, String jenisKelamin, String wilayah, String lembaga, String jurusan, String kelas, String rombel, String tanggalMulai) {
        this.id = id;
        this.niup = niup;
        this.namaLengkap = namaLengkap;
        this.jenisKelamin = jenisKelamin;
        this.wilayah = wilayah;
        this.lembaga = lembaga;
        this.jurusan = jurusan;
        this.kelas = kelas;
        this.rombel = rombel;
        this.tanggalMulai = tanggalMulai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNiup() {
        return niup;
    }

    public void setNiup(String niup) {
        this.niup = niup;
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

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

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
