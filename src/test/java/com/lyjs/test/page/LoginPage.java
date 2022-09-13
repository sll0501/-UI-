package com.lyjs.test.page;

import com.lyjs.test.common.pageCommon;
import com.lyjs.test.data.LoginData;
import com.lyjs.test.locator.LoginLocator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Slf4j
public class LoginPage extends pageCommon {
    /**
     * 构造器
     * */
    public LoginPage(WebDriver driver){
        super(driver);
    }
    /**
     * 登录
     * */

    public void login(String user,String pwd)throws Exception{
        driver.manage().window().maximize();
        log.info("开始进行登录操作---");
//        进入首页
        driver.get(LoginData.URL);
////        输入用户名
        inputData(LoginLocator.USERNAME,user);
////        输入密码
        inputData(LoginLocator.PASSWORD,pwd);
////        点击登录按钮
        clickButton(LoginLocator.LOGINBTN);
        log.info("登录成功");
    }
}
