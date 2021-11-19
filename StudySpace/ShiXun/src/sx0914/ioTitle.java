package sx0914;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ioTitle {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("D:\\StudySpace\\ShiXun\\A");
        int length = in.available();
        byte b[] = new byte[length];
        in.read(b);
        String str = new String(b, "utf-8");
//        System.out.println(str);
        String s[] = str.split("\r\n");
//        for (String s1 : s) {
//            System.out.print(s1);
//        }
        String a = s[0];
//        System.out.println(s[0].trim());
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == ' ') {
            } else {
                System.out.print(a.charAt(i));
            }
        }
//        System.out.println(a.charAt(0)+"1");
        /*一个字节的复制*/
//        int len=0;
//        while((len= fis.read()) != -1){
//                fos.write(len);
//        }
    }
}
