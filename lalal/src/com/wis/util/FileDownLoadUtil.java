package com.wis.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 下载文件工具类
 * @author WH1409003
 *
 */
public class FileDownLoadUtil {
	private static final Logger LOG = Logger.getLogger(FileDownLoadUtil.class);
	public static void fileDownload(HttpServletResponse response,String path,String fileName){  
		try {	
			fileName = new String(fileName.getBytes("UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
		//response.setContentType("application/octet-stream");
        response.setContentType("multipart/form-data");  
        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)  
        response.setHeader("Content-Disposition", "attachment;fileName="+fileName);  
        ServletOutputStream out;  
        //通过文件路径获得File对象(假如此路径中有一个download.pdf文件)  
        File file = new File(path);  
  
        try {  
            FileInputStream inputStream = new FileInputStream(file);  
            //3.通过response获取ServletOutputStream对象(out)  
            out = response.getOutputStream();  
            int len = 0;  
            byte[] buffer = new byte[1024];  
            while ((len = inputStream.read(buffer)) > 0){
            	out.write(buffer, 0, len);
            }
            inputStream.close();  
            out.close();  
            out.flush();  
  
        } catch (IOException e) {  
            e.printStackTrace(); 
        	LOG.error("下载文件失败");
        }finally{
        	file.delete();
        }  
    }  
}
