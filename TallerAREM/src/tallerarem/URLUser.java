/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerarem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author 2114928
 */
public class URLUser {
    public URLUser() throws Exception{
        main();
    }
    public void main() throws Exception {
        //URL google = new URL("http://www.google.com:80/index.html");
        URL google = new URL("http://laboratorio.is.escuelaing.edu.co:80/index.php?page_id=59#122145119436521");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
            
            System.out.println("El protocolo es: " + google.getProtocol());
            System.out.println("La autoridad es: "+ google.getAuthority());
            System.out.println("El host es: "+ google.getHost());
            System.out.println("El puerto es: "+ google.getPort());
            System.out.println("El path es: "+google.getPath());
            System.out.println("La consulta es: "+google.getQuery());
            System.out.println("El nombre del archivo es: "+google.getFile());
            System.out.println("La referencia es: "+google.getRef());
        }catch (IOException x) {
            System.err.println(x);
        }
        
    }

}
