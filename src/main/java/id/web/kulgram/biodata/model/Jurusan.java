package id.web.kulgram.biodata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jurusan {

    @Id
    private Long idJurusan;
    private String namaJurusan;
    private String idLembaga;
    private String lembaga;

    public Jurusan() {
    }

    public Jurusan(Long idJurusan, String namaJurusan, String idLembaga, String lembaga) {
        this.idJurusan = idJurusan;
        this.namaJurusan = namaJurusan;
        this.idLembaga = idLembaga;
        this.lembaga = lembaga;
    }

    public Long getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(Long idJurusan) {
        this.idJurusan = idJurusan;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
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
