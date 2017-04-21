/*    */ package sbtj.util;
/*    */ 
/*    */ import java.security.MessageDigest;
/*    */ 
/*    */ public class Md5Utils
/*    */ {
/*    */   public static final String MD5(String s)
/*    */   {
/* 14 */     char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*    */     try {
/* 16 */       byte[] strTemp = s.getBytes();
/*    */ 
/* 18 */       MessageDigest mdTemp = MessageDigest.getInstance("MD5");
/* 19 */       mdTemp.update(strTemp);
/* 20 */       byte[] md = mdTemp.digest();
/* 21 */       int j = md.length;
/* 22 */       char[] str = new char[j * 2];
/*    */ 
/* 24 */       int k = 0;
/* 25 */       for (int i = 0; i < j; i++) {
/* 26 */         byte b = md[i];
/*    */ 
/* 28 */         str[(k++)] = hexDigits[(b >> 4 & 0xF)];
/* 29 */         str[(k++)] = hexDigits[(b & 0xF)];
/*    */       }
/* 31 */       return new String(str); } catch (Exception e) {
/*    */     }
/* 33 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\jhpt\WEB-INF\classes\
 * Qualified Name:     jhpt.util.Md5Utils
 * JD-Core Version:    0.6.1
 */