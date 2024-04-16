/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Efficient;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author DELL
 */
public class encryptimg {
    
   private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5PADDING";

    public static byte[] encryptImage(InputStream imageInputStream, String secretKey, String initVector) throws Exception {
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), ALGORITHM);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = imageInputStream.read(buffer)) != -1) {
            byte[] encryptedBytes = cipher.update(buffer, 0, bytesRead);
            if (encryptedBytes != null) {
                output.write(encryptedBytes);
            }
        }

        byte[] encryptedBytes = cipher.doFinal();
        if (encryptedBytes != null) {
            output.write(encryptedBytes);
        }

        return output.toByteArray();
    }
    
}
