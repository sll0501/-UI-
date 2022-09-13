package com.lyjs.test.common.line;

import com.lyjs.test.common.pageCommon;
import com.lyjs.test.locator.line.lineReportLocator;
import com.lyjs.util.CaseInfo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class lineReportCommon extends pageCommon {
    /**
     * 构造器
     * */
    public lineReportCommon(WebDriver driver){
        super(driver);
    }
    /**
     * 查询
     * */
    protected void inputAllDataByData(By []by, String []data)throws Exception{
        String tageName="";
        for(int i=0;i<by.length;i++){
            scroll_target(driver.findElement(by[i]));
            tageName=driver.findElement(by[i]).getTagName();
            if("input".equals(tageName)){
                inputData(by[i],data[i]);
            }else if("select".equals(tageName)){
                Select select=new Select(driver.findElement(by[i]));
                select.selectByIndex(1);
            }
        }

    }
    /**
     * 目的地，旅游类型的选择
     * */
    protected void randomSel(By btn,By  iframe, By element,By sumbit,String str)throws Exception{

        if(str==null){
            return;
        }
        String []arrStr=splitStr(str,",");
        List<String>list=new ArrayList<String>(Arrays.asList(arrStr));
        System.out.println(list);
        scroll_target(driver.findElement(btn));
        clickButton(btn);
        changeIframe(iframe);
        List<WebElement>listweb=driver.findElement(element).findElements(By.tagName("div"));
//        for(int i=0;i<listweb.size();i++){
//            if(i%2==0){
//                WebElement w=listweb.get(i).findElement(By.tagName("label"));
//                w.click();
//            }
//        }
        String txts=null;
        for(int i=0;i<listweb.size();i++){
            WebElement w=listweb.get(i).findElement(By.tagName("label"));
            txts=w.getText();
            if(list.indexOf(txts)>=0){
                w.click();
                Thread.sleep(100);
            }
        }
        clickButton(sumbit);
        changeParent();
    }


    /**
     * 返回两个数组中相同的元素
     * */
    protected List<String>getSame(String []arr1,String[]arr2){
        List<String>list=new ArrayList<String>();
        Map<String,String>map=new HashMap<String, String>();
        String sVal=null;
        for(String s:arr1){
            map.put(s,s);
        }
        for(String str:arr2){
            sVal=map.get(str);
            if(sVal!=null){
                list.add(str);
            }
        }
        return list;
    }
    /**
     * 数据与表格进行匹配
     * */
    protected boolean pirIsDataMatchTable(By table,String []data,int []td) throws Exception{
        boolean flag=true;
//       循环列表中所有的行
        for (int i=0;i<pirRowsOfTable(table);i++){
            if(!flag){
                break;
            }
            WebElement tableRowBox=driver.findElement(table).findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(i);
            for(int j=0;j<data.length-1;j++){
                if(!tableRowBox.findElements(By.tagName("td")).get(td[j]).getText().contains(data[j])){
                    flag=false;
                }
            }
        }
        return flag;
    }
    /**
     * 判断表格有多少行数据
     * */
    protected int pirRowsOfTable(By table)throws Exception{
        int tableRows=driver.findElement(table).findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size();
        return tableRows;
    }
    /**
     * 重置功能
     * */
    public boolean clear(By []by)throws Exception{
        boolean flag=true;
        for(int i=0;i<by.length;i++){
            if(flag==false){
                break;
            }
            WebElement wb=driver.findElement(by[i]);
            if("input".equals(wb.getTagName())){
                if(!("".equals(wb.getText())||null==wb.getText())){
                    flag=false;
                }
            }else if("select".equals(wb.getTagName())){
                Select se=new Select(wb);
                String defaultValue=se.getOptions().get(0).getText();
                String selValue=se.getFirstSelectedOption().getText();
                if(!(defaultValue.equals(selValue))){
                    flag=false;
                }
            }
        }
        return flag;
    }
    /**切换到指定的iframe*/
    public void changeIframe (By by)throws Exception{
        WebElement iframe=driver.findElement(by);
        driver.switchTo().frame(iframe);
    }
    /**切换到当前iframe的上一层*/

    public void changeParent ()throws Exception{
        driver.switchTo().parentFrame();
    }

    /**
     * 新增或编辑输入内容
     *
     * */
    protected void addinputAllDataByData(Map<String,By>btnMap, Map<String,String>dataMap)throws Exception{
        Iterator<Map.Entry<String,By>> iter1=btnMap.entrySet().iterator();
        System.out.println(iter1.hasNext());
        while (iter1.hasNext()) {
            Map.Entry<String, By> entry1 = (Map.Entry<String, By>) iter1.next();
            By m1value = entry1.getValue();
            String m2value = dataMap.get(entry1.getKey()) == null ? "" : dataMap.get(entry1.getKey());
            String tagName = driver.findElement(m1value).getTagName();
            WebElement wb = driver.findElement(m1value);
            if (!wb.isDisplayed()) {
                String id = wb.getAttribute("id");
                operation_none(id);
            }
            scroll_target(driver.findElement(m1value));
//            输入内容不为空
            if (!("".equals(m2value)) && null != m2value) {


                if (tagName.equals("input")) {

                    inputData(m1value, m2value);

                } else if (tagName.equals("select")) {
//                根据元素定位找到select这个标签
                    Select select = new Select(driver.findElement(m1value));
                    List<WebElement> webElements = select.getOptions();
                    List<String> txts = new ArrayList<>();
                    for (int j = 0; j < webElements.size(); j++) {
                        txts.add(webElements.get(j).getText());
                    }
                    if (txts.contains(m2value)) {
                        select.selectByVisibleText(m2value);
                    } else {
                        select.selectByIndex(1);
                    }
                }

            }
        }
    }

    /**
     * 上传图片
     * */
    public void sendPicture(By by,String source,By btnsumbit)throws Exception{
        scroll_target(driver.findElement(by));

        clickButton(100,by,100);
        Thread.sleep(2000);
        Runtime.getRuntime().exec(source);
        clickButton(1000,btnsumbit,1000);
    }

/**
 * 新增页面各种配置
 *
 * */
    public void setting(By btn,Map<String,By>btnMap, Map<String,String>dataMap,By...bys)throws Exception{
        clickButton(100,btn,1000);
        if(btn==lineReportLocator.SETARRANGE){
            addinputAllDataByData(btnMap,dataMap);
        }else if(btn==lineReportLocator.TICKETSETTING){
            clickButton(100,bys[0],1000);
            changeIframe(bys[1]);
            addinputAllDataByData(btnMap,dataMap);
            clickButton(bys[2]);
            changeParent();
        }
    }
    /**
     * 新增或编辑
     *
     * */

    public void addOrEdit(Object btn,Map<String,By>btnMap,Map<String,By>setBtnMap,Map<String,By>ticketBtnMap,CaseInfo c)throws Exception{
        if(btn instanceof By){
            By by=(By)btn;
            clickButton(1000,by,100);
        }else if(btn instanceof WebElement){
            WebElement wb=(WebElement)btn;
            clickButton(1000,wb,100);
        }
//        //       切换到相应的iframe
        driver.switchTo().frame(0);
        Map<String,String> map=new HashMap<String, String>();
        map=c.getCaseParam();
        Map<String,String>basicMap=new HashMap<String, String>();
        Map<String,String>setMap=new HashMap<>();
        Map<String,String>ticketMap=new HashMap<>();
        for(String key:map.keySet()){
            if(key.indexOf("{$b}")==0){
//                基本信息
                basicMap.put(key.replace("{$b}",""),map.get(key));
            }else if(key.indexOf("{$s}")==0){
//                出发配置
                setMap.put(key.replace("{$s}",""),map.get(key));
            }else if(key.indexOf("{$t}")==0){
//                票种配置
                ticketMap.put(key.replace("{$t}",""),map.get(key));
            }
        }
        addinputAllDataByData(btnMap,basicMap);
//        旅游目的地
        String location=map.get("目的地");
        randomSel(lineReportLocator.LOCATIONBTN,lineReportLocator.LOCATIONIFRAME,lineReportLocator.LOCATIONDIV,lineReportLocator.LOCATIONSUBMIT,location);
//        旅游类型
        String classify=map.get("旅游类型");
        randomSel(lineReportLocator.TRAVELCL,lineReportLocator.TRAVELIFRAME,lineReportLocator.TRAVELDIV,lineReportLocator.TRAVELSUBMIT,classify);
//        线路封面
        String basicDir="D:\\project\\java_Selenium_maven\\src\\test\\resources\\drivers\\";
        String picture=map.get("线路封面");
        String picDir=basicDir+picture;
        if(picture!=null){
            sendPicture(lineReportLocator.PICTUREBTN,picDir,lineReportLocator.PICSUMBIT);
        }
//        出发配置
        clickButton(100,lineReportLocator.SETARRANGE,100);
        setting(lineReportLocator.SETARRANGE,setBtnMap,setMap);
        By []bys=new By[]{lineReportLocator.TICKETTYPEINFO,lineReportLocator.TICKETIFRAME,lineReportLocator.TICKETBTN};
        System.out.println("ticketMap======================"+ticketMap);
//        票种配置
        setting(lineReportLocator.TICKETSETTING,ticketBtnMap,ticketMap,bys);



        clickButton(1000,lineReportLocator.CLOSEBTN,100);

//        clickButton(1000,lineReportLocator.ADDSUMBIT,1000);
        changeParent();



    }
    /**
     * 输入内容2
     *
     * */
    protected void addinputAllDataByData2(By []by, String data)throws Exception{
        Object []obj=splitStr(data,",");
        String tageName="";
        for(int i=0;i<by.length;i++){
            scroll_target(driver.findElement(by[i]));
            tageName=driver.findElement(by[i]).getTagName();
            String str=obj[i].toString();
            if(!"".equals(str)){
                if("input".equals(tageName)){
                    inputData(by[i],str);
                }else if("select".equals(tageName)){
//                    根据元素定位找到select这个标签
                    Select select=new Select(driver.findElement(by[i]));
                    List<WebElement>webElements=select.getOptions();
                    List<String>txts=new ArrayList<>();
                    for(int j=0;j<webElements.size();j++){
                          txts.add(webElements.get(j).getText());
                    }
                    if(txts.contains(str)){
                        select.selectByVisibleText(str);
                    }else {
                        select.selectByIndex(3);
                    }

                }

            }
        }

    }

    protected String[] splitStr(String data,String str)throws Exception{
        String []s=data.split(str);
        return s;
    }

    /**
     * 关闭新增页面
     *
     * */
    public void closeAdd(By btn)throws Exception{
//        //        点击新增或编辑按钮
        clickButton(1000,btn,100);
        System.out.println("当前文本内容："+driver.findElement(btn).isEnabled());
//       切换到相应的iframe
        driver.switchTo().frame(0);
        clickButton(1000,lineReportLocator.CLOSEBTN,100);
        changeParent();
    }
    /**
     *此方法用来判断一个红色型号的输入框在其中没有文本时候，点击保存之后其样式是否正常显示
     * */
    public boolean validate(By btn,By []elements)throws Exception{
        changePage(btn);
        clickButton(100,lineReportLocator.ADDSUMBIT,100);
        String str="";
        boolean flag=true;
        for (By element:elements) {
            if(flag){
                str=driver.findElement(element).getAttribute("id")+"-error";
                try{
                    driver.findElement(By.id(str));

                }catch (Exception e){
                      flag=false;
                }

            }
        }
        return flag;
    }

    /**
     * 进入新增或编辑页面
     * */
   public void changePage(By btn)throws Exception{
       clickButton(100,btn,100);
       driver.switchTo().frame(0);
   }
   /**
    * 提交，审核
    * */
   public void tjCommon()throws Exception{
       WebElement wb=driver.findElement(lineReportLocator.TABLE);
       int count=pirRowsOfTable(lineReportLocator.TABLE);
       for(int i=0;i<count;i++){
           WebElement tr=wb.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(0);
           WebElement btn=tr.findElements(By.tagName("td")).get(11).findElement(By.tagName("Button"));
           clickButton(100,btn,100);
           Thread.sleep(1000);
           WebElement w=driver.findElement(lineReportLocator.AUDBTN);
           clickButton(100,w,100);
       }
   }

   /**
    * 定位表格中某行
    *
    * */
   public WebElement locateBtn(By table,int row,int col)throws Exception{
       /**定位表格元素*/
       WebElement tb=driver.findElement(table);
       /**定位到表格中的具体某一行*/
       WebElement tbRow=tb.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(row);
       return tbRow;

   }

}
