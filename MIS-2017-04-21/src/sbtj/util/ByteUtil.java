/*     */ package sbtj.util;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.nio.charset.Charset;
/*     */ 
/*     */ public class ByteUtil
/*     */ {
/*     */   public static byte[] getBytes(short data)
/*     */   {
/*   8 */     byte[] bytes = new byte[2];
/*   9 */     bytes[0] = (byte)(data & 0xFF);
/*  10 */     bytes[1] = (byte)((data & 0xFF00) >> 8);
/*  11 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(char data)
/*     */   {
/*  16 */     byte[] bytes = new byte[2];
/*  17 */     bytes[0] = (byte)data;
/*  18 */     bytes[1] = (byte)(data >> '\b');
/*  19 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(int data)
/*     */   {
/*  24 */     byte[] bytes = new byte[4];
/*  25 */     bytes[0] = (byte)(data & 0xFF);
/*  26 */     bytes[1] = (byte)((data & 0xFF00) >> 8);
/*  27 */     bytes[2] = (byte)((data & 0xFF0000) >> 16);
/*  28 */     bytes[3] = (byte)((data & 0xFF000000) >> 24);
/*  29 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(long data)
/*     */   {
/*  34 */     byte[] bytes = new byte[8];
/*  35 */     bytes[0] = (byte)(int)(data & 0xFF);
/*  36 */     bytes[1] = (byte)(int)(data >> 8 & 0xFF);
/*  37 */     bytes[2] = (byte)(int)(data >> 16 & 0xFF);
/*  38 */     bytes[3] = (byte)(int)(data >> 24 & 0xFF);
/*  39 */     bytes[4] = (byte)(int)(data >> 32 & 0xFF);
/*  40 */     bytes[5] = (byte)(int)(data >> 40 & 0xFF);
/*  41 */     bytes[6] = (byte)(int)(data >> 48 & 0xFF);
/*  42 */     bytes[7] = (byte)(int)(data >> 56 & 0xFF);
/*  43 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(float data)
/*     */   {
/*  48 */     int intBits = Float.floatToIntBits(data);
/*  49 */     return getBytes(intBits);
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(double data)
/*     */   {
/*  54 */     long intBits = Double.doubleToLongBits(data);
/*  55 */     return getBytes(intBits);
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(String data, String charsetName)
/*     */   {
/*  60 */     Charset charset = Charset.forName(charsetName);
/*  61 */     return data.getBytes(charset);
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(String data)
/*     */   {
/*  66 */     return getBytes(data, "GBK");
/*     */   }
/*     */ 
/*     */   public static short getShort(byte[] bytes)
/*     */   {
/*  72 */     return (short)(0xFF & bytes[0] | 0xFF00 & bytes[1] << 8);
/*     */   }
/*     */ 
/*     */   public static char getChar(byte[] bytes)
/*     */   {
/*  77 */     return (char)(0xFF & bytes[0] | 0xFF00 & bytes[1] << 8);
/*     */   }
/*     */ 
/*     */   public static int getInt(byte[] bytes)
/*     */   {
/*  82 */     return 0xFF & bytes[0] | 0xFF00 & bytes[1] << 8 | 0xFF0000 & bytes[2] << 16 | 0xFF000000 & bytes[3] << 24;
/*     */   }
/*     */ 
/*     */   public static long getLong(byte[] bytes)
/*     */   {
/*  87 */     return 0xFF & bytes[0] | 0xFF00 & bytes[1] << 8 | 0xFF0000 & bytes[2] << 16 | 0xFF000000 & bytes[3] << 24 | 
/*  88 */       0x0 & bytes[4] << 32 | 0x0 & bytes[5] << 40 | 0x0 & bytes[6] << 48 | 0x0 & bytes[7] << 56;
/*     */   }
/*     */ 
/*     */   public static float getFloat(byte[] bytes)
/*     */   {
/*  93 */     return Float.intBitsToFloat(getInt(bytes));
/*     */   }
/*     */ 
/*     */   public static double getDouble(byte[] bytes)
/*     */   {
/*  98 */     long l = getLong(bytes);
/*  99 */     System.out.println(l);
/* 100 */     return Double.longBitsToDouble(l);
/*     */   }
/*     */ 
/*     */   public static String getString(byte[] bytes, String charsetName)
/*     */   {
/* 105 */     return new String(bytes, Charset.forName(charsetName));
/*     */   }
/*     */ 
/*     */   public static String getString(byte[] bytes)
/*     */   {
/* 110 */     return getString(bytes, "GBK");
/*     */   }
/*     */ 
/*     */   public static byte[] bigTosmallBytes(byte[] big) {
/* 114 */     byte[] small = new byte[big.length];
/* 115 */     if (big.length > 0) {
/* 116 */       for (int i = 0; i < big.length; i++) {
/* 117 */         small[i] = big[(big.length - i - 1)];
/*     */       }
/*     */     }
/* 120 */     return small;
/*     */   }
/*     */ }

/* Location:           E:\摩多物联\亲情通一版\hjzx\WEB-INF\classes\
 * Qualified Name:     hjzx.util.ByteUtil
 * JD-Core Version:    0.6.1
 */