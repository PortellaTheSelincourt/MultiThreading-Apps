import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.rmi.RemoteException;

public class EncryptionServer implements IEncryptionServer{
    @Override
    public String EncryptInput(String password, String randomText) throws RemoteException {
        //receives input from the use, for a password and a random text and encrypts the random text. this method is called in the Main.java
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(password);
        String encrypted= encryptor.encrypt(randomText);
        return encrypted;
    }

    @Override
    public String DecryptedOutput(String password, String encryptedText) throws RemoteException {
        //receives input from the use, for a password and a encrypted text and decrypts the text. this method is called in the Main.java
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(password);
        String decrypted= encryptor.decrypt(encryptedText);
        return decrypted;
    }
}
