package com.wang.test;

/**
 * Created by Administrator on 2016/6/5.
 */
public class Test {
    public static void main(String[] args) {
        String contents = "@活动";
        System.out.println();
        if(contents.startsWith("@")){
            if(contents.substring(1) !=null ||"".equals(contents.substring(1).trim())){
                System.out.println(contents.substring(1));
                }else {
                System.out.println(2);
                }

            }else{
            System.out.println(3);
            }

    }
}
