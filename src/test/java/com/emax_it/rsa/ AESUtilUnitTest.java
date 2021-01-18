package com.emax_it.rsa;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

class RSAUtilUnitTest implements WithAssertions {

    private static String cipherText = null;
    private static String input = "Die Verschlüsselung funktioniert.";

    @Test
    void givenString_whenEncrypt_thenSuccess()
            throws GeneralSecurityException, IOException {
        // given

        // when
        String cipherTextGen = RSAUtil.encrypt(input, "C:/Daten/temp/public-key.pem");


        // then
        cipherText = cipherTextGen;
        Assertions.assertNotNull(cipherTextGen);
    }

    @Test
    void givenString_whenDecrypt_thenSuccess() throws GeneralSecurityException, IOException {

        //given
        String output = input;

        //when
        String plainText = RSAUtil.decrypt(cipherText,"C:/Daten/temp/private-key-pkcs8.pem");

        //then
        Assertions.assertEquals(output, plainText);
    }
}