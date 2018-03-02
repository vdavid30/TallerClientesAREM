/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerarem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author 2114928
 */
public class TallerAREM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //System.out.println("Digite la url de la cual desea obtener informacion : ");
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String url = br.readLine(); 
        String url = "localhost:35000";
        WEBApp wb = new WEBApp(url);
        //URLUser ur = new URLUser();
        SocketExample se = new SocketExample();
        
        
    }
    
}
