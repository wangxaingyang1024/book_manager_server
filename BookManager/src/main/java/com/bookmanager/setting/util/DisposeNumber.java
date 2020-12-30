package com.bookmanager.setting.util;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DisposeNumber {

    /**
     *
     * @param num  生成随机数的位数
     * @return
     */
    public static String NumberUUID(Integer num){
        StringBuilder str=new StringBuilder();//定义变长字符串bai
        Random random=new Random();
        //随机生成数字，并添加到字符串
        for(int i=0;i<num;i++){
            str.append(random.nextInt(10));
        }
        if ("0".equals(str.substring(0,1))){
            NumberUUID(num);
        }
        return  str.toString();
    }

    /**
     * 生成数字字母下划线的字符串
     * @param num
     * @return
     */
    public static String randomString(int num){
        StringBuffer stringBuffer=new StringBuffer();
        int randomIndex;
        char []randomChar={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L',
                'M','N','0','P','Q','R','S','T','U','V','W','X','Y','Z','_'};
        for(int i=0;i<num;i++) {
            randomIndex = (int) (Math.random() * randomChar.length);
            stringBuffer.append(String.valueOf(randomChar[randomIndex]));
        }
        return stringBuffer.toString();
    }


    public static List<Integer> StringTransformInteger(String str){
        if(str == "" ){
            return new ArrayList<>();
        }
        List<Integer> idList = Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return idList ;
    }
}
