package com.lyjs.test.test.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cc {
    public static void main(String []args){
        String []str=new String[]{"杭州一日游","上海","北京"};
        List<String>list=new ArrayList<>(Arrays.asList(str));
        List<String>list2=new ArrayList<String>();
        list2.add("杭州一日游");
        list2.add("昆山一日游");
        list2.add("上海");list2.add("江苏");list2.add("九华山");
        list2.add("北京");list2.add("昆山");list2.add("崇明");
        for(int i=0;i<list2.size();i++){
            if(list.indexOf(list2.get(i))>=0){
                System.out.println(list2.get(i));
            }
        }
         System.out.println("修改cc文件");
        System.out.println("查看与上次文件的不同");

    }
}
