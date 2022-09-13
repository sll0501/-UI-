package com.lyjs.util;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcel {
    public static List<Map<String,String>>readXlsx(String fileName){
        XSSFWorkbook xssfWorkbook=null;
        try{
            xssfWorkbook=new XSSFWorkbook(fileName);
        }catch (Exception e){
           e.printStackTrace();
        }
//        循环工作表Sheet
        XSSFSheet xssfSheet=xssfWorkbook.getSheetAt(0);
        List<Map<String,String>>list=new ArrayList<Map<String,String>>();
//        循环row
        XSSFRow rowTitleRow=xssfSheet.getRow(0);
        for(int rowNum=1;rowNum<=xssfSheet.getLastRowNum();rowNum++){
            XSSFRow xssfRow=xssfSheet.getRow(rowNum);
            if(xssfRow==null){
                continue;
            }
            Map<String,String>map=new HashMap<String,String>();

//            循环列
            for(int cellNum=0;cellNum<rowTitleRow.getLastCellNum();cellNum++){
                XSSFCell xssfCell=xssfRow.getCell(cellNum);
                XSSFCell xssfCell1TitleCell=rowTitleRow.getCell(cellNum);
                map.put(getValue(xssfCell1TitleCell),getValue(xssfCell));
            }
            list.add(map);
        }
        return list;
    }
    @SuppressWarnings("static-access")
    private static String getValue(XSSFCell xssfCell){
        if(xssfCell==null){
            return "";
        }
        xssfCell.setCellType(CellType.STRING);
        return String.valueOf(xssfCell.getStringCellValue());
//        if(xssfCell.getCellType()==xssfCell.CELL_TYPE_BOOLEAN){
//            return String.valueOf(xssfCell.getBooleanCellValue());
//        }else if(xssfCell.getCellType()==xssfCell.CELL_TYPE_NUMERIC){
//            return String.valueOf(xssfCell.getNumericCellValue());
//        }else{
//            return String.valueOf(xssfCell.getStringCellValue());
//        }
    }
    public static void main(String []args){
        String caseExcelPath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\lyjs\\test\\data\\11.xlsx";
        List<Map<String,String>>list= ReadExcel.readXlsx(caseExcelPath);
        for (Map<String,String>map:list){
            System.out.println(map);
        }

    }
}
