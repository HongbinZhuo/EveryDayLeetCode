package sx0915;

import java.util.Date;

public class time {
    public static void main(String[] args) {
        long date = new Date().getTime();
        System.currentTimeMillis();
        System.out.println(date);
        System.out.println(System.currentTimeMillis());
        Date date1 = new Date();
        date1.getYear();
        System.out.println(  date1.getYear());
        System.out.println(new Date().toString());
    }
}
