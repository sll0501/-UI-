package com.lyjs.test.test.line;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.*;

public class bb {

    /**
     * 两个字符串数组，寻找相同元素的方法
     * */
    public static void getSameList(String[] strArr1, String[] strArr2){
        System.out.println(strArr1);
        System.out.println(strArr2);
        List<String>coll=Arrays.asList(strArr1);
        List<String>coll2=Arrays.asList(strArr2);
        System.out.println(coll);
        System.out.println(coll2);
        List<String>alter0=new ArrayList<String>(coll2);
        List<String>alter1=new ArrayList<String>(coll);
        System.out.println(alter0);
        System.out.println(alter1);
        List<String>alter2=new ArrayList<>(coll);
        alter2.removeAll(alter0);
        alter1.removeAll(alter2);
        Iterator<String>it2=alter1.iterator();
        while (it2.hasNext()){
            System.out.println("数组AB中相同的元素"+it2.next());
        }

    }



    public static void main(String []args){
        /**
         * 两个map
         * */
        Map<String,String>m1=new HashMap<String, String>();
        Map<String,String>m2=new HashMap<String, String>();
        Iterator<Map.Entry<String,String>>iter1=m1.entrySet().iterator();
        while (iter1.hasNext()){
            Map.Entry<String,String>entry1=(Map.Entry<String, String>) iter1.next();
            String m1value=entry1.getValue()==null?"":entry1.getValue();
            String m2value=m2.get(entry1.getKey())==null?"":m2.get(entry1.getKey());
            if(!m1value.equals(m2value)){

            }
        }
        String []strArr1=new String[]{"上海","北京","杭州","南京"};
        String []strArr2=new String[]{"北京","浙江"};
        bb.getSameList(strArr1,strArr2);

//        分支del修改bb类
        System.out.println("分支del修改bb类");

    }
}
