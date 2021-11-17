package com.zhb.leetcodebasic.src.other;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/30 15:35
 */
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//有效字符串需满足：
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。

public class LC_01 {
    public static void main(String[] args) {

    }
    public static  boolean  isValid(String s) {
        int length=s.length();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');
     Stack<Character> stack=new Stack<>();

        for (int i = 0; i < length; i++) {
         char ch=s.charAt(i);
         if(hashMap.containsKey(ch)){
             if(stack.empty()||stack.peek()!=hashMap.get(ch)) {
                 return false;
             }
             //出栈
             stack.pop();
         }else{
             stack.push(ch);
         }
        }

        return  stack.empty();
    }
}
