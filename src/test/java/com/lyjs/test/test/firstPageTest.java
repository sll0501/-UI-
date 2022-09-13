package com.lyjs.test.test;

import com.lyjs.listener.TestLogListener;
import com.lyjs.listener.TestReportListener;
import com.lyjs.test.base.BaseTest;
import com.lyjs.test.page.FirstPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
public class firstPageTest extends BaseTest {
    private FirstPage firstpage;
    @Test(priority = 1,description = "跳转到指定页面")
    public void test1()throws Exception{
        /**初始化页面*/
        firstpage=new FirstPage(driver);
        firstpage.jumpTOPage();
    }
}
