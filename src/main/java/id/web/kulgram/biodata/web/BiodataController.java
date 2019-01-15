package id.web.kulgram.biodata.web;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import id.web.kulgram.biodata.dao.BiodataDAO;
import id.web.kulgram.biodata.model.Biodata;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@RestController
public class BiodataController {

    @Autowired
    private BiodataDAO biodataDAO;

    @GetMapping("/biodata/pdf")
    public String biodataPdf() throws FileNotFoundException, DocumentException {
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("biodata.pdf"));

        document.open();

        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        Chunk chunk = new Chunk("Hello World");

        document.add(chunk);

        document.close();

        return "oke";
    }

    @GetMapping("/biodata/xls")
    public String addBiodata(HttpServletResponse response) throws IOException {
        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet("Biodata");

        org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
        headerFont.setBoldweight((short) 10);
        headerFont.setColor(IndexedColors.RED.getIndex());


        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        Cell cell0 = headerRow.createCell(0);
        cell0.setCellValue("ID");
        cell0.setCellStyle(headerCellStyle);

        Cell cell1 = headerRow.createCell(1);
        cell1.setCellValue("NAMA LENGKAP");
        cell1.setCellStyle(headerCellStyle);

        Cell cell2 = headerRow.createCell(2);
        cell2.setCellValue("NAMA PENGGUNA");
        cell2.setCellStyle(headerCellStyle);

        Cell cell3 = headerRow.createCell(3);
        cell3.setCellValue("KATA KUNCI");
        cell3.setCellStyle(headerCellStyle);

        Cell cell4 = headerRow.createCell(4);
        cell4.setCellValue("JENIS KELAMIN");
        cell4.setCellStyle(headerCellStyle);

        Cell cell5 = headerRow.createCell(5);
        cell5.setCellValue("DAERAH");
        cell5.setCellStyle(headerCellStyle);

        int numRow = 1;
        for (Biodata biodata: biodataDAO.findAll()) {
            Row row = sheet.createRow(numRow++);
            row.createCell(0).setCellValue(biodata.getId());
            row.createCell(1).setCellValue(biodata.getNamaLengkap());
            row.createCell(2).setCellValue(biodata.getNamaPengguna());
            row.createCell(3).setCellValue(biodata.getKataKunci());
            row.createCell(4).setCellValue(biodata.getJenisKelamin());
            row.createCell(5).setCellValue(biodata.getDaerah());
        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=biodata.xlsx");
        ServletOutputStream fileout = response.getOutputStream();
        workbook.write(fileout);
        fileout.close();

        return "oke";
    }

    @GetMapping("/biodata/qrcode")
    public String addQrcode(HttpServletResponse response) throws WriterException, IOException {
        String code = "QRCODE NIH";
        String dir = "QRCODE.png";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(code, BarcodeFormat.QR_CODE, 350, 350);

        Path path = FileSystems.getDefault().getPath(dir);
//        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        response.setContentType("image/png");
        response.setHeader("Content-Disposition", "attachment; filename=QRCODE.PNG");
        ServletOutputStream fileout = response.getOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", fileout);
        return "Oke";
    }
}
