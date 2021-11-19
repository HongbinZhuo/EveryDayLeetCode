package Str;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/28 10:56
 */
//给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

public class LC07_strStr {

    public static void main(String[] args) {
    String haystack = "mississippi", needle = "issip";
        System.out.println(strStr(haystack,needle));
    }



    public static int strStr(String haystack, String needle) {
      if(needle.length()==0) return 0;
      if (haystack.length()<needle.length()) return -1;
      int i=0;
      int j=0;
      int result=0;
      while (i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if (j==needle.length()) {
                   return result=i-needle.length();
                }
            }else {
                i=i-j+1;
                j=0;
            }
      }
      return -1;
    }
}
