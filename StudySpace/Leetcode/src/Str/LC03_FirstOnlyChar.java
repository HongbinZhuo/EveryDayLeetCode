package Str;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/28 8:55
 */


//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
public class LC03_FirstOnlyChar {
    public static void main(String[] args) {
            String s="loveleetcode";
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.charAt(i));
//        }
        System.out.println( firstUniqChar(s));

    }

    public static int firstUniqChar(String s) {

        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

            return -1;
        }
}
