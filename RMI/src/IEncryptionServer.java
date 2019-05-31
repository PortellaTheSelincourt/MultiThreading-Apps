import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEncryptionServer extends Remote {
    //method signatures of what the application can do
    String EncryptInput(String password, String randomText)throws RemoteException;               //encrypts random txt and gives a password to that encryption
    String DecryptedOutput (String password, String encryptedText)throws RemoteException;        //dencrypts random txt with given password

}
