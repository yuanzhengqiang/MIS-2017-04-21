/*     */ package sbtj.util;
/*     */ 
/*     */ import it.sauronsoftware.base64.Base64;

import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
import java.io.OutputStream;
/*     */ 
/*     */ public class Base64Utils
/*     */ {
/*     */   private static final int CACHE_SIZE = 1024;
/*     */ 
/*     */   public static byte[] decode(String base64)
/*     */     throws Exception
/*     */   {
/*  43 */     return Base64.decode(base64.getBytes());
/*     */   }
/*     */ 
/*     */   public static String encode(byte[] bytes)
/*     */     throws Exception
/*     */   {
/*  56 */     return new String(Base64.encode(bytes));
/*     */   }
/*     */ 
/*     */   public static String encodeFile(String filePath)
/*     */     throws Exception
/*     */   {
/*  72 */     byte[] bytes = fileToByte(filePath);
/*  73 */     return encode(bytes);
/*     */   }
/*     */ 
/*     */   public static void decodeToFile(String filePath, String base64)
/*     */     throws Exception
/*     */   {
/*  86 */     byte[] bytes = decode(base64);
/*  87 */     byteArrayToFile(bytes, filePath);
/*     */   }
/*     */ 
/*     */   public static byte[] fileToByte(String filePath)
/*     */     throws Exception
/*     */   {
/* 100 */     byte[] data = new byte[0];
/* 101 */     File file = new File(filePath);
/* 102 */     if (file.exists()) {
/* 103 */       FileInputStream in = new FileInputStream(file);
/* 104 */       ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
/* 105 */       byte[] cache = new byte[1024];
/* 106 */       int nRead = 0;
/* 107 */       while ((nRead = in.read(cache)) != -1) {
/* 108 */         out.write(cache, 0, nRead);
/* 109 */         out.flush();
/*     */       }
/* 111 */       out.close();
/* 112 */       in.close();
/* 113 */       data = out.toByteArray();
/*     */     }
/* 115 */     return data;
/*     */   }
/*     */ 
/*     */   public static void byteArrayToFile(byte[] bytes, String filePath)
/*     */     throws Exception
/*     */   {
/* 127 */     InputStream in = new ByteArrayInputStream(bytes);
/* 128 */     File destFile = new File(filePath);
/* 129 */     if (!destFile.getParentFile().exists()) {
/* 130 */       destFile.getParentFile().mkdirs();
/*     */     }
/* 132 */     destFile.createNewFile();
/* 133 */     OutputStream out = new FileOutputStream(destFile);
/* 134 */     byte[] cache = new byte[1024];
/* 135 */     int nRead = 0;
/* 136 */     while ((nRead = in.read(cache)) != -1) {
/* 137 */       out.write(cache, 0, nRead);
/* 138 */       out.flush();
/*     */     }
/* 140 */     out.close();
/* 141 */     in.close();
/*     */   }
/*     */ }

/* Location:           E:\jhpt\WEB-INF\classes\
 * Qualified Name:     jhpt.util.Base64Utils
 * JD-Core Version:    0.6.1
 */