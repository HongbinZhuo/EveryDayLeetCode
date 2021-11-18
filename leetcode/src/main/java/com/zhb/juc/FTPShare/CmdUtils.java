package com.zhb.juc.FTPShare;//package com.FTPShare;
//
//import com.database.dbplatfrom.data.common.Constant;
//import com.sun.corba.se.impl.orbutil.closure.Constant;
//import org.apache.commons.lang.StringUtils;
//
//import java.io.*;
//import java.nio.charset.Charset;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
///**
// * @description:
// * @author: Admin
// * @create: 2020-09-08 13:21
// **/
//public class CmdUtils {
//
//    public static void main(String[] args) {
//        Map<String, String> sftpDetails =new HashMap<>();
//        sftpDetails.put(Constant.SFTP_REQ_HOST, "172.16.3.14");
//        sftpDetails.put(Constant.SFTP_REQ_USERNAME,"zjm" );
//        sftpDetails.put(Constant.SFTP_REQ_PASSWORD,"@tips8000");
//        boolean cmdResult = getCmdResult( sftpDetails);
//        System.out.println(cmdResult);
//    }
//
//    public static boolean getCmdResult(Map<String, String> sftpDetails) {
//        String ftpHost = sftpDetails.get(Constant.WINDOWS_PUBLIC_IP);
//        String ftpUserName =sftpDetails.get(Constant.WINDOWS_PUBLIC_USERNAME);
//        String ftpPassword =sftpDetails.get(Constant.WINDOWS_PUBLIC_PASSWORD);
//        String result = "";
//        String cmd="";
//        if(ftpHost==null)return false;
//        boolean re=false;
//        try {
//            //net use \\172.16.3.14 @tips8000 /USER:zjm
//            String delete=" net use \\\\"+ftpHost+" /delete";
//            if(StringUtils.isEmpty(ftpUserName)||StringUtils.isEmpty(ftpPassword)){
//                 cmd="net use \\\\"+ftpHost;
//            }else{
//                 cmd="net use \\\\"+ftpHost+" "+ftpPassword+" /USER:"+ftpUserName;
//            }
//            Runtime.getRuntime().exec(delete);
//            Process process=Runtime.getRuntime().exec(cmd);
//            // 标准错误流（必须写在 waitFor 之前）
//            String errStr = consumeInputStream(process.getErrorStream());
//            //标准输入流（必须写在 waitFor 之前）
//            result=consumeInputStream(process.getInputStream());
//            process.waitFor();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//        }
//        if(result.contains("成功"))re=true;
//        return re;
//    }
//
//    public static String consumeInputStream(InputStream input){
//        String result="";
//        InputStreamReader ir = new InputStreamReader(input, Charset.forName("GBK"));
//        BufferedReader br =null;
//        try{
//            br= new BufferedReader(ir);
//            String line;
//            while ((line = br.readLine()) != null){
//                result+=line;
//            }
//            br.close();
//        }catch (Exception ex){
//            try {
//                if (null != br) {
//                    br.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//
//
//
//}
