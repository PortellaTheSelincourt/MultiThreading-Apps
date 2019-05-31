import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Pedro Portella on 20/12/2018
 */

public class Echoer extends Thread{
    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
       try{
           BufferedReader input = new BufferedReader(                                             //Reads txt from a character input stream
                   new InputStreamReader(socket.getInputStream()));                               //this will return the input and out put strings associated with the server socket instance.
           PrintWriter output = new PrintWriter(socket.getOutputStream(), true);        //autoFlush is set to true so it automatically flushes the output string that the print writer is using
           String nickname = input.readLine();
           while (true){

               String echoString = input.readLine();                                              //calls in the buffered reader.readLine method
               System.out.println("Client " + nickname + " input: " + echoString);                //this will print the name of the client and his/her message
               if(echoString.equals("exit")){                                                     //if the user types exit on the console the loop
                   break;                                                                         //breaks the loop
               }

               try{
                    Thread.sleep(500);                                                      //Puts the thread to sleep for 15 seconds
               }catch (InterruptedException e) {                                                  //signals errors have occurred
                   System.out.println("thread interrupted");                                      //prints error out
               }
               output.println(echoString);                                                        //prints out user string
           }
       }catch (IOException e) {                                                                   //signals errors have occurred
           System.out.println("Oops: " + e.getMessage());                                         //prints to the screen the error
       }finally {                                                                                 //it will make sure it always execute after exiting
           try{
               socket.close();                                                                    //closes the client socket
           }catch (IOException e) {                                                               //signals errors have occurred
               //oh well!
           }
       }
    }
}
