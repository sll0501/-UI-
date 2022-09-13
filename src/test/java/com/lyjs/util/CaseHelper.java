package com.lyjs.util;

import com.lyjs.test.base.BaseTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * excel中，这个字段的值为y表示需要执行测试用例，如果为其他的，则表示不执行。
 *
 *   字段中{$d}开头的表示用例说明。{$p}开头的，表示用例需要的预置参数。比如QQ好友发送消息，但是发送消息需要先登录，所以这里可以放登录的用户名和密码。
 * */
public class CaseHelper {
//    根据excel的map 转换为数组 第一个为入参map 第二个为用例说明  第三个参数为执行用例的预置条件
    public static Object[]getObjArrByMap(Map<String,String>caseExcelMap){
        Map<String,String>caseParam=new HashMap<String, String>();
        Map<String,String>caseDesc=new HashMap<String, String>();
        Map<String,String>casePreset=new HashMap<String, String>();
        CaseInfo ci=new CaseInfo();
        for(String key:caseExcelMap.keySet()){
            if(key.indexOf("{$d}")==0){
                caseDesc.put(key.replace("{$d}",""),caseExcelMap.get(key));
            }else if(key.indexOf("{$p}")==0){
                casePreset.put(key.replace("{$p}",""),caseExcelMap.get(key));
            }else {
                String strValue=caseExcelMap.get(key);
                if(!strValue.equals("")){
                    caseParam.put(key,strValue);
                }
            }
        }
        ci.setCaseDesc(caseDesc);
        ci.setCaseParam(caseParam);
        ci.setCasePreset(casePreset);
        return new Object[]{ci};
    }

//    根据excel获取的list转换为Object[][]
    public static Object[][]getObjArrByList(List<Map<String,String>>caseExcelList){
        List<Map<String,String>>caseExcuteList=getExcuteList(caseExcelList);
        Object[][]objArray=new Object[caseExcuteList.size()][];
        for(int i=0;i<caseExcuteList.size();i++){
            objArray[i]=getObjArrByMap(caseExcuteList.get(i));
        }
        return objArray;
    }

//    筛选出需要执行的用例
    private static List<Map<String,String>>getExcuteList(List<Map<String,String>>caseExcelList){
         List<Map<String,String>>list=new ArrayList<Map<String,String>>();
         for(Map<String,String>map:caseExcelList){
             String str=map.get("{$p}isexcute").trim().toLowerCase();
             if(str.equals("y")){
                 list.add(map);
             }
         }
         return list;
    }

//    @DataProvider(name="dataInfo")
//    protected Object[][]dataInfo1(Method m)throws IOException {
//        DataFile d=m.getAnnotation(DataFile.class);
//        Object[][]myObj=null;
//        List<Map<String,String>>list=ReadExcel.readXlsx(d.path());
//        myObj=CaseHelper.getObjArrByList(list);
//        return myObj;
//    }
    public static void main(String []args){
        String caseExcelPath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\lyjs\\test\\data\\11.xlsx";
        List<Map<String,String>>list= ReadExcel.readXlsx(caseExcelPath);
        Object obj[][]=CaseHelper.getObjArrByList(list);
        System.out.println(obj);


    }

}
