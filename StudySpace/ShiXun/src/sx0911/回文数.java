package sx0911;

public class 回文数 {
    public static void main(String[] args) {
        for (int i = 100; i <= 10000; i++) {
            if(isPalindrome(i)==true)
                System.out.println(i);

        }

        }
    public static boolean isPalindrome(int x) {
        String b = String.valueOf(x);
        boolean s = false;
        if (b.charAt(0) == '-') return s;
        if (new StringBuilder(b).reverse().toString().equals(b))
            s = true;
        return s;
    }
    }
