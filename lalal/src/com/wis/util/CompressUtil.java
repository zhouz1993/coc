package com.wis.util;

import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;  
import java.util.zip.ZipOutputStream;  

import org.apache.log4j.Logger;
  
/** 
 * 将文件打包成ZIP压缩文件 
 * @author LanP 
 * @since 2012-3-1 15:47 
 */  
public final class CompressUtil {  
	private static final Logger LOG = Logger.getLogger(CompressUtil.class);
    //多个文件打包
    public static boolean fileListToZip(List<File> fileList,String zipFilePath,String fileName) {  
        boolean flag = false;  
        FileInputStream fis = null;  
        BufferedInputStream bis = null;  
        FileOutputStream fos = null;  
        ZipOutputStream zos = null;  
          
        if(null!=fileList&&fileList.size()> 0) {  
        	 try {  
        		 //临时存储文件
        		 File tempFile = new File(zipFilePath);
        		 if(!tempFile.exists()){
        			 tempFile.mkdirs();
        		 }
                 File zipFile = new File(zipFilePath + "/" + fileName);  
                 fos = new FileOutputStream(zipFile);  
                 zos = new ZipOutputStream(new BufferedOutputStream(fos));  
                 byte[] bufs = new byte[1024*10];  
                 for(int i=0;i<fileList.size();i++) {  
                    // 创建ZIP实体,并添加进压缩包  
                 ZipEntry zipEntry = new ZipEntry(fileList.get(i).getName());  
                 zos.putNextEntry(zipEntry);  
                             // 读取待压缩的文件并写进压缩包里  
                 fis = new FileInputStream(fileList.get(i));  
                 bis = new BufferedInputStream(fis,1024*10);  
                 int read = 0;  
                 while((read=bis.read(bufs, 0, 1024*10)) != -1) {  
                          zos.write(bufs, 0, read);  
                    }  
                 }  
                flag = true;  
             } catch (FileNotFoundException e) {  
                // e.printStackTrace();  
                 LOG.error("压缩文件失败");
                 throw new RuntimeException(e); 
                
             } catch (IOException e) {  
               //  e.printStackTrace();  
                 LOG.error("压缩文件失败");
                 throw new RuntimeException(e);  
             } finally {  
                 // 关闭流  
                 try {  
                     if(null != bis) bis.close();  
                     if(null != zos) zos.close();  
                 } catch (IOException e) {  
                 //    e.printStackTrace();  
                     LOG.error("压缩文件失败");
                     throw new RuntimeException(e);  
                 }  
             }  
          
        } else {  
        	  LOG.info("================ 待压缩的文件不存在. ===============");
        }  
          
        return flag;  
    }  
    
      
    /** 
     * 将文件打包成ZIP压缩文件,main方法测试 
     * @param args 
     */  
    public static void main(String[] args) {  
    	List<File> fileList = new ArrayList<File>();
    	File file1 = new File("F:\\ssss.jpg");
    	File file2 = new File("F:\\yoxi.jpg");
    	
    	fileList.add(file1);
    	fileList.add(file2);
    	
    	
        String zipFilePath = "F:\\zip";  
        String fileName = "美图.zip";  
        boolean flag = CompressUtil.fileListToZip(fileList, zipFilePath, fileName); 
        if(flag) {  
            System.out.println(">>>>>> 文件打包成功. <<<<<<");  
        } else {  
            System.out.println(">>>>>> 文件打包失败. <<<<<<");  
        }  
    }  
}  
