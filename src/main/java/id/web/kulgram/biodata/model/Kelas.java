package id.web.kulgram.biodata.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Kelas {

    @Id
    private Long idKelas;
    private String namaKelas;
    private String idLembaga;
    private String lembaga;

    public Kelas() {
    }

    public Kelas(Long idKelas, String namaKelas, String idLembaga, String lembaga) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.idLembaga = idLembaga;
        this.lembaga = lembaga;
    }

    public Long getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(Long idKelas) {
        this.idKelas = idKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
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
