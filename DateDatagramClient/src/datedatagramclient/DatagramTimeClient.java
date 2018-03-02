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
    private static Timer timer; 
    class Contador extends TimerTask {
        public void run() {
            segundos++;
            System.out.println("segundo: " + segundos);
        }
    }
    public static void main(String[] args) {
        byte[] sendBuf = new byte[256];
        try {
            timer = new Timer();
            timer.schedule(new Contador(), 0, 1000);
            
            
            
            DatagramSocket socket = new DatagramSocket();
            byte[] buf = new byte[256];
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Date: " + received);
            
            packet = new DatagramPacket(buf, buf.length, address, 4445);                        
            socket.send(packet);
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Date: " + received);
        } catch (SocketException ex) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}