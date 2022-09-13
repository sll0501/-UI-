package com.lyjs.test.page;
import com.lyjs.test.common.pageFirstCommon;
import com.lyjs.test.locator.FirstLocator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FirstPage extends pageFirstCommon {
    public FirstPage(WebDriver driver){
        super(driver);
    }
    /**
     * 点击跳转到指定页面
     * */
    public void jumpTOPage()throws Exception{
          jumpByClick();

          System.out.println("页面字母："+getFirstTabName());
          Assert.assertEquals("运营业务管理系统",getFirstTabName());
    }
}
