package Str;

import java.util.HashMap;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/28 9:27
 */

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
public class LC04_IsAnagram {
    public static void main(String[] args) {
         String s="anagram",t="nagaram";
        System.out.println(isAnagram(s,t));

    }
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))){
                return false;
            }else {
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
                if(map.get(t.charAt(i))==0){
                    map.remove(t.charAt(i));
                }
            }

        }
        if (map.size()==0) return true;

        return  false;
    }
}
