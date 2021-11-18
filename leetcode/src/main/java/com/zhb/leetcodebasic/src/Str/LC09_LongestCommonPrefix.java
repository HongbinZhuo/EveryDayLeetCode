package com.zhb.leetcodebasic.src.Str;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/28 14:33
 */
//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。

public class LC09_LongestCommonPrefix {
    public static void main(String[] args) {
     String[]  strs=new String[]{"flower","flow","flight"};
//     String[] str = {"1","2","3"};
        System.out.println(longestCommonPrefix(strs));

        char a='a';
        System.out.println('a'-'b');
    }
    public static  String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int count=strs[0].length();
        for (int i = 0; i < count; i++) {

            char c = strs[0].charAt(i);

            for (int j = 0; j <  strs.length; j++) {
                if(i==strs[j].length() || strs[j].charAt(i)!=c){
                    return strs[0].substring(0, i);
                }
            }
        }
                 return strs[0];

    }
}
