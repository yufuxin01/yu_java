package com.alonginfo.utils;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5的加密类
 *
 * @author rayjp
 * @create 2018-05-26
 **/
public class MD5Util {

    public static String encrypt(String source) {
        return encodeMd5(source.getBytes());
    }

    public static String encrypt(String source,String salt){
        StringBuffer sb = new StringBuffer();
        sb.append(source).append(salt);
        return encodeMd5(sb.toString().getBytes());
    }

    private static String encodeMd5(byte[] source) {
        try {
            return encodeHex(MessageDigest.getInstance("MD5").digest(source));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }


    private static String encodeHex(byte[] bytes) {
        StringBuffer buffer = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10)
                buffer.append("0");
            buffer.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buffer.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        //String ss = "管理员";
        System.out.println(bcdToString("E7AEA1E79086E59198".getBytes()));

        //FileHandler.findSensitive("/Users/raynlf/Downloads/bb.docx", Arrays.asList("系统","地图")).forEach(System.out::println);

    }
    public static String to_MD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String result = "";

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((str).getBytes("UTF-8"));
        byte b[] = md5.digest();

        int i;
        StringBuffer buf = new StringBuffer("");

        for(int offset=0; offset<b.length; offset++){
            i = b[offset];
            if(i<0){
                i+=256;
            }
            if(i<16){
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }

        result = buf.toString();
        return result;
    }

    /**
     * 将String转成BCD码
     *
     * @param s
     * @return
     */
    public static byte [] StrToBCDBytes(String s)
    {

        if(s.length () % 2 != 0)
        {
            s = "0" + s;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream ();
        char [] cs = s.toCharArray ();
        for (int i = 0;i < cs.length;i += 2)
        {
            int high = cs [i] - 48;
            int low = cs [i + 1] - 48;
            baos.write (high << 4 | low);
        }
        return baos.toByteArray ();
    }

    /**
     * 将BCD码转成String
     *
     * @param b
     * @return
     */
    public static String bcdToString(byte [] b){
        StringBuffer sb = new StringBuffer ();
        for (int i = 0;i < b.length;i++ )
        {
            int h = ((b [i] & 0xff) >> 4) + 48;
            sb.append ((char) h);
            int l = (b [i] & 0x0f) + 48;
            sb.append ((char) l);
        }
        return sb.toString () ;
    }

}
