package com.idyl.manager.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**  
 * MD5��������ժҪ  
 * @author   Bill  
 * @version  1.0.0  
 * @2010-2-24 ����03:04:53  
 */


public class MD5Builder {
    static Logger logger = Logger.getLogger(MD5Builder.class);
  
    // �������ֽ�ת���� 16 ���Ʊ�ʾ���ַ�   
    static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',   
            '9', 'a', 'b', 'c', 'd', 'e', 'f' };   
  
    /** */  
    /**  
     * ���ļ�ȫ������MD5ժҪ  
     * @param file   Ҫ���ܵ��ļ�  
     * @return MD5ժҪ��  
     */  
    public static String getMD5(File file) {   
        FileInputStream fis = null;   
        try {   
            MessageDigest md = MessageDigest.getInstance("MD5");   
  
            logger.info("MD5ժҪ���ȣ�" + md.getDigestLength());   
            fis = new FileInputStream(file);   
            byte[] buffer = new byte[2048];   
            int length = -1;   
            logger.info("��ʼ����ժҪ");   
            long s = System.currentTimeMillis();   
            while ((length = fis.read(buffer)) != -1) {   
                md.update(buffer, 0, length);   
            }   
            logger.info("ժҪ���ɳɹ�,����ʱ: " + (System.currentTimeMillis() - s)   
                    + "ms");   
            byte[] b = md.digest();   
            return byteToHexStringSingle(b);//byteToHexString(b);   
            // 16λ����   
            // return buf.toString().substring(8, 24);   
        } catch (Exception ex) {   
            logger.error(ex);   
            ex.printStackTrace();   
            return null;   
        } finally {   
            try {   
                fis.close();   
            } catch (IOException ex) {   
                ex.printStackTrace();   
            }   
        }   
    }   
  
    /** */  
    /**  
     * ��һ��String����MD5������Ϣ  
     * @param message Ҫ���ܵ�String  
     * @return ���ɵ�MD5��Ϣ  
     */  
    public static String getMD5(String message) {   
        try {   
            MessageDigest md = MessageDigest.getInstance("MD5");   
            //logger.info("MD5ժҪ���ȣ�" + md.getDigestLength());   
            //System.out.println("MD5ժҪ���ȣ�" + md.getDigestLength());
            byte[] b = md.digest(message.getBytes("utf-8"));   
            return byteToHexStringSingle(b);//byteToHexString(b);   
        } catch (NoSuchAlgorithmException e) {   
            logger.error(e);   
            e.printStackTrace();   
        } catch (UnsupportedEncodingException e) {   
            logger.error(e);   
            e.printStackTrace();   
        }   
        return null;   
    }   
  
    @Deprecated  
    /** */  
    /**  
     * ��byte[]����ת����ʮ�������ַ�����ʾ��ʽ  
     * @param tmp    Ҫת����byte[]  
     * @return ʮ�������ַ�����ʾ��ʽ  
     */  
    private static String byteToHexString(byte[] tmp) {   
        String s;   
        // ���ֽڱ�ʾ���� 16 ���ֽ�   
        char str[] = new char[16 * 2]; // ÿ���ֽ��� 16 ���Ʊ�ʾ�Ļ���ʹ�������ַ���   
        // ���Ա�ʾ�� 16 ������Ҫ 32 ���ַ�   
        int k = 0; // ��ʾת������ж�Ӧ���ַ�λ��   
        for (int i = 0; i < 16; i++) { // �ӵ�һ���ֽڿ�ʼ���� MD5 ��ÿһ���ֽ�   
            // ת���� 16 �����ַ���ת��   
            byte byte0 = tmp[i]; // ȡ�� i ���ֽ�   
            str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // ȡ�ֽ��и� 4 λ������ת��,    
            // >>> Ϊ�߼����ƣ�������λһ������   
            str[k++] = hexDigits[byte0 & 0xf]; // ȡ�ֽ��е� 4 λ������ת��   
        }   
        s = new String(str); // ����Ľ��ת��Ϊ�ַ���   
        return s;   
    }   
  
    /**  
     * ������byte[]����ת����ʮ�������ַ�����ʾ��ʽ  
     * @author Bill  
     * @create 2010-2-24 ����03:26:53  
     * @since   
     * @param byteArray  
     * @return  
     */  
    public static String byteToHexStringSingle(byte[] byteArray) {   
        StringBuffer md5StrBuff = new StringBuffer();   
  
        for (int i = 0; i < byteArray.length; i++) {   
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)   
                md5StrBuff.append("0").append(   
                        Integer.toHexString(0xFF & byteArray[i]));   
            else  
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));   
        }   
  
        return md5StrBuff.toString();   
    }   
  
    /**  
     * @author Bill  
     * @create 2010-2-24 ����03:04:53  
     * @since  
     * @param args  
     */  
    public static void main(String[] args) {   
        //logger.info(getMD5("admin")); 
    	System.out.println(getMD5("1"));
    }   
  
}   
