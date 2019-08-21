package com.app.api;

import com.app.dao.Dao;
import com.app.model.Person;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcellDataApi implements DataApi {
    private String filePath;
    private Dao dao;

    public ExcellDataApi(String filePath, Dao dao) {
        this.filePath = filePath;
        this.dao=dao;
    }

    @Override
    public void write() {
        try(InputStream in = new FileInputStream(new File(filePath));) {

            Workbook workbook = new XSSFWorkbook(in);

          //  Workbook workbook = null;
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.rowIterator();
            List<Person> persons = new ArrayList<>();
            while (itr.hasNext()) {
                Row row = itr.next();
                Person p = new Person();
                Iterator<Cell> cellItr = row.cellIterator();
                while (cellItr.hasNext()) {
                    Cell cell = cellItr.next();
                    if (cell.getCellType() == CellType.STRING.getCode()) {
                        String name = cell.getStringCellValue();
                        p.setName(name);
                    } else if (cell.getCellType() == CellType.NUMERIC.getCode()) {
                        double value = cell.getNumericCellValue();
                        p.setAge((int) value);
                    }

                }
                persons.add(p);
            }
            dao.multipleSave(persons);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void read() {
        List<Person> persons =  dao.readAll();
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        int i = 0;
        for(Person p: persons) {
            Row row = sheet.createRow(i++);
            Cell cell = row.createCell(0);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(p.getName());

            cell = row.createCell(1);
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue(p.getAge());
        }

        try(OutputStream out = new FileOutputStream(new File(filePath))){
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
