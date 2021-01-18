## Need to know
- Java SpringBoot2 Application
- SelfSigned certificate for https communication
- Key's for encryption and decryption located outside the application
- All used versions can be seen in pom.xml (actual 18.01.2021)

## Central configuration
- Done in src/main/resources/application.properties
- ToDo: correct location of public and private key

## How to run
- Copy pem files to custom location (src/main/resources/pem)
- Adjust path in application.properties
- command: mvn clean package
- Copy target/encrypt-decrypt-1.2.jar to execution env
- command: java -jar encrypt-decrypt-1.2.jar

## Security
### Https certificate
- Type: self signed
- Algorithm: RSA
- Keysize: 2048
- Storetype: pkc12

### Public key
- Algorithm: RSA
- Keysize: 2048

### Private key
- Algorithm: RSA
- Keysize: 2048