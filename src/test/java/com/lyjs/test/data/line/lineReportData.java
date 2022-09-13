package com.lyjs.test.data.line;

import com.lyjs.test.locator.line.lineReportLocator;
import com.lyjs.util.MyIncrementGenerator;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Random;

public class lineReportData {
    /**
     * 查询功能参数
     * */
    public static final String []data1=new String[]{"123"};
    public static final By []by1=new By[]{lineReportLocator.LINEID};
    public static final int []table1=new int[]{1};

    public static final By []by2=new By[]{lineReportLocator.PLACENAME};
    public static final String []data2=new String[]{"测试线路"};
    public static final int []table2=new int[]{2};

    public static final By []by3=new By[]{lineReportLocator.PLACESTATE};
    public static final String []data3=new String[]{"已批准"};
    public static final int []table3=new int[]{10};

    public static final String []data4=new String[]{"123","测试线路"};
    public static final By []by4=new By[]{lineReportLocator.LINEID,lineReportLocator.PLACENAME};
    public static final int []table4=new int[]{1,2};

    public static final  String []data5=new String[]{"123","测试线路"};
    public static final By []by5=new By[]{lineReportLocator.LINEID,lineReportLocator.PLACENAME,lineReportLocator.PLACESTATE};
    public static final int []table5=new int[]{1,2,10};

    /**
     * 查询功能参数
     * */
    @DataProvider(name = "selProvide",parallel = true)
    public static Object[][] createData1(){
        return new Object[][]{
                {lineReportData.by1, lineReportData.data1,lineReportData.table1 },
                {lineReportData.by2,lineReportData.data2,lineReportData.table2},
                {lineReportData.by3,lineReportData.data3,lineReportData.table3},
                {lineReportData.by4,lineReportData.data4,lineReportData.table4},
                {lineReportData.by5,lineReportData.data5,lineReportData.table5}
        };
    }



    /**
     * 新增功能参数
     * */
    String result="[{\"basic\":\"上海交运久彰网络服务科技有限公司,99988,小宋测试线路009,10,1,77889,周一至周五：09:00-18:00,多日游\",\"sendPicture\" : \"true\"," +
            "\"locations\" : \"true\",\"classify\":\"true\",\"startSetting\":\"上海客运南站,上海市松江区永丰街道小茜泾路80-56号\"," +
            "\"ticketSetting\":\"一日游,100\"}]";
    /**
     * 新增功能参数
     * */
//    @DataProvider(name = "addProvide",parallel = false)
//    public static Object[][] createData2(){
//        return new Object[][]{
//                [{\"basic\":\"上海交运久彰网络服务科技有限公司,99988,小宋测试线路009,10,1,77889,周一至周五：09:00-18:00,多日游\",\"sendPicture\" : \"true\"," +
//                "\"locations\" : \"true\",\"classify\":\"true\",\"startSetting\":\"上海客运南站,上海市松江区永丰街道小茜泾路80-56号\"," +
//                "\"ticketSetting\":\"一日游,100\"}],
//        };
//    }

}
