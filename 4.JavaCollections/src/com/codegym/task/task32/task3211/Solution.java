package com.codegym.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Data integrity

*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); // true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(byteArrayOutputStream.toByteArray());

        byte[] messageDigest = md.digest();

        StringBuilder hexString = new StringBuilder();
        for (byte messageDigestByte : messageDigest) {
            String h = Integer.toHexString(0xFF & messageDigestByte);
            while (h.length() < 2)
                h = "0" + h;
            hexString.append(h);
        }

        String hashStr = hexString.toString();
        return hashStr.equals(md5);
    }
}
