package id.web.kulgram.biodata.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rombel {

    @Id
    private Long idRombel;
    private String namaRombel;
    private int idKelas;
    private String kelas;

    public Rombel() {
    }

    public Rombel(Long idRombel, String namaRombel, int idKelas, String kelas) {
        this.idRombel = idRombel;
        this.namaRombel = namaRombel;
        this.idKelas = idKelas;
        this.kelas = kelas;
    }

    public Long getIdRombel() {
        return idRombel;
    }

    public void setIdRombel(Long idRombel) {
        this.idRombel = idRombel;
    }

    public String getNamaRombel() {
        return namaRombel;
    }

    public void setNamaRombel(String namaRombel) {
        this.namaRombel = namaRombel;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
