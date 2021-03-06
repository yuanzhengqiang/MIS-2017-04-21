package sbtj.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * @description 文件工具类
 * @author feng.gu
 * @date 2012-2-6
 */
public class FileUtil {
	/**
	 * 获取系统文件分隔符
	 * @return linux为/ windows为\
	 */
	public static String getFileSeparator(){
		String fs = System.getProperties().getProperty("file.separator");
		return fs;
	}
	/**
	 * 写文件
	 * @param filePath 文件路径
	 * @param head 文件头
	 * @param content 文件内容
	 */
	public static void writeFile(String filePath,String content){
		FileWriter fw = null;
		BufferedWriter bw = null;
		FileReader fr  = null;
		BufferedReader buf =null;
		StringBuffer sb = new StringBuffer();
		try {	
			 //判断记录文件是否存在
			 File file = new File(filePath);			
			 if(!file.exists()){
				 File f = new File(filePath.substring(0, filePath.lastIndexOf(getFileSeparator())));
					//路径不存在 ，创建文件夹
					if(!f.isDirectory()){
						f.mkdirs();
					}	
					
			 }
			if(content!=null&&!"".equals(content.trim())){
			    	sb.append(content);
			}	
			//将content写入
			fw = new FileWriter(file);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
			bw.write(sb.toString());	
		  }
		  catch (Exception e) {
			  e.printStackTrace();;			  
		  }finally{
		    try {		    	
		      if(bw!=null){
		    	 bw.close(); 
		    	 bw=null;
			  }
		      if(fw!=null){
		    	 fw.close(); 
		    	 fw=null;
			  }
		      if(fr!=null){
		    	 fr.close(); 
		    	 fr=null;
			  }
		      if(buf!=null){
		    	 buf.close(); 
		    	 buf=null;
			  }
		    }
		    catch (IOException e) {
		    	e.printStackTrace();
		    }
		  }
	}
	
	/**
	 * 写文件
	 * @param filePath 文件路径
	 * @param head 文件头
	 * @param content 文件内容
	 */
	public static void writeHeadFile(String filePath,String head,String content){
		FileWriter fw = null;
		BufferedWriter bw = null;
		FileReader fr  = null;
		BufferedReader buf =null;
		StringBuffer sb = new StringBuffer();
		try {	
			 //判断记录文件是否存在
			 File file = new File(filePath);			
			 if(!file.exists()){
				 File f = new File(filePath.substring(0, filePath.lastIndexOf(getFileSeparator())));
					//路径不存在 ，创建文件夹
					if(!f.isDirectory()){
						f.mkdirs();
					}
			    if(head!=null&&!"".equals(head.trim())){
			    	sb.append(head+"\r\n"+content+"\r\n");
			    }			
			 }else{
				 fr = new FileReader(file); 
				 buf = new BufferedReader(fr);
				 String s = buf.readLine();
				 sb.append(s+"\r\n"+content+"\r\n");
				 while(s!=null)
				 {
				     s =buf.readLine();
				     if(s!=null){
				    	 sb.append(s+"\r\n");
				     }				     
				 }
			 }			
			//将content写入
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(sb.toString());					 				 			
		  }
		  catch (Exception e) {
			  e.printStackTrace();;			  
		  }finally{
		    try {		    	
		      if(bw!=null){
		    	 bw.close(); 
		    	 bw=null;
			  }
		      if(fw!=null){
		    	 fw.close(); 
		    	 fw=null;
			  }
		      if(fr!=null){
		    	 fr.close(); 
		    	 fr=null;
			  }
		      if(buf!=null){
		    	 buf.close(); 
		    	 buf=null;
			  }
		    }
		    catch (IOException e) {
		    	e.printStackTrace();
		    }
		  }
	}
	/**
	 * 创建空文件
	 * @param filePath 文件路径
	 * @param head 文件头
	 * @param content 文件内容
	 */
	public static void mkdirFile(String filePath){
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {	
			 //判断记录文件是否存在
			 File file = new File(filePath);			
			 if(!file.exists()){
				 File f = new File(filePath.substring(0, filePath.lastIndexOf(getFileSeparator())));
					//路径不存在 ，创建文件夹
					if(!f.isDirectory()){
						f.mkdirs();
					}			   	
			 }
			//将content写入
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			bw.write("");					 				 			
		  }
		  catch (Exception e) {
			  e.printStackTrace();
		  }finally{
		    try {		    	
		      if(bw!=null){
		    	 bw.close(); 
		    	 bw=null;
			  }
		      if(fw!=null){
		    	 fw.close(); 
		    	 fw=null;
			  }
		    }
		    catch (IOException e) {
		    	e.printStackTrace();
		    }
		  }
	}
	
	/**
	 * 读取配置项文件方法
	 * @param filePath 配置文件路径
	 * @return 配置集合
	 */
	public static Properties readProperties(String filePath){
		InputStream in = null;
		Properties pros = new Properties();
		try {
			in = new FileInputStream(filePath);			
			pros.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		    try {
		      in.close();
		    }catch (IOException e1){
		    	e1.printStackTrace();
		    }
		}
		return pros;		
	}
	
