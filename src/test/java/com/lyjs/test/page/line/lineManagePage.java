package com.lyjs.test.page.line;

import com.lyjs.test.common.line.lineReportCommon;
import com.lyjs.test.locator.line.lineReportLocator;
import com.lyjs.util.CaseInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lineManagePage extends lineReportCommon {
    /**
     * 构造器
     * */
    public lineManagePage(WebDriver driver){
        super(driver);
    }
    /*
    * 初始化页面
    * */
    public void init()throws Exception{
        System.out.println("执行初始化函数");
        System.out.println("ByXpath地址："+lineReportLocator.LINEMANAGE);
      clickButton(lineReportLocator.LINEMANAGE);
      clickButton(lineReportLocator.LINEREPORT);
        driver.switchTo().frame(1);
        Thread.sleep(1000);
    }

    /**
     * 根据不同的条件查询
     * */
    public void sel(By []by,String []data,int []td)throws Exception{
        inputAllDataByData(by,data);
        clickButton(lineReportLocator.SELBTN);
        By table=lineReportLocator.TABLE;
        boolean flag=pirIsDataMatchTable(table,data,td);
        Assert.assertEquals(true,flag);
    }
    /**
     * 重置功能
     * */
    public void reset(By[]by, String []data, int []td)throws Exception{
        inputAllDataByData(by,data);
        clickButton(lineReportLocator.RESET);
        boolean flag=clear(by);
        Assert.assertEquals(true,flag);
    }

    /**
     * 一个红色型号的输入框在其中没有文本时候，点击保存之后其样式是否正常显示
     * */
    public void addValiade(By []elements)throws Exception{
        By btn=lineReportLocator.ADDBTN;

        boolean flag= validate(btn,elements);
        Assert.assertEquals(flag,true);
    }
    /**
     * 关闭新增页面
     * */
    public void close()throws Exception{
        By btn=lineReportLocator.ADDBTN;
        closeAdd(lineReportLocator.ADDBTN);
    }
    /**
     * 提交，审核
     * */
    public void TJ()throws Exception{
        clickButton(100,lineReportLocator.RESET,100);
        inputAllDataByData(new By[]{lineReportLocator.PLACESTATE},new String[]{});
        clickButton(lineReportLocator.SELBTN);
        tjCommon();
        By []by=new By[]{lineReportLocator.PLACESTATE};
        String []data=new String[]{"待审批"};
        int []td=new int[]{10};
//       通过查询断言
        sel(by,data,td);
    }

    public void add5(CaseInfo c)throws Exception{
        Map<String,By>btnMap=new HashMap<String,By>();
        btnMap.put("所属供应商",lineReportLocator.SUPPEROWN);
        btnMap.put("线路ID",lineReportLocator.ADDLINEID);
        btnMap.put("线路名称",lineReportLocator.ADDLINENAME);
        btnMap.put("最低票价",lineReportLocator.MINPRICE);
        btnMap.put("最低购买人数",lineReportLocator.MINSALENUM);
        btnMap.put("服务热线",lineReportLocator.SERVICEHOTLINE);
        btnMap.put("服务时间",lineReportLocator.SERVICETIME);
        btnMap.put("出游天数",lineReportLocator.TRAVELDay);
        Map<String,By>setMap=new HashMap<String,By>();
        setMap.put("上车点名称",lineReportLocator.SCDNAME);
        setMap.put("上车点位置",lineReportLocator.STATIONADDRESS);
        Map<String,By>ticketMap=new HashMap<>();
        ticketMap.put("票种名称",lineReportLocator.TICKETNAME);
        ticketMap.put("零售价",lineReportLocator.RETAILPRICE);
        By btn=lineReportLocator.ADDBTN;
        addOrEdit(btn,btnMap,setMap,ticketMap,c);

    }


}
