package com.lyjs.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 截图工具类
 *
 * 参考链接：
 *      1.TakesScreenshot截图类使用
 *          https://stackoverflow.com/questions/3422262/how-to-take-screenshot-with-selenium-webdriver
 *          File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 *
 *      2.ITestResult Testng提供的接口，用于监听@Test注解的方法的相关信息
 *          https://blog.csdn.net/hujyhfwfh2/article/details/84842885
 *
 *      3.FileUtils工具类使用
 *          https://blog.csdn.net/qq_42402854/article/details/83374559
 *
 */
@Slf4j
public class ScreenShot {
    /**
     * 定义截图存储的目录
     * System.getProperty(user.dir) 获取项目的文件夹路径
     * File.separator    系统文件目录分隔符
     * */
    private static String screenShotDirPath=System.getProperty("user.dir")+File.separator+"target"+File.separator+"test-output"+File.separator+"errorScreenShot";
    public static void takeScreenShot(WebDriver driver, ITestResult itestResult){
        /**
         * 1.创建指定路径的文件夹
         * */
        /*创建File对象*/
        File screenShotDir=new File(screenShotDirPath);
        /**判断路径，如果路径不存在且路径不是文件夹，才创建该文件夹*/
        if(!screenShotDir.exists()&& !screenShotDir.isDirectory()){
            screenShotDir.mkdir();
        }
        /**
         * 2.利用Testng的iTestResult获取类名
         * */
        /*获取类名的字符串*/
        String className=itestResult.getInstanceName();
        log.info("\n获取的类名的字符串为："+className);

        /**
         * 3.利用实践类获取当前时分秒
         * */
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH点mm分ss秒");
        String time=simpleDateFormat.format(new Date());

        /**
         * 4.利用TakesScreenshot.getScreenshotAs截图
         * */
        try{
            /*Java Selenium截图固定写法 */
            File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            /*利用FileUtils拷贝文件*/
            FileUtils.copyFile(sourceFile,new File(screenShotDir+File.separator+className+time+".png"));

        }catch (Exception e){
               e.printStackTrace();
        }
    }
//    System.getProperty(user.dir) 获取的是启动项目的容器位置，用IDEA是项目的根目录，部署在tomcat上是tomcat的启动路径，即tomcat/bin的位置
    public static void main(String []args){
        System.out.println(File.separator);
    }
}
