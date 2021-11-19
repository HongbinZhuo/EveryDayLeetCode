package other;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/4 10:39
 */
public class MinSteps {

    public static void main(String[] args) {
        String t = "practice";
        String s = "leetcode";
        minSteps1(s, t);
    }


    public static int minSteps(String s, String t) {
        int length = t.length();
        int result = 0;
        HashMap<Character, Integer> hashT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            hashT.put(ch, hashT.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> hashS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hashS.put(ch, hashS.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : hashT.keySet()) {
            if (hashS.containsKey(ch)) {
                if (hashS.get(ch) > hashT.get(ch)) {
                    result += hashT.get(ch);
                } else {
                    result += hashS.get(ch);
                }
            }
        }

        return length - result;

    }

    public static int minSteps1(String s, String t) {
        int ans = 0;
        char schar[] = s.toCharArray();
        char tchar[] = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        int i=0;
        int j=0;
        while(i<s.length()&&j<s.length()){
            if(schar[i]>tchar[j]){
                j++;
            }
            else if(schar[i]<tchar[j]){
                i++;
            }
            else{
                i++;
                j++;
                ans++;
            }
        }
        return s.length()- ans;
    }
}
