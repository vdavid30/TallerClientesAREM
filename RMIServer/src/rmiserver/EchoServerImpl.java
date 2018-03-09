/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author 2114928
 */
public class EchoServerImpl implements EchoServer{
    public String last = "Conversation begin";
    public boolean nMessage = false;
    public EchoServerImpl(String ipRMIregistry, int puertoRMIregistry, String nombreDePublicacion){
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {            
            EchoServer echoServer = (EchoServer) UnicastRemoteObject.exportObject(this,0);
            Registry registry = LocateRegistry.getRegistry(ipRMIregistry, puertoRMIregistry);
            registry.rebind(nombreDePublicacion, echoServer);
            System.out.println("Echo server ready...");
            
        } catch (Exception e) {
           System.err.println("Echo server exception:");
            e.printStackTrace();
        }

    }

    public String echo(String cadena) throws RemoteException {        
        nMessage = true;
        last = cadena;      
        return "Send : " + last;
    }
    public String getLMessage() throws RemoteException{
        System.out.println("GETEOOOOOOO");
        nMessage = false;
        return "Send : " + last;
    }
    public boolean getNMessage() throws RemoteException{
        return nMessage;
    }
    public static void main(String[] args){
        EchoServerImpl ec = new EchoServerImpl("127.0.0.1", 23000, "echoServer");
    }
}
