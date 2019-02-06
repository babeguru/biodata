package id.web.kulgram.biodata.web;

import id.web.kulgram.biodata.dao.BiodataDAO;
import id.web.kulgram.biodata.model.Biodata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.*;

@Controller
@RequestMapping("/")
public class BerandaController {

    @Autowired
    private BiodataDAO biodataDAO;

    @GetMapping
    public String beranda(Biodata biodata, Model model) {
        return "index";
    }

    @PostMapping("/add")
    public String add(@Valid Biodata biodata, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            String fileName = file.getOriginalFilename();
            String path = "/Applications/XAMPP/htdocs/upload/biodata/" + fileName;
            saveFile(file.getInputStream(), path);
            biodata.setFotoPengguna(fileName);
            biodataDAO.save(biodata);
            return "redirect:/";
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

}
