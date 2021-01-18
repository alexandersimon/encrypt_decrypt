package com.emax_it.rsa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class RSAUtil {
    private static Logger log = LoggerFactory.getLogger(RSAUtil.class);

    public static String encrypt(String input, String public_key) throws GeneralSecurityException, IOException {
        try {

            File pemFile = new File(public_key);

            log.trace("encrypt: " + pemFile.getName());

            RSAPublicKey publicKey = SecurityPemUtils.readX509PublicKey(pemFile);

            log.trace("encrypt publicKey: " + publicKey.getAlgorithm());

            Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] cipherText = cipher.doFinal(input.getBytes());
            return Base64.getEncoder()
                    .encodeToString(cipherText);
        } catch (GeneralSecurityException e) {
            log.warn(e.getMessage());
            throw e;
        } catch (IOException e) {
            log.warn(e.getMessage());
            throw e;
        }
    }

    public static String decrypt(String cipherText, String private_key)
            throws GeneralSecurityException, IOException {
        try {
            File pemFile = new File(private_key);

            log.trace("decrypt: " + pemFile.getName());

            RSAPrivateKey privateKey = SecurityPemUtils.readPKCS8PrivateKey(pemFile);
            log.trace("decrypt privateKey: " + privateKey.getAlgorithm());

            Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] plainText = cipher.doFinal(Base64.getDecoder()
                    .decode(cipherText));
            return new String(plainText);
        } catch (GeneralSecurityException e) {
            log.warn(e.getMessage());
            throw e;
        } catch (IOException e) {
            log.warn(e.getMessage());
            throw e;
        }
    }

}

