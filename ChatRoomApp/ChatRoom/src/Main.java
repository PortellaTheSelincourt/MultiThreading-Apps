import java.io.IOException;
import java.net.ServerSocket;
/**
 * Created by Pedro Portella on 20/12/2018
 */
public class Main {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {                         //Creates a SERVER socket, with port 5000
            while(true){                                                                        //we are creating an infinite loop here
                new Echoer(serverSocket.accept()).start();                                      //calls the Echoer class, this class allow for a new thread to kick off every time there is a new connection
            }
        }catch(IOException e) {                                                                 //signals errors have occurred
            System.out.println("Server exception " + e.getMessage());                           //prints error out
        }
    }
}
