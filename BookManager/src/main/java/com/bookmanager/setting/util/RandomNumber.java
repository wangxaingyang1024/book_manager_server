package com.bookmanager.setting.util;

import org.omg.CORBA.INTERNAL;

import java.util.Random;

public class RandomNumber {

    /**
     * 随机生成job_number；
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
}
