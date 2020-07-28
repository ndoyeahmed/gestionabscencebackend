package com.alameenjr.gestionabscence.utils;

import com.alameenjr.gestionabscence.entities.inscription.Etudiant;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EtudiantExcelExport {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<Etudiant> etudiantsList;

    public EtudiantExcelExport(List<Etudiant> etudiantsList) {
        this.etudiantsList = etudiantsList;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Etudiants");
    }

    private void writeHeaderRow(){
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("id");
        cell = row.createCell(1);
        cell.setCellValue("Date Inscrit");
        cell = row.createCell(2);
        cell.setCellValue("Nom");
        cell = row.createCell(3);
        cell.setCellValue("Prenom");
        cell = row.createCell(4);
        cell.setCellValue("DateNaissance");
        cell = row.createCell(5);
        cell.setCellValue("Matricule");
    }

    private void writeDataRows(){

    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDataRows();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
