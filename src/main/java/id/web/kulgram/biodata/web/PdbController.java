package id.web.kulgram.biodata.web;

import id.web.kulgram.biodata.dao.PdbDAO;
import id.web.kulgram.biodata.dao.PdbSchemaDAO;
import id.web.kulgram.biodata.dao.UserDAO;
import id.web.kulgram.biodata.model.Pdb;
import id.web.kulgram.biodata.model.PdbSchema;
import id.web.kulgram.biodata.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
public class PdbController {

    @Autowired
    private PdbDAO pdbDAO;

    @Autowired
    private PdbSchemaDAO pdbSchemaDAO;

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/pdb")
    public String index(Model model) {
        return "pdb";
    }

    @PostMapping("/pdb/add")
    public String add(@Valid Pdb pdb, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            String fileName = file.getOriginalFilename();
            String path = "/Applications/XAMPP/htdocs/upload/biodata/" + fileName;
            saveFile(file.getInputStream(), path);
            pdb.setBuktiKelulusan(fileName);
            pdbDAO.save(pdb);
            return "redirect:/pdb";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private void saveFile(InputStream inputStream, String path) {
        try {
            OutputStream outputStream = new FileOutputStream(new File(path));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/pdb/first")
    public String pdbFirst(Model model) {
        return "pdb-1";
    }

    @PostMapping("/pdb/first/action")
    public String pdbFirstAction(Model model, PdbSchema pdbSchema) {
        pdbSchema.setNamaLengkap(pdbSchema.getNamaLengkap());
        pdbSchema.setJenisKelamin(pdbSchema.getJenisKelamin());
        pdbSchema.setAlamat(pdbSchema.getAlamat());
        pdbSchema.setNamaSekolah("0");
        pdbSchema.setBuktiKelulusan("0");
        pdbSchema.setAsrama("0");
        pdbSchema.setWilayah("0");
        pdbSchema.setJenjangPendidikan("0");
        pdbSchema.setNamaLembaga("0");
        pdbSchema.setJurusan("0");
        pdbSchemaDAO.save(pdbSchema);
        return "redirect:/pdb/second/"+pdbSchema.getId();
    }

    @GetMapping("/pdb/second/{id}")
    public String pdbSecond(Model model, @PathVariable("id") Long id) {
        model.addAttribute("pdbid", id);
        return "pdb-2";
    }

    @PostMapping("/pdb/second/action/{id}")
    public String pdbSecondAction(Model model, PdbSchema pdbSchema, @PathVariable("id") Long id, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            String fileName = file.getOriginalFilename();
            String path = "/Applications/XAMPP/htdocs/upload/biodata/" + fileName;
            saveFile(file.getInputStream(), path);
            Optional<PdbSchema> schema = pdbSchemaDAO.findById(id);
            pdbSchema.setId(id);
            pdbSchema.setNamaLengkap(schema.get().getNamaLengkap());
            pdbSchema.setJenisKelamin(schema.get().getJenisKelamin());
            pdbSchema.setAlamat(schema.get().getAlamat());
            pdbSchema.setNamaSekolah(pdbSchema.getNamaSekolah());
            pdbSchema.setBuktiKelulusan(fileName);
            pdbSchema.setAsrama("0");
            pdbSchema.setWilayah("0");
            pdbSchema.setJenjangPendidikan("0");
            pdbSchema.setNamaLembaga("0");
            pdbSchema.setJurusan("0");
            pdbSchemaDAO.save(pdbSchema);
            return "redirect:/pdb/third/"+pdbSchema.getId();
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @GetMapping("/pdb/third/{id}")
    public String pdbThird(Model model, @PathVariable("id") Long id) {
        model.addAttribute("pdbid", id);
        return "pdb-3";
    }

    @PostMapping("/pdb/third/action/{id}")
    public String pdbThirdAction(Model model, PdbSchema pdbSchema, @PathVariable("id") Long id) {
        Optional<PdbSchema> schema = pdbSchemaDAO.findById(id);
        pdbSchema.setId(id);
        pdbSchema.setNamaLengkap(schema.get().getNamaLengkap());
        pdbSchema.setJenisKelamin(schema.get().getJenisKelamin());
        pdbSchema.setAlamat(schema.get().getAlamat());
        pdbSchema.setNamaSekolah(schema.get().getNamaSekolah());
        pdbSchema.setBuktiKelulusan(schema.get().getBuktiKelulusan());
        pdbSchema.setAsrama(pdbSchema.getAsrama());
        pdbSchema.setWilayah(pdbSchema.getWilayah());
        pdbSchema.setJenjangPendidikan("0");
        pdbSchema.setNamaLembaga("0");
        pdbSchema.setJurusan("0");
        pdbSchemaDAO.save(pdbSchema);
        return "redirect:/pdb/fourth/"+pdbSchema.getId();
    }

    @GetMapping("/pdb/fourth/{id}")
    public String pdbFourth(Model model, @PathVariable("id") Long id) {
        model.addAttribute("pdbid", id);
        return "pdb-4";
    }

    @PostMapping("/pdb/fourth/action/{id}")
    public String pdbFourthAction(Model model, PdbSchema pdbSchema, @PathVariable("id") Long id) {
        Optional<PdbSchema> schema = pdbSchemaDAO.findById(id);
        pdbSchema.setId(id);
        pdbSchema.setNamaLengkap(schema.get().getNamaLengkap());
        pdbSchema.setJenisKelamin(schema.get().getJenisKelamin());
        pdbSchema.setAlamat(schema.get().getAlamat());
        pdbSchema.setNamaSekolah(schema.get().getNamaSekolah());
        pdbSchema.setBuktiKelulusan(schema.get().getBuktiKelulusan());
        pdbSchema.setAsrama(schema.get().getAsrama());
        pdbSchema.setWilayah(schema.get().getWilayah());
        pdbSchema.setJenjangPendidikan(pdbSchema.getJenjangPendidikan());
        pdbSchema.setNamaLembaga(pdbSchema.getNamaLembaga());
        pdbSchema.setJurusan(pdbSchema.getJurusan());
        pdbSchemaDAO.save(pdbSchema);
        return "redirect:/pdb/fifth/"+pdbSchema.getId();
    }

    @GetMapping("/pdb/fifth/{id}")
    public String pdbFifth(Model model, @PathVariable("id") Long id) {
        model.addAttribute("pdbid", id);
        return "pdb-5";
    }

    @PostMapping("/pdb/fifth/action/{id}")
    public String pdbFifthAction(Model model, Pdb pdb, User user, @PathVariable("id") Long id) {
        Optional<PdbSchema> schema = pdbSchemaDAO.findById(id);
        pdb.setNamaLengkap(schema.get().getNamaLengkap());
        pdb.setJenisKelamin(schema.get().getJenisKelamin());
        pdb.setAlamat(schema.get().getAlamat());
        pdb.setNamaSekolah(schema.get().getNamaSekolah());
        pdb.setBuktiKelulusan(schema.get().getBuktiKelulusan());
        pdb.setAsrama(schema.get().getAsrama());
        pdb.setWilayah(schema.get().getWilayah());
        pdb.setJenjangPendidikan(schema.get().getJenjangPendidikan());
        pdb.setNamaLembaga(schema.get().getNamaLembaga());
        pdb.setJurusan(schema.get().getJurusan());
        DateFormat nowFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        String virtualAccount = "800119" + nowFormat.format(date);
        pdb.setVirtualAccount(virtualAccount);
        Pdb newPdb = pdbDAO.save(pdb);
        Long pdbid = newPdb.getId();;

        user.setPdbId(pdbid);
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        userDAO.save(user);
        return "redirect:/pdb/completed/"+pdbid;
    }

    @GetMapping("/pdb/completed/{id}")
    public String pdbCompleted(Model model, @PathVariable("id") Long id) {
        Optional<Pdb> pdb = pdbDAO.findById(id);
        model.addAttribute("virtualAccount", pdb.get().getVirtualAccount());
        return "pdb-6";
    }
}
