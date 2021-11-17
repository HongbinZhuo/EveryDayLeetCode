package com.zhb.leetcodebasic.src.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/30 10:26
 */
public class FizzBuzz {
    public static void main(String[] args) {
      List list= fizzBuzz(15);
        System.out.println();
    }
    public static List<String> fizzBuzz(int n) {
        List<String> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5!=0){
             list.add("Fizz");
            }else if(i%3!=0 && i%5==0){
                list.add("Buzz");
            }else  if(i%3==0 && i%5==0){
                list.add("FizzBuzz");
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
