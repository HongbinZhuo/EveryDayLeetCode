package Str;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/28 9:42
 */

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
public class LC05HuiWenStr {
    public static void main(String[] args) {
      String s= "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
      //  String resultStr = s.replaceAll("[0-9a-zA-Z]","*").toLowerCase();
    }

    public  static boolean isPalindrome(String s) {
        if("".equals(s)) return true;
        String resultStr = s.replaceAll("[^0-9a-zA-Z]","").toLowerCase();
        char[] result = resultStr.toCharArray();

        for (int i = 0; i < result.length/2; i++) {
            if (result[i]!=result[result.length-1-i]) return false;
        }
        return true;

    }
}
