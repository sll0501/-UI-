package com.lyjs.util;

import java.util.Random;

public class MyIncrementGenerator {

    private static String getRandom(int begin,int end){
        String str="";
        Random rd=new Random();
        int number=0;
        while (str.length()==0){
            number=rd.nextInt(end+1);
            if(number>=begin&&number<=end){
                str=String.valueOf((char)number);
            }
        }
        return str;
    }
    public static String number(){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<6;i++){
            if(i==0){
                str.append(getRandom(49,57));
            }else {
                str.append(getRandom(48,57));
            }
        }
        return str.toString();
    }
}
