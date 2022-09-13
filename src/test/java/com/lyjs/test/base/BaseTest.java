package com.lyjs.test.base;

import com.lyjs.base.DriverBase;
import com.lyjs.test.page.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Slf4j
public class BaseTest {
    public static DriverBase driverBase=new DriverBase();
    public WebDriver driver;
    public static TimeOptBase timeOptBase=new TimeOptBase();
    @BeforeTest(alwaysRun = true)
    @Parameters({"browseNumber","remoteIp","browserVersion"})
    public void setUp(@Optional("1") int browserNumber,@Optional()String remoteIP,@Optional("74.0.3729.169") String browserVersion){
        try{
             /*启动浏览器，并获取指定浏览器的driver放在driverThreadLocalUtil中*/
            driverBase.randomOpenBrowse(browserNumber,remoteIP,browserVersion);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @BeforeClass(alwaysRun = true)
    public void beforeClassInit(){
        /*获取driverThreadLocalUtil中的driver对象*/
        driver=driverBase.getDriver();
        /**/
    }
    @BeforeClass(alwaysRun = true)
    @Parameters({"user","pwd"})
    public void loginClass(@Optional("develop")String user,@Optional("111111")String pwd)throws Exception{
        /*初始化页面类*/
        LoginPage loginPage=new LoginPage(driver);
        /*登录系统*/
        loginPage.login(user,pwd);
        Thread.sleep(5000);
    }
    @AfterTest(alwaysRun = true)
    public  void stop(){
        /*关闭driver对象*/
        driverBase.stopDriver();
        /*移除WebDriverWait对象*/
        timeOptBase.releaseWait();

    }
}
