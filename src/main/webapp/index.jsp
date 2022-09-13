testng常用的注解：
1.@BeforeSuite:在此套件中的所有测试运行之前运行
2.@BeforeTest:在标记test类中所有测试之前运行
3.@BeforeClass:在当前类中第一个测试方法之前运行
4.@BeforeMethod:在每一个测试方法之前运行


@Parameters({"browseNumber","remoteIp","browserVersion"})
表示该函数使用的参数由testng.xml提供，第一个参数是xml中的browseNumber参数，第二个参数是remoteIp参数，第三个参数是browserVersion


public void setUp(@Optional("1") int browserNumber,@Optional()String remoteIP,@Optional("74.0.3729.169") String browserVersion){

@optional("1")的意思是：如果在testng.xml文件中没有找到名为"browserNumber"的参数，测试方法将接受在@Optional注解中指定的默认值："1"


隐式等待
(1). implicitlyWait()
implicitlyWait用来设置识别对象的超时时间。当要查找某个元素，而这个元素没有马上出现时，implicitlyWait方法要告诉WebDriver要查询Dom一段时间。默认值是0，
但是设置之后，这个时间将在WebDriver对象实例整个生命周期都起作用。也就说，我们使用implicitlyWait方法设定10s钟的全局等待时间，如果在这短时间内，找到要寻找的元素，
则正常往下执行。否则，到10s中还未找到元素，则抛出一个NoSuchElement异常。WebDriver默认500毫秒检查一次其返回结果。
(2). pageLoadTimeout()
pageLoadTimeout用来设置页面完全加载的超时时间，例如上述代码，在15秒之后如果页面还没有加载完成则抛出超时异常。如果想要在抛出异常后并不中断执行，就用try,catch组合来实现吧。

(3). setScriptTimeout()

setScriptTimeout设置异步脚本的超时时间。

隐式等待是比较死板的。我们在代码中设置了固定的等待时间，比如10s。但如果要找的元素在10s内没出现，而在11s的时候出现，但程序实际已经抛异常了。又或者，元素在5s的时候就出现了，程序仍然会等够10s，才会继续执行后续操作。


显示等待
