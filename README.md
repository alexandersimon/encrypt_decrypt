## Need to know
- Java SpringBoot2 Application
- SelfSigned certificate for https communication
- Key's for encryption and decryption located outside the application
- All used versions can be seen in pom.xml (actual 18.01.2021)

## Central configuration
- Done in src/main/resources/application.properties
- ToDo: correct location of public and private key

## Security
### https certificate
- Type: self signed
- Algorithm: RSA
- Keysize: 2048
- Storetype: pkc12

### public key
- Algorithm: RSA
- Keysize: 2048

### private key
- Algorithm: RSA
- Keysize: 2048