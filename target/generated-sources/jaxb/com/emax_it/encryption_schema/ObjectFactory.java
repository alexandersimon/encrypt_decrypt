//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.01.18 um 05:28:43 PM CET 
//


package com.emax_it.encryption_schema;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emax_it.encryption_schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emax_it.encryption_schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEncryptionRequest }
     * 
     */
    public GetEncryptionRequest createGetEncryptionRequest() {
        return new GetEncryptionRequest();
    }

    /**
     * Create an instance of {@link GetEncryptionResponse }
     * 
     */
    public GetEncryptionResponse createGetEncryptionResponse() {
        return new GetEncryptionResponse();
    }

    /**
     * Create an instance of {@link GetDecryptionRequest }
     * 
     */
    public GetDecryptionRequest createGetDecryptionRequest() {
        return new GetDecryptionRequest();
    }

    /**
     * Create an instance of {@link GetDecryptionResponse }
     * 
     */
    public GetDecryptionResponse createGetDecryptionResponse() {
        return new GetDecryptionResponse();
    }

}
