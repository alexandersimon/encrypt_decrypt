package com.emax_it.rsa;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecurityPemUtilsUnitTest {

    @Test
    public void whenReadPublicKeyFromPEMFile_thenSuccess() throws Exception {
        File pemFile = new File(SecurityPemUtilsUnitTest.class.getResource("/pem/public-key.pem").getFile());

        RSAPublicKey publicKey = SecurityPemUtils.readX509PublicKey(pemFile);

        assertEquals("X.509", publicKey.getFormat());
        assertEquals("RSA", publicKey.getAlgorithm());
    }

    @Test
    public void whenReadPrivateKeyFromPEMFile_thenSuccess() throws Exception {
        File pemFile = new File(SecurityPemUtilsUnitTest.class.getResource("/pem/private-key-pkcs8.pem").getFile());

        RSAPrivateKey privateKey = SecurityPemUtils.readPKCS8PrivateKey(pemFile);

        assertEquals("PKCS#8", privateKey.getFormat());
        assertEquals("RSA", privateKey.getAlgorithm());
    }
}
