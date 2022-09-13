package com.lyjs.test.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageFirstCommon extends pageCommon {
    /***/
    public pageFirstCommon(WebDriver driver){
        super(driver);
    }
    /**
     * 跳转到运营业务管理系统页面
     * */
    public void jumpByClick()throws Exception{
          By by=By.xpath("//*[@id=\"systemEntry\"]/div/div[2]/div");
          clickButton(20,by,1000);
    }
    /**
     *  获取顶上的title
     * */
    public String getFirstTabName()throws Exception{
//        String txt=driver.findElement(By.xpath("/html/head/title")).getText();
        String title=driver.getTitle();
        return title;
    }
}
