/*    */ package sbtj.util;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class HttpUtil
/*    */ {
/* 15 */   private static Logger logger = Logger.getLogger(HttpUtil.class);
/* 16 */   private static SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*    */ 
/* 18 */   public static void doURLGet(String url) { BufferedReader l_reader = null;
/* 19 */     InputStreamReader is = null;
/* 20 */     InputStream l_urlStream = null;
/*    */     try {
/* 22 */       String nowdate = formater1.format(new Date());
/* 23 */       logger.debug(nowdate + "GET请求URL：" + url);
/* 24 */       URL l_url = new URL(url);
/* 25 */       HttpURLConnection l_connection = (HttpURLConnection)l_url.openConnection();
/* 26 */       l_connection.setRequestMethod("GET");
/*    */ 
/* 28 */       l_connection.connect();
/*    */ 
/* 30 */       l_urlStream = l_connection.getInputStream();
/* 31 */       is = new InputStreamReader(l_urlStream);
/* 32 */       l_reader = new BufferedReader(is);
/* 33 */       StringBuffer returnstr = new StringBuffer();
/* 34 */       String sCurrentLine = "";
/* 35 */       while ((sCurrentLine = l_reader.readLine()) != null) {
/* 36 */         sCurrentLine = new String(sCurrentLine.getBytes(), "UTF-8");
/* 37 */         returnstr.append(sCurrentLine);
/*    */       }
/* 39 */       logger.debug(nowdate + "GET请求返回消息：" + returnstr.toString());
/*    */     } catch (Exception e) {
/* 41 */       logger.error(e);
/*    */ 
/* 43 */       if (l_reader != null) {
/*    */         try {
/* 45 */           l_reader.close();
/*    */         } catch (IOException e1) {
/* 47 */           e.printStackTrace();
/*    */         }
/*    */       }
/* 50 */       if (is != null) {
/*    */         try {
/* 52 */           is.close();
/*    */         } catch (IOException e1) {
/* 54 */           e.printStackTrace();
/*    */         }
/*    */       }
/* 57 */       if (l_urlStream != null)
/*    */         try {
/* 59 */           l_urlStream.close();
/*    */         } catch (IOException e1) {
/* 61 */           e.printStackTrace();
/*    */         }
/*    */     }
/*    */     finally
/*    */     {
/* 43 */       if (l_reader != null) {
/*    */         try {
/* 45 */           l_reader.close();
/*    */         } catch (IOException e) {
/* 47 */           e.printStackTrace();
/*    */         }
/*    */       }
/* 50 */       if (is != null) {
/*    */         try {
/* 52 */           is.close();
/*    */         } catch (IOException e) {
/* 54 */           e.printStackTrace();
/*    */         }
/*    */       }
/* 57 */       if (l_urlStream != null)
/*    */         try {
/* 59 */           l_urlStream.close();
/*    */         } catch (IOException e) {
/* 61 */           e.printStackTrace();
/*    */         }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\jhpt\WEB-INF\classes\
 * Qualified Name:     jhpt.util.HttpUtil
 * JD-Core Version:    0.6.1
 */