/*    */ package sbtj.util;
/*    */ 
/*    */ public class ASCIIUtils
/*    */ {
/*    */   public static String bytesToHexString(byte[] src)
/*    */   {
/* 13 */     StringBuilder stringBuilder = new StringBuilder("");
/* 14 */     if ((src == null) || (src.length <= 0)) {
/* 15 */       return null;
/*    */     }
/* 17 */     for (int i = 0; i < src.length; i++) {
/* 18 */       int v = src[i] & 0xFF;
/* 19 */       String hv = Integer.toHexString(v);
/* 20 */       if (hv.length() < 2) {
/* 21 */         stringBuilder.append(0);
/*    */       }
/* 23 */       stringBuilder.append(hv);
/*    */     }
/* 25 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */   public static byte[] hexStringToBytes(String hexString)
/*    */   {
/* 35 */     if ((hexString == null) || (hexString.equals(""))) {
/* 36 */       return null;
/*    */     }
/*    */ 
/* 39 */     int length = hexString.length() / 2;
/* 40 */     char[] hexChars = hexString.toCharArray();
/* 41 */     byte[] d = new byte[length];
/* 42 */     for (int i = 0; i < length; i++) {
/* 43 */       int pos = i * 2;
/* 44 */       d[i] = (byte)(charToByte(hexChars[pos]) << 4 | charToByte(hexChars[(pos + 1)]));
/*    */     }
/* 46 */     return d;
/*    */   }
/*    */ 
/*    */   public static byte charToByte(char c) {
/* 50 */     return (byte)"0123456789abcdef".indexOf(c);
/*    */   }
/*    */ }

/* Location:           E:\摩多物联\亲情通一版\hjzx\WEB-INF\classes\
 * Qualified Name:     hjzx.util.ASCIIUtils
 * JD-Core Version:    0.6.1
 */