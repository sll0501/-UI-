package com.lyjs.base;

import com.lyjs.utils.PropertyReader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

@Slf4j
public class DriverBase {
   private WebDriver driver;
   private String browseName;
   private String driverBasePath;
 /**
  * 定义获取properties文件中各个driver值的变量
  * ***/
    private String chormeDriverLinuxPath;
    private String chormeDriverPath;
    private String firefoxDriverPath;
    private String ieDriverPath;
    private String edgeDriverPath;
    /**
     *创建两个ThreadLocal类，分别为Driver和BrowseName
     * **/
    private static ThreadLocal<WebDriver>threadDriver=new ThreadLocal<>();
    private static ThreadLocal<String>threadBrowseName=new ThreadLocal<>();
    /**
     * 创建两个ThreadLocalUtil类，分别用于操作上面创建的两个ThreadLocal对象
     * **/
    private static ThreadLocalUtil<WebDriver>driverThreadLocalUtil=new ThreadLocalUtil<>();
    private static ThreadLocalUtil<String> browseNameThreadLocalUtil=new ThreadLocalUtil<>();
    /**
     * 读取properties文件，赋值
     * **/
    private void setValue(){
        this.chormeDriverLinuxPath=PropertyReader.getProperty("driver.chromeDriverLinux");
        this.chormeDriverPath=PropertyReader.getProperty("driver.chromeDriver");
        this.edgeDriverPath=PropertyReader.getProperty("edgeDriverPath");
        this.firefoxDriverPath=PropertyReader.getProperty("firefoxDriverPath");
    }
    /**
     * 随机启动浏览器
     * */
    public  void randomOpenBrowse(int browserNumber,String remoteIP,String browserVersion){
       /*先获取properties文件中各浏览器的值*/
       setValue();
       System.out.println("谷歌浏览器驱动："+this.chormeDriverPath);
       /*获取到target中test-classes目录路径*/
       driverBasePath=this.getClass().getResource("/").getPath();
       log.info("\n driverBasePath的值为："+driverBasePath);
       System.out.println("driverBasePath的路径为："+driverBasePath);
       /*根据参数值是否为1-5，若不为该范围内的值，则随机1-5的值*/
       ArrayList<Integer>number=new ArrayList<>(Arrays.asList(1,2,3,4,5));
       if(!number.contains(browserNumber)){
          Random random=new Random();
          browserNumber=random.nextInt(4)+1;
       }
       /*根据参数启动不同的浏览器*/
       switch (browserNumber){
          case 1:
             openChormBrowse(remoteIP,browserVersion);
             break;
          case 2:
             openFirefoxBrowse(remoteIP,browserVersion);
             break;
          default:
             log.info("参数不符合期望");
             break;

       }
    }
    /**
     * 启动谷歌浏览器
     * **/
    private void openChormBrowse(String remoteIp,String browserVersion){
       try{
//          如果没有匹配到remoteIP,就执行本机
          if(remoteIp==null || "".equals(remoteIp)){
               /**
                * 如果是Windows系统
                * **/
             if(System.getProperty("os.name").contains("Windows")){
                /**
                 * 1.设置谷歌浏览器Driver
                 * **/
                System.setProperty("webdriver.chrome.driver",driverBasePath+chormeDriverPath);
                /**
                 * 2.谷歌浏览器  添加实质性质的设置参数
                 * 设置默认下载路径 且设置未禁止弹出下载窗口
                 * **/
                String downloadPath=new File("").getCanonicalPath()+"\\\\src\\\\test\\\\resources\\\\download";
//                创建一个map集合，key为字符串，value为Object类型
                HashMap<String,Object>chormePrefs=new HashMap<>();
                chormePrefs.put("profile.default_content_settings.popups",0);
                chormePrefs.put("download.default_directory",downloadPath);
//                创建ChormeOptions对象，并使用方法设置属性
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.setExperimentalOption("pres",chormePrefs);
                /**
                 * 3.设置启动参数
                 * **/
                /*取消沙盒模式*/
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                /*启动就最大化*/
                chromeOptions.addArguments("--start-maximized");
                /*设置静默模式，后台运行*/
                /*chromeOptions.addArguments("headless");*/
                /**
                 * 4.设置ThreadLocal对象的值
                 * threadDriver创建的ChormeDriver浏览器driver,并加载chormeOptions参数
                 * threadBrowseName为谷歌
                 * */
                driverThreadLocalUtil.setThreadValue(threadDriver,new ChromeDriver
                        ());
                log.info("成功启动谷歌浏览器");
             }
             /*如果是Linux系统*/
             else if(System.getProperty("os.name").contains("Linux")){

             }
          }else {
             /**
              *1、创建DesiredCapabilities 配置谷歌浏览器，版本号，平台
              * **/
          }
       }catch(Exception e){
              e.printStackTrace();
              log.info("谷歌浏览器启动失败");
       }

    }
   /**
    * 启动火狐浏览器
    * */
   private void openFirefoxBrowse(String remoteIP,String browseVersion){
       try{
            System.setProperty("webdriver.gecko.driver",driverBasePath+firefoxDriverPath);
            driverThreadLocalUtil.setThreadValue(threadDriver,new FirefoxDriver());
            browseNameThreadLocalUtil.setThreadValue(threadBrowseName,"火狐");
            log.info("成功启动火狐浏览器");
       }catch (Exception e){
                e.printStackTrace();
                log.info("火狐浏览器启动失败");
       }
   }
   /**
    * 获得driver
    * */
   public WebDriver getDriver(){
      return driverThreadLocalUtil.getThreadValue(threadDriver);
   }
   /**
    * 设置driver
    * */
   private void setDriver(WebDriver driver){
      this.driver=driver;
   }
   /**
    * 关闭driver
    * */
   public void stopDriver(){
      setDriver(getDriver());
      setBrowseName(getBrowseName());
      if(driver!=null){
         driver.quit();
         log.info("成功关闭"+browseName+"浏览器");
         /*最后通过remove方法去掉对应的线程组*/
         threadDriver.remove();
         threadBrowseName.remove();
      }

   }
   /**
    * 获得BrowseName
    * */
   private String getBrowseName(){
      return browseNameThreadLocalUtil.getThreadValue(threadBrowseName);
   }
   /**
    * 设置BrowseName
    * */
   private  void setBrowseName(String browseName){
      this.browseName=browseName;
   }
   public static void main(String []args){

      DriverBase base=new DriverBase();
      base.randomOpenBrowse(3,"111","2222");
   }
}