	/**
	 * 读取配置项文件方法
	 * @param fileName 配置文件名称
	 * @return 配置集合
	 */
	public static Properties readPropertiesByFileName(String fileName){
		InputStream in = null;
		Properties pros = new Properties();
		try {
			String path=Thread.currentThread().getContextClassLoader().getResource("").toString();
			String separator = FileUtil.getFileSeparator();
			String projectName = FileUtil.getProjectName();
			if("file".equals(path.substring(0, 4))){
				if("\\".equals(separator)){
					path = path.substring(6);
				}else{
					path = path.substring(5);
				}					
			}
			String localPath =path.substring(0, path.indexOf("webapps"))+"webapps"+separator+projectName+separator+"WEB-INF"+separator+"conf"+separator+fileName;
			localPath=URLDecoder.decode(localPath);
			localPath = localPath.replace("/", separator);
			localPath = localPath.replace("\\", separator);			 
			in = new FileInputStream(localPath);			
			pros.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		    try {
		      in.close();
		    }catch (IOException e1){
		    	e1.printStackTrace();
		    }
		}
		return pros;		
	}
	
	/**
	 * 读取配置项文件方法
	 * @param in 文件流
	 * @return 配置集合
	 */
	public static Properties readProperties(InputStream in){
		Properties pros = new Properties();
		try {		
			pros.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		    try {
		      in.close();
		    }catch (IOException e1){
		    	e1.printStackTrace();
		    }
		}
		return pros;		
	}
	
	/**
	 * 获取应用名称方法
	 * @return 应用名称
	 */
	public static String getProjectName(){
		String projectName = "";
		try {
			String path=Thread.currentThread().getContextClassLoader().getResource("").toString();
			if(path.indexOf("webapps/")>0){
				String[] sage = path.split("webapps/");
				if(sage!=null&&sage.length>0){
					String[] temp = sage[1].split("/");
					if(temp!=null&&temp.length>0){
						projectName = temp[0];
					}
				}
			}else if(path.indexOf("bin/")>0){
				String[] sage = path.split("bin/");
				if(sage!=null&&sage.length>0){
					String[] temp = sage[0].split("/");
					if(temp!=null&&temp.length>0){
						projectName = temp[temp.length-1];
					}
				}
			}else if(path.indexOf("WebRoot/")>0){
				String[] sage = path.split("WebRoot/");
				if(sage!=null&&sage.length>0){
					String[] temp = sage[0].split("/");
					if(temp!=null&&temp.length>0){
						projectName = temp[temp.length-1];
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectName;		
	}
	
	/**
	 * 获取tomcat路径WEB-INF
	 * @return 
	 */
	public static String getTomcatPath(){
		String localPath = "";
		try {
			String path=Thread.currentThread().getContextClassLoader().getResource("").toString();
			String separator = FileUtil.getFileSeparator();
			String projectName = FileUtil.getProjectName();
			if("file".equals(path.substring(0, 4))){
				if("\\".equals(separator)){
					path = path.substring(6);
				}else{
					path = path.substring(5);
				}					
			}
			localPath =path.substring(0, path.indexOf("webapps"))+"webapps"+separator+projectName+separator+"WEB-INF";
			localPath=URLDecoder.decode(localPath);
			localPath = localPath.replace("/", separator);
			localPath = localPath.replace("\\", separator);				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return localPath;		
	}
	
	/**
	 * 获取源码路径src
	 * @return 
	 */
	public static String getSrcPath(){
		String localPath = "";
		String separator = FileUtil.getFileSeparator();
		String projectName = FileUtil.getProjectName();
		try {	
		  String path=Thread.currentThread().getContextClassLoader().getResource("").toString();
  	      if ("file".equals(path.substring(0, 4))) {
  	        if ("\\".equals(separator))
  	          path = path.substring(6);
  	        else {
  	          path = path.substring(5);
  	        }
  	      }	   
			localPath =path.substring(0, path.indexOf(projectName))+projectName+separator+"src";
			localPath=URLDecoder.decode(localPath);
			localPath = localPath.replace("/", separator);
			localPath = localPath.replace("\\", separator);				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return localPath;		
	}
	
	/**
	 * 获取源码路径view
	 * @return 
	 */
	public static String getViewPath(){
		String localPath = "";
		String separator = FileUtil.getFileSeparator();
		String projectName = FileUtil.getProjectName();
		try {	
		  String path=Thread.currentThread().getContextClassLoader().getResource("").toString();
  	      if ("file".equals(path.substring(0, 4))) {
  	        if ("\\".equals(separator))
  	          path = path.substring(6);
  	        else {
  	          path = path.substring(5);
  	        }
  	      }	   
			localPath =path.substring(0, path.indexOf(projectName))+projectName+separator+"WebRoot"+separator+"view";
			localPath=URLDecoder.decode(localPath);
			localPath = localPath.replace("/", separator);
			localPath = localPath.replace("\\", separator);				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return localPath;		
	}

}
