/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerarem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author David
 */
public class SocketExample {
    public SocketExample() throws IOException{
        Socket echoSocket = null ;
        PrintWriter out = null;
        BufferedReader in = null;
        try{
            echoSocket = new Socket("127.0.0.1", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for "+"the connection to: localhost.");
            System.exit(1);
        }
        BufferedReader stdIn = new BufferedReader (new InputStreamReader(System.in));
        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }
        in.close();
        out.close();
        stdIn.close();
        echoSocket.close();
    
    }
}
