package com.zhb.othertechnology.src.MKP;

public class kmpdemo01 {


    public static void main(String[] args) {
        System.out.println(KMP("abcabcabx", "abcabx", 0));
    }






    public static int KMP(String S, String T, int pos) {
        int i = pos - 1;
        int j = -1;
        int next[] = getNext(T);
        while (i < S.length() && j < T.length()) {
            if (j == -1 || S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == T.length()) {
            return i - T.length();
        } else {
            return -1;
        }
    }




    public static int[] getNext(String T) {
        int next[] = new int[T.length()];
        int m = 0;
        int n = -1;
        next[0] = -1;
        while (m < T.length() - 1) {
            if (n == -1 || T.charAt(m) == T.charAt(n)) {
                m++;
                n++;
                if (T.charAt(m) != T.charAt(n)) {
                    next[m] = n;
                } else {
                    next[m] = next[n];
                }
            } else {
                n = next[n];
            }
        }

        return next;
    }
}
