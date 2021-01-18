package com.emax_it.encryptionwebservice;


import com.emax_it.encryption_schema.GetEncryptionRequest;
import com.emax_it.encryption_schema.GetEncryptionResponse;
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
public class EncryptionEndpoint {

    private Logger log = LoggerFactory.getLogger(EncryptionEndpoint.class);
    private static final String NAMESPACE_URI = "http://emax-it.com/encryption-schema";

    @Value("${encrypt.public_key}")
    private String public_key;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEncryptionRequest")
    @ResponsePayload
    public GetEncryptionResponse getEncryption(@RequestPayload GetEncryptionRequest request) throws GeneralSecurityException, IOException {
        GetEncryptionResponse response = new GetEncryptionResponse();
        log.trace("getEncryption: " + request.getInput());
        response.setOutput(RSAUtil.encrypt(request.getInput(), public_key));
        return response;
    }
}
