package id.web.kulgram.biodata.web;

import id.web.kulgram.biodata.dao.BiodataDAO;
import id.web.kulgram.biodata.model.Biodata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.validation.Valid;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class BerandaController {

    @Autowired
    private BiodataDAO biodataDAO;

    @GetMapping
    public String beranda() {
        return "index";
    }

}
