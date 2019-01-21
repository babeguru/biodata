package id.web.kulgram.biodata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pdb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namaLengkap;
    private String jenisKelamin;
    private String alamat;
    private String namaSekolah;
    private String buktiKelulusan;
    private String asrama;
    private String wilayah;
    private String jenjangPendidikan;
    private String namaLembaga;
    private String jurusan;
    private String virtualAccount;

    public Pdb() {
    }

    public Pdb(Long id, String namaLengkap, String jenisKelamin, String alamat, String namaSekolah, String buktiKelulusan, String asrama, String wilayah, String jenjangPendidikan, String namaLembaga, String jurusan, String virtualAccount) {
        this.id = id;
        this.namaLengkap = namaLengkap;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.namaSekolah = namaSekolah;
        this.buktiKelulusan = buktiKelulusan;
        this.asrama = asrama;
        this.wilayah = wilayah;
        this.jenjangPendidikan = jenjangPendidikan;
        this.namaLembaga = namaLembaga;
        this.jurusan = jurusan;
        this.virtualAccount = virtualAccount;
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

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    public String getBuktiKelulusan() {
        return buktiKelulusan;
    }

    public void setBuktiKelulusan(String buktiKelulusan) {
        this.buktiKelulusan = buktiKelulusan;
    }

    public String getAsrama() {
        return asrama;
    }

    public void setAsrama(String asrama) {
        this.asrama = asrama;
    }

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

    public String getJenjangPendidikan() {
        return jenjangPendidikan;
    }

    public void setJenjangPendidikan(String jenjangPendidikan) {
        this.jenjangPendidikan = jenjangPendidikan;
    }

    public String getNamaLembaga() {
        return namaLembaga;
    }

    public void setNamaLembaga(String namaLembaga) {
        this.namaLembaga = namaLembaga;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }
}
