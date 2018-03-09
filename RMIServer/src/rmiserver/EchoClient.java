/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author 2114928
 */
public class EchoClient {
    public void ejecutaServicio(String ipRmiregistry, int puertoRmiRegistry,String nombreServicio) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String message ="";
            String lMessage ="";
            Registry registry = LocateRegistry.getRegistry(ipRmiregistry, puertoRmiRegistry);
            EchoServer echoServer = (EchoServer) registry.lookup(nombreServicio);                                
            
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
            while(message!= "adios"){            
                while(echoServer.getNMessage()){
                    if(lMessage!= message){
                        System.out.println(lMessage);
                    }                    
                }
                message =in.readLine();                     
                if(message!=lMessage){
                    System.out.println(echoServer.echo(message));      
                    lMessage = message;
                }
            }            
        } catch (Exception e) {
            System.err.println("Hay un problema:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        EchoClient ec = new EchoClient();
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("Write the IP Direction");            
        String ip=in.readLine(); 
        System.out.println("Write the port of connection");
        String port=in.readLine(); 
        ec.ejecutaServicio("127.0.0.1", 23000, "echoServer");
    }
}
