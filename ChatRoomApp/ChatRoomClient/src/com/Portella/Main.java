package com.Portella;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
/**
 * Created by Pedro Portella on 20/12/2018
 */
public class Main {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {                               //you can use localhost or 127.0.0.1, use the same port number as the server '5000'

            socket.setSoTimeout(15000);                                                                //the client will be timed out and the socket will close after 5minutes
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);      //PrintWriter sends an input to the server, set true to automatically flush data out.

            Scanner scanner = new Scanner(System.in);                                                  //reads input from the console
            String echoString;                                                                         //used as transport for the client's message
            String response;
            String nickname;                                                                           //used as transport for the client's nickname

            BufferedReader bufferedReader = new BufferedReader(                                        //Reads text from a character-input stream,
                    new InputStreamReader(System.in)                                                   //it reads bytes and decodes them into characters
            );
            System.out.println("you have entered the chat room.\n\nWhat's your nickname?");            //prints to the console whatever is inside the ""
            nickname = bufferedReader.readLine();                                                      //it reads client's input and saves to a string named 'nickname'
            stringToEcho.println(nickname);                                                            //it echos the string nickname to the server
            do {                                                                                       //Do while loop because we want this to happen at least once
                System.out.println("Enter string to be echoed: ");                                     //prints out a note in the console prompting the user
                echoString = scanner.nextLine();                                                       //ask the user for a string

                stringToEcho.println(echoString);                                                      //uses the string to echo to the server by using the PrintWriter on line 16
                if (!echoString.equals("exit")) {                                                      //checks if the string is equals to exit. if it does the loop is terminated
                    response = echoes.readLine();                                                      //reads teh data coming back from the server.
                    System.out.println(response);                                                      //outputs data back from the server
                }
            }while (!echoString.equals("exit"));                                                       //while loop continues until ''exit'' is typed
        }catch (SocketTimeoutException e) {
            System.out.println("The socket timed out");
        }catch(IOException e) {                                                                       //catches any errors that might happen
            System.out.println("Client Error: " + e.getMessage());                                    //prints error out
        }
    }
}
