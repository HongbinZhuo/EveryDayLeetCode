package easy;

import java.util.Scanner;

public class huiwenshu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        boolean result;
        result=isPalindrome2(Integer.parseInt(a)) ;
        System.out.println(result);
    }

    private static boolean isHuiWen(String a) {
        boolean s=false;
        if(a.charAt(0)=='-') return s;
        if (new StringBuilder(a).reverse().toString().equals(a))
            s=true;
        return s;
    }
    public boolean isPalindrome(int x) {
        String b= String.valueOf(x);
        boolean s=false;
        if(b.charAt(0)=='-') return s;
        if (new StringBuilder(b).reverse().toString().equals(b))
            s=true;
        return s;
    }
    public static boolean isPalindrome2(int x) {
        String b= String.valueOf(x);
        if(b.charAt(0)=='-') return false;
        int j=b.length()-1;
        for (int i = 0; i <b.length()/2 ; i++) {
             if (b.charAt(i)==b.charAt(j-i)) return true;

        }
        return false;
    }
}
