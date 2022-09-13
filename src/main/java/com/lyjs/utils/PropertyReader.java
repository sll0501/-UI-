package com.lyjs.utils;
import java.io.*;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertyReader {
    private static Properties properties;
    /***
     * 使用static静态代码块读取properties文件，并将文件内容保存在static属性中
     * 高效方便，一次加载，多次使用
     * */
    static {
        loadProps();
    }
    /**
     * 用于加载properties文件
     * 并将properties文件内容加载到定义的properties对象中
     * **/
    synchronized static private void loadProps(){
        log.info("开始加载properties文件内容.........");
        properties=new Properties();
        BufferedReader bufferedReader=null;
        try{
            bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream("src/test/resources/config/config.properties"),"utf-8"));
            System.out.println("加载文件："+bufferedReader);
            properties.load(bufferedReader);
        }catch (FileNotFoundException e){
            log.error("properties文件未找到");
        }catch (IOException e){
            log.error("出现IOException");
        }finally {
            try{
                if(null !=bufferedReader){
                    bufferedReader.close();
                }
            }
            catch (IOException e){
                log.error("properties文件流关闭出现异常");
            }
        }
        log.info("加载properties文件弯成............");
        log.info("properties文件内容："+properties);

    }
    /**
     * 获取指定key的值，若key不存在，则返回null
     * @param key key的值
     * @return 返回属性值
     * **/
    public static String getProperty(String key){
        if(null==properties){
            loadProps();
        }
        return properties.getProperty(key);
    }
    /**
     * 获取指定key的值，若key不存在，则返回null
     * @param key key的值
     * @param defaultValue 默认值
     * @return 返回属性值
     * **/
    public static String getProperty(String key,String defaultValue){
        if(null==properties){
            loadProps();
        }
        return properties.getProperty(key,defaultValue);
    }
    public static void main(String []args){
//        log.info(getProperty("driver.chromeDriverLinux"));
        String str=getProperty("driver.chromeDriver");
        System.out.println(str);
//        try{
//            System.out.println(System.getProperty(new File("").getCanonicalPath()+"\\src\\test\\resources\\download"));
//
//        }catch (Exception e){
//
//        }

    }
}
