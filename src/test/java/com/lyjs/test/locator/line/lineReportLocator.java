package com.lyjs.test.locator.line;

import org.openqa.selenium.By;

public class lineReportLocator {


//    线路管理
    public static final By LINEMANAGE=By.xpath("//*[@id=\"side-menu\"]/li[4]/a");
//    旅游线路报备
    public static final By LINEREPORT=By.xpath("//*[@id=\"side-menu\"]/li[4]/ul/li[1]/a");

//    线路ID
    public static final By LINEID=By.xpath("//*[@id=\"lineCode\"]");
//    线路名称
    public static final By PLACENAME=By.xpath("//*[@id=\"lineName\"]");
//    线路状态
    public static final By PLACESTATE=By.id("state");
//    所属供应商
    public static final By SUPPLIER=By.xpath("//*[@id=\"supplierId\"]");
//    查询按钮
    public static final By SELBTN=By.xpath("//*[@id=\"searchForm\"]/div[5]/button");
//    表格
    public static final By TABLE=By.id("exampleTable");

//    重置
    public static final By RESET=By.xpath("//*[@id=\"searchForm\"]/div[5]/input");

/**--------------------------------新增，编辑页面----------------------------------------------------*/
//    添加按钮
    public static final By ADDBTN=By.xpath(" /html/body/div[1]/div[2]/div/div/div[1]/div/button[1]");
//    页面所在iframe
    public static final By ADDIFRAME=By.xpath("//*[@id=\"layui-layer-iframe2\"]");
//    基本信息
public static final By BASICINFO=By.xpath("/html/body/div[1]/div/div/div/div/div/ul/li[1]/a");
//    线路特色
public static final By PLANSPECIAL=By.xpath("/html/body/div[1]/div/div/div/div/div/ul/li[2]/a");
//行程安排
public static final By PLANARRANGE=By.xpath("/html/body/div[1]/div/div/div/div/div/ul/li[2]/a");
//出游告示
public static final By TRANOTICE=By.xpath("/html/body/div[1]/div/div/div/div/div/ul/li[4]/a");
//违约设置
public static final By DEFAULTSETTING=By.xpath("/html/body/div[1]/div/div/div/div/div/ul/li[4]/a");
//出发配置
public static final By SETARRANGE=By.xpath("/html/body/div[1]/div/div/div/div/div/ul/li[6]/a");
//票种配置
public static final By TICKETSETTING=By.xpath("/html/body/div[1]/div/div/div/div/div/ul/li[7]/a");
//所属供应商
public static final By SUPPEROWN=By.id("supplierId");
//线路ID
public static final By ADDLINEID=By.id("lineCode");
//线路名称
public static final By ADDLINENAME=By.id("lineName");
//最低票价
public static final By MINPRICE=By.id("minPrice");
//最低购买人数
public static final By MINSALENUM=By.id("minSaleNum");
//服务热线
public static final By SERVICEHOTLINE=By.id("serviceHotline");
//服务时间
public static final By SERVICETIME=By.id("serviceTime");
//出游天数
public static final By TRAVELDay=By.id("travelDay");
//添加目的地按钮
public static final By LOCATIONBTN=By.xpath("//*[@id=\"baseInfo\"]/div[14]/div[2]/a");
//目的地所在iframe
public static final By  LOCATIONIFRAME=By.xpath("//*[@id=\"layui-layer-iframe2\"]");
//目的地所在文本框     //*[@id="lineClassifyForm"]/div[1]
public static final By LOCATIONDIV=By.xpath("//*[@id=\"lineClassifyForm\"]/div[1]/div");
//目的地提交按钮
    public static final By LOCATIONSUBMIT=By.xpath("//*[@id=\"lineClassifyForm\"]/div[2]/div/input[1]");
//添加旅游类型按钮
public static final By TRAVELCL=By.xpath("//*[@id=\"baseInfo\"]/div[16]/div[2]");
//旅游类型所在iframe
    public static final By TRAVELIFRAME=By.xpath("//*[@id=\"layui-layer-iframe3\"]");
//    旅游类型所在文本框
    public static final By TRAVELDIV=By.xpath("//*[@id=\"lineClassifyForm\"]/div[1]/div");
//    旅游类型提交按钮
    public static final By TRAVELSUBMIT=By.xpath("//*[@id=\"lineClassifyForm\"]/div[2]/div/input[1]");
//是否上传原图
public static final By  ISPICTURE=By.xpath("//*[@id=\"baseInfo\"]/div[18]/div/div[1]/div/input");
//上传图片按钮
public static final By  PICTUREBTN=By.xpath("//*[@id=\"baseInfo\"]/div[18]/div/div[2]/div[2]/div");
//删除图片按钮
public static final By  DELPICTUERBTN=By.xpath("//*[@id=\"baseInfo\"]/div[18]/div/div[2]/div[2]/button");
//提交图片按钮
    public static final By PICSUMBIT =By.xpath("//*[@id=\"baseInfo\"]/div[18]/div/div[2]/div[1]/div/div/div/div[2]/button[1]");
//线路特色文本框
public static final By LINEFEATURESINFO=By.xpath("//*[@id=\"lineFeaturesInfo\"]/div/textarea");
//    行程安排文本框
public static final By ARRAGESPECTEX=By.xpath("//*[@id=\"travelArrangeInfo\"]/div/textarea");
//出游告示文本框
public static final By ARRAGESPECTEXTRAVELNOTICEINFO=By.xpath("//*[@id=\"travelNoticeInfo\"]/div/textarea");
//上车点名称
    public static final By SCDNAME=By.xpath("//*[@id=\"1\"]");
//    上车点位置
    public static final By STATIONADDRESS=By.xpath("//*[@id=\"stationAddress1\"]");
//    更多出发点添加按钮
    public static final By LINESTATIONINFO=By.xpath("//*[@id=\"lineStationInfo\"]/div[3]/div/button");
//    新增票种添加按钮
    public static final By TICKETTYPEINFO=By.xpath("//*[@id=\"ticketTypeInfo\"]/div/div[2]/div[2]/button");
//    票种配置所在iframe
    public static final By TICKETIFRAME=By.xpath("//*[@id=\"layui-layer-iframe4\"]");
//    票种名称
    public static final By TICKETNAME=By.xpath("//*[@id=\"ticketName\"]");
//    零售价
    public static final By RETAILPRICE=By.xpath("//*[@id=\"retailPrice\"]");
//    提交票种按钮
    public static By TICKETBTN=By.xpath("//*[@id=\"signupForm\"]/div[6]/div/div/button[2]");

//    新增页面提交按钮
    public static By ADDSUMBIT=By.xpath("//*[@id=\"lineForm\"]/div[2]/div/div/button");

//    新增页面关闭按钮  //*[@id="lineForm"]/div[2]/div/div/input
    public static By CLOSEBTN=By.xpath("//*[@id=\"lineForm\"]/div[2]/div/div/input");

//    提交审核按钮
    public static By AUDITING=By.xpath("//*[@id=\"exampleTable\"]/tbody/tr[1]/td[12]/button");
//    确定提交审核  //*[@id="layui-layer12"]/div[2]
    public static By AUDBTN=By.className("layui-layer-btn0");
}
