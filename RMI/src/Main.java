import java.io.BufferedReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args){
        try {

            String randomtext = "";

        IEncryptionServer stub = (IEncryptionServer) UnicastRemoteObject.exportObject((IEncryptionServer) new EncryptionServer(), 0);   //creates a server
        Registry registry = LocateRegistry.createRegistry(1099);                                                                        //class created waits in this server
        registry.rebind("EncryptionService", stub);                                                                                    //binding stub to the registry

        while(true) {
            Registry registry2 = LocateRegistry.getRegistry();
            IEncryptionServer server = (IEncryptionServer) registry2.lookup("EncryptionService");       // returns stub for IEncryption server
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                           //reads input
            System.out.println("Enter your password");                                                       // asks for an input from the user
            String password = br.readLine();                                                                  //saves users input into a string
            System.out.println("Enter your random text");                                                   // asks for an input from the user
            String randomText = br.readLine();                                                              //saves users input into a string
            String responseMessage = server.EncryptInput(password, randomText);                 //calls the server method to encrypt the random text string and gives it a password
            System.out.println("your encrypted message: "+responseMessage + "\n");              // display encrypted message to the user

            System.out.println("Enter your password");                                            // asks for an input from the user
            String password1 = br.readLine();                                                     //saves users input into a string
            System.out.println("Enter your encrypted text");                                    // asks for an input from the user
            String randomText1 = br.readLine();                                                 //saves users input into a string
            String decryptedMessage = server.DecryptedOutput(password1, randomText1);           //calls the server method to Decrypt the random text string and checks the password
            System.out.println("your decrypted message: " + decryptedMessage + "\n");           // display Decrypted message to the user
        }
        } catch (Exception e) {                         //catches any error

    }

    }
}

