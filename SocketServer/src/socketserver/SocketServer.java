/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author David
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        String outputLine  ="";
        String op = "cos";
        
        while ((inputLine =in.readLine()) != "Bye.") {
            System.out.println("Mensaje: " + inputLine);
            outputLine = "Mensaje Recibido: "+ inputLine;
            if(inputLine.contains("fun:")){                
                if(inputLine.contains("sin")){
                    op = "sin";
                }else if(inputLine.contains("tan")){
                    op = "tan";
                }else if(inputLine.contains("cos")){
                    op = "cos";
                }
            }else{
                outputLine = "Respuesta: " +  doOperation(op, inputLine);;
            }
            out.println(outputLine);
            
            
        }
        /**
        outputLine = "<!DOCTYPE html>"
            + "<html>"
            + "<head>"
            + "<meta charset=\"UTF-8\">"
            + "<title>Title of the document</title>\n"
            + "</head>"
            + "<body>"
            + "My Web Site"
            + "</body>"
            + "</html>" + inputLine;
            * */
        out.println(outputLine);

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    public static double doOperation(String operation, String value){
        double ans =0;
        if(operation.equals("sin")){
            ans = Math.sin(Double.parseDouble(value));
        }else if(operation.equals("cos")){
            ans = Math.cos(Double.parseDouble(value));
        }else{
            ans = Math.tan(Double.parseDouble(value));
        }        
        return ans;
    }
    
    
    
}
