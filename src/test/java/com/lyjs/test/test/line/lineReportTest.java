package com.lyjs.test.test.line;

import com.lyjs.test.base.BaseTest;
import com.lyjs.test.common.pageFirstCommon;
import com.lyjs.test.data.line.lineReportData;
import com.lyjs.test.locator.line.lineReportLocator;
import com.lyjs.util.CaseHelper;
import com.lyjs.util.CaseInfo;
import com.lyjs.util.DataFile;
import com.lyjs.util.ReadExcel;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import com.lyjs.test.page.line.lineManagePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class lineReportTest extends BaseTest  {
    private lineManagePage linemanagePage;
    private pageFirstCommon pagefirstCommon;
    @BeforeClass
    public void before()throws Exception{
        /**初始化页面*/
        pagefirstCommon=new pageFirstCommon(driver);
        linemanagePage=new lineManagePage(driver);
        pagefirstCommon.jumpByClick();
        linemanagePage.init();
    }
    /**
     * 查询功能
     * */
    @Test(dataProvider ="selProvide",dataProviderClass = lineReportData.class,priority = 2,description = "查询功能")
    public void test2(By[]by, String []data, int []td)throws Exception{
        Thread.sleep(1000);
        linemanagePage.sel(by,data,td);
    }
    /**
     * 重置功能
     * */

    @Test(dataProvider ="selProvide",dataProviderClass = lineReportData.class,priority = 3,description = "重置功能")
    public void test3(By[]by, String []data, int []td)throws Exception{
        Thread.sleep(1000);
       linemanagePage.reset(by,data,td);
    }
    /**
     * 新增页面关闭功能
     * */

    @Test(dataProvider = "addProvide",dataProviderClass =lineReportData.class,priority =6,description = "关闭功能")
    public void test6(HashMap<String,By[]> byMap, HashMap<String,String[]>dataMap)throws Exception{
        linemanagePage.close();
    }
    /**
     *验证功能
     * **/
    @Test
    public void test7()throws Exception{
        By []elements=new By[]{lineReportLocator.ADDLINEID,lineReportLocator.MINPRICE};
        linemanagePage.addValiade(elements);
    }
    /**
     * 提交审核
     * */
    @Test(priority = 7,description = "提交审核")
    public void test8()throws Exception{
        linemanagePage.TJ();


    }
    @DataProvider(name="dataInfo",parallel = false)
    protected Object[][]dataInfo1(Method m)throws IOException {
        DataFile d=m.getAnnotation(DataFile.class);
        Object[][]myObj=null;
        List<Map<String,String>> list=ReadExcel.readXlsx(d.path());
        myObj=CaseHelper.getObjArrByList(list);
        return myObj;
    }

    @Test(dataProvider = "dataInfo")
    @DataFile(path="D:\\project\\java_Selenium_maven\\src\\test\\java\\com\\lyjs\\test\\data\\11.xlsx")
    public void test9(CaseInfo c)throws Exception{

        linemanagePage.add5(c);


    }



}
