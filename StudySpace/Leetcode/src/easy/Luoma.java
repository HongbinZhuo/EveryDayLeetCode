package easy;

import java.util.HashMap;
import java.util.Scanner;

public class Luoma {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String a = sc.next();
        System.out.println(show("CDM"));
    }

    private static int show(String s) {
        HashMap<Character, Integer> x = new HashMap<>();
        x.put('I', 1);
        x.put('V', 5);
        x.put('X', 10);
        x.put('L', 50);
        x.put('C', 100);
        x.put('D', 500);
        x.put('M', 1000);
        int total = 0;
        for (int i = 0; i < s.length() - 1; ++i) {
            if (x.containsKey(s.charAt(i))) {

                if (x.get(s.charAt(i)) < x.get(s.charAt(i+1) ))
                    total -= x.get(s.charAt(i));
                else {
                    total += x.get(s.charAt(i));
                }
            }
        }
        return total+x.get(s.charAt(s.length()-1));
    }
}
