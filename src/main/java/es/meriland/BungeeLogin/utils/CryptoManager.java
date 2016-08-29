package es.meriland.BungeeLogin.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by Alvaro on 29/8/16.
 */
public class CryptoManager {

    private MessageDigest digester;

    public CryptoManager (String algorithm) throws NoSuchAlgorithmException {
         this.digester = MessageDigest.getInstance(algorithm);
    }

    public byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return bytes;
    }

    public byte[] getHashWithSalt(String input, byte[] salt) throws UnsupportedEncodingException {
        this.digester.reset();
        this.digester.update(salt);
        return this.digester.digest(input.getBytes("UTF-8"));
    }
}
