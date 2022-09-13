package com.lyjs.test.test.line;



import com.lyjs.util.*;
import org.json.JSONArray;
import com.lyjs.test.base.BaseTest;
import com.lyjs.test.locator.line.lineReportLocator;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class aa extends CaseHelper  {
//   protected String caseExcelPath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\lyjs\\test\\data\\11.xlsx";
//  @DataProvider(name="dataInfo")
//   protected Object[][]dataInfo1(Method m)throws IOException{
//      DataFile d=m.getAnnotation(DataFile.class);
//      Object[][]myObj=null;
//      List<Map<String,String>>list=ReadExcel.readXlsx(d.path());
//      myObj=CaseHelper.getObjArrByList(list);
//      return myObj;
//   }
   @Test(dataProvider="dataInfo")
   @DataFile(path="D:\\project\\java_Selenium_maven\\src\\test\\java\\com\\lyjs\\test\\data\\11.xlsx")
    public void test01(CaseInfo c){
       System.out.println("执行该用例");
       ///获取用例说明
       System.out.println(c.getCaseDesc());
       ///获取用例需要的参数
       System.out.println(c.getCaseParam());
       //获取执行用例需要的前置条件
       System.out.println(c.getCasePreset());
   }
//   public static void main(String []args){
//       aa a=new aa();
//       Object[][]myObj=null;
//       List<Map<String,String>>list=ReadExcel.readXlsx(a.caseExcelPath);
//       System.out.println(list.size());
//       myObj=CaseHelper.getObjArrByList(list);
//
//   }

}
