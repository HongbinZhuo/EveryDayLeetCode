package sx0914;

import java.util.Arrays;

public class A {
    public static void main(String[] args) {
           int[] a={12,23,26,45,58,60};
        for (int i : MaxMin(a)) {
            System.out.println(i);
        }

//        String A="SASD";
//        System.out.println(new StringBuilder(A).reverse().toString());
//       reverseArray(a);
            insertArr(24,a);
    }
    private static int[] MaxMin(int[] a) {
        int max=a[0];
        int min=a[0];
        for (int i : a) {
            if(i>max){
                max=i;
            } else if (i<min) {
                min=i;
            }
        }
        return new int[]{max, min, (max - min)};
    }
    public  static void reverseArray(int a[]) {
        int temp;
        for (int i = 0; i <= a.length/2; i++) {
            temp = a[i];
            a[i]=a[a.length-i-1];
            a[a.length-i-1]=temp;
        }
    }
    public static void insertArr(int x , int[] a) {
        int b[] = new int[a.length + 1];

        for (int i = 0; i < a.length; i++) {
                b[i]=a[i];
        }
        b[a.length]=x;
        Arrays.sort(b);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+"  ");
        }
    }

}