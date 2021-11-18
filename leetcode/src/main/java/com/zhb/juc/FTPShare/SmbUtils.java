package com.zhb.juc.FTPShare;//package com.FTPShare;
//
//import com.database.dbplatfrom.data.cache.MapCache;
//import com.database.dbplatfrom.data.common.Constant;
//import com.database.dbplatfrom.data.common.Utils;
//import com.sun.corba.se.impl.orbutil.closure.Constant;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.nio.file.attribute.FileTime;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Properties;
//
///**
// * @description:java访问共享目录
// * @author: Admin
// * @create: 2020-09-05 15:37
// * //test.smbGet("smb://szpcg;jiang.t:xxx@192.168.193.13/Jake/test.txt", "c://") ;
// **/
//public class SmbUtils {
//  /*  public static void main(String[] args) throws Exception {
//         String path= SmbUtils.windowsGet("\\追加样本_文档格式\\1国务院台湾事务办公室.txt");
//         System.out.println(path);
//    }*/
//    /**
//     * @Description:
//     * @Param: [remoteUrl]共享路径
//     * @return: void
//     * @Author: Admins
//     * @Date 2020/9/5 15:51
//     */
//    public static String[] windowsGet(String remoteUrl,String ip) throws Exception {
//        String[] strings=new String[]{"","",""};
//        if(remoteUrl.contains("/")||!remoteUrl.contains(".")){
//            return strings;
//        }
//        InputStream in = null;
//        OutputStream out = null;
//        String localDir= (String) MapCache.getCache(Constant.FILE_TEMP_PATH);
//        File remoteFile=new File("\\\\"+ip+remoteUrl);
//        try {
//            if (!remoteFile.exists()) {
//                System.out.println("共享文件不存在");
//                return strings;
//            }
//            String fileName = remoteFile.getName();
//            File localFile = new File(localDir+fileName);
//            in = new BufferedInputStream(new FileInputStream(remoteFile));
//            out = new BufferedOutputStream(new FileOutputStream(localFile));
//            byte[] buffer = new byte[1024];
//            while (in.read(buffer) != -1) {
//                out.write(buffer);
//                buffer = new byte[1024];
//            }
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = new Date((remoteFile.lastModified()));
//
//            BasicFileAttributes basicFileAttributes = Files.readAttributes(remoteFile.toPath(), BasicFileAttributes.class);
//            FileTime fileTime = basicFileAttributes.creationTime();
//            long l = fileTime.toMillis();
//            Date dateCreatime = new Date(l);
//
//            strings[0]=sdf.format(date);
//            strings[1]=sdf.format(dateCreatime);
//            strings[2]=localFile.getAbsolutePath();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(out!=null)
//                out.close();
//            if(in!=null)
//                 in.close();
//        }
//        return strings;
//    }
//
//
//}
