package datedatagramclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DatagramTimeClient {
    private int segundos = 0;
    private static String received = "";
    
    public static void main(String[] args) throws InterruptedException {
        while(true){
       
            byte[] sendBuf = new byte[256];
            try {
                DatagramSocket socket = new DatagramSocket();
                byte[] buf = new byte[256];
                InetAddress address = InetAddress.getByName("127.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
                socket.send(packet);
                packet = new DatagramPacket(buf, buf.length);
                socket.setSoTimeout(1000);            
                try{
                    
                    socket.receive(packet);
                    received = new String(packet.getData(), 0, packet.getLength());                 
                    System.out.println("Date: " + received);
                }catch(Exception e){
                    socket.close();
                    System.out.println("Date: " + received);
                }                                    
                Thread.sleep(5000);

            } catch (SocketException ex) {
                Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}