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
//        将字符串转换为数字并du输出
        return  str.toString();
    }

    public static List<Integer> StringTransformInteger(String str){
        if(str == "" ){
            return new ArrayList<>();
        }
        List<Integer> idList = Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return idList ;
    }
}
