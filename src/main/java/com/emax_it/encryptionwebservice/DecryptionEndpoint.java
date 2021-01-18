package com.emax_it.encryptionwebservice;

import com.emax_it.encryption_schema.GetDecryptionRequest;
import com.emax_it.encryption_schema.GetDecryptionResponse;
import com.emax_it.rsa.RSAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Endpoint
public class DecryptionEndpoint {
    private Logger log = LoggerFactory.getLogger(DecryptionEndpoint.class);
    private static final String NAMESPACE_URI = "http://emax-it.com/encryption-schema";

    @Value("${decrypt.private_key}")
    private String private_key;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDecryptionRequest")
    @ResponsePayload
    public GetDecryptionResponse getDecryption(@RequestPayload GetDecryptionRequest request) throws GeneralSecurityException, IOException {
        GetDecryptionResponse response = new GetDecryptionResponse();
        log.trace("getDecryption: " + request.getCipher());

        response.setOutput(RSAUtil.decrypt(request.getCipher(), private_key));
        return response;
    }
}
