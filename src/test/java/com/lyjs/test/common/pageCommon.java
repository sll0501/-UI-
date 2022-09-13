package com.lyjs.test.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class pageCommon {
    /**
     * 驱动
     * */
    protected WebDriver driver;
    /**
     * 驱动等待
     */
    protected WebDriverWait wait;

    /**
     * 构造器
     * */
    public pageCommon(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,20);
    }


    /**=================================页面基本操作===================================*/
    /**
     * 通过点击进行
     * */
    /**=================================基本元素操作===================================*/
    /**
     * 点击按钮操作，封装延时500ms
     *
     * @param by 点击按钮的定位
     * */
    protected void clickButton(By by)throws Exception{
//        等到页面加载存在并且可点击
       wait.until(ExpectedConditions.visibilityOfElementLocated(by));
       wait.until(ExpectedConditions.elementToBeClickable(by));
       WebElement buttonElement=driver.findElement(by);
       buttonElement.click();

    }
    /**
     * 点击按钮操作，外部延时传参
     * @param beforeTime ms 时间表示点击之前等待多少时延
     * @param by  点击按钮的定位
     * @param afterTime ms 时间表示点击之后等待多少延时
     * */
    protected void clickButton(long beforeTime,By by,long afterTime) throws Exception{
//        点击之前延时
          Thread.sleep(beforeTime);
//        等待页面加载存在并且可点击
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        WebElement buttonElement=driver.findElement(by);
        buttonElement.click();
//        点击之后延时
        Thread.sleep(afterTime);
    }

    /**
     * 点击按钮操作，外部延时传参
     * @param beforeTime ms 时间表示点击之前等待多少时延
     * @param wb  点击按钮的定位
     * @param afterTime ms 时间表示点击之后等待多少延时
     * */
    protected void clickButton(long beforeTime,WebElement wb,long afterTime) throws Exception{
//        点击之前延时
        Thread.sleep(beforeTime);
//        等待页面加载存在并且可点击
        wait.until(ExpectedConditions.visibilityOf(wb));
        wait.until(ExpectedConditions.elementToBeClickable(wb));
        wb.click();
//        点击之后延时
        Thread.sleep(afterTime);
    }
    /**
     * input框出现后就去点击先清空然后输入
     * @param by  input的By定位
     * @param keysToSend   要输入的数据
     * */
    protected void inputData(By by,CharSequence...keysToSend){
//            等待页面加载存在input并且可见可点击
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        WebElement inputElement=driver.findElement(by);
        Actions actions=new Actions(driver);
        actions.click(inputElement).perform();
//        清空input并且进行数据输入
        inputElement.clear();
//        输入数据
        inputElement.sendKeys(keysToSend);

    }
    /**
     * input 框出现后就去点击先清空然后输入
     *
     * @param element    input 的元素
     * @param keysToSend 要输入的数据
     */
    protected void inputData(WebElement element,CharSequence...keysToSend){
//            等待页面加载存在input并且可见可点击
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
//        清空input并且进行数据输入
        element.clear();
//        输入数据
        element.sendKeys(keysToSend);

    }
    /**
     * 下拉框点击并选中所需要的选项
     *
     * @param by    下拉框定位
     * @param ulBy  下拉列表 ul 定位
     * @param liStr 下拉列表中需要选中的一行中的文本的元素定位
     */
     protected void selectDropBox(By by,By ulBy,String liStr)throws Exception{
//         等到下拉框存在并可见并可点击
         clickButton(by);
//         等到下拉框(ul)出现了，就在此列表(ul)中进行华东到顶端的操作
         wait.until(ExpectedConditions.visibilityOfElementLocated(ulBy));
         Actions actions=new Actions(driver);
         actions.moveToElement(driver.findElement(ulBy)).perform();
         //        scrollElementTopToTop(By.xpath(liStr));
//         等到需要选中的 li 可见并且可被点击时候进行操作
         clickButton(By.xpath(liStr));
     }
    /**========================简单共用方法操作===========================================*/
    /**
     * 判断元素是否存在，在页面加载完全后可用
     *
     *
     * */
    protected boolean isElementContained(String str){
        //将隐式等待关闭，或者设置成非常小
        driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
        boolean flag=true;
        try{
//            若找不到元素此处会抛出异常
            driver.findElement(By.xpath(str));
        }catch (Exception e){
//            若抛出异常，即找不到元素
            flag=false;
        }finally {
//            还原隐式等待
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            return flag;
        }
    }
    /**
     *此方法用来判断一个红色星号的输入框在其中没有文本时候，点击保存之后其样式是否正常显示，可以与 isAllDataAllowedNull 方法
     * */
    protected boolean isDataAllowedNull(String itemLocator){
        return false;
    }
    /**
     * 使用场景：比如说新建时候，很多数据都没有输入，然后点击保存之后可以调用此方法，此方法可判断带有星号未输数据的输入框在点击
     * 保存之后框的样式是否变成 "has-error" 的红色样式，只要有一个不满足该方法就会返回 false，当在未输入数据保存后，全部带有星
     * 号的框的样式都是正确的，该方法就会返回 ture
     * ps：该方法仅做判断框的样式是否合规，返回布尔值，方法前面一步需要自己点击保存按钮
     *
     * @param boxType 新建或者搜索框的类型，是滑动框 slide，还是模态框 modal，还是一个页面显示 tab
     * @return 全部带有红色星号且没有数据的输入框样式都是红框 "has-error" 就会返回 true，否则返回 false
     * @throws Exception 当输入的 boxType 类型有问题时候抛出
     */
    protected boolean isAllDataAllowedNull(String boxType) throws Exception {
        return false;
    }

    /**
     * 操作滚动条：滚动到最下面
     * */
    protected void scroll_down(){
        String js="var q=document.documentElement.scrollTop=10000";
        JavascriptExecutor jdriver=(JavascriptExecutor)driver;
        jdriver.executeScript(js);
    }
    /**
     * 滚动到最上面
     * */
    protected void scroll_up(){
        String js="var q=document.documentElement.scrollTop=0";
        JavascriptExecutor jdriver=(JavascriptExecutor)driver;
        jdriver.executeScript(js);
    }
    /**
     * 拖动到指定位置
     * */
    protected void scroll_target(WebElement w){
        JavascriptExecutor jdriver=(JavascriptExecutor)driver;
        jdriver.executeScript("arguments[0].scrollIntoView();",w);
    }
    /**
     * 通过id处理不可见元素
     * */
    protected void operation_none(String id)throws Exception{
        JavascriptExecutor jdriver=(JavascriptExecutor)driver;
        String js = "document.getElementById('"+id+"').style.display='block';";
        jdriver.executeScript(js);
        Thread.sleep(10);
    }
}
