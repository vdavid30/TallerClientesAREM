/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerarem;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author 2114928
 */
public class WEBApp {
    public WEBApp(String url) throws MalformedURLException, IOException{
        procesarInformacion(url);
    }
    public void procesarInformacion(String url) throws MalformedURLException, IOException{
        //URL google = new URL("http://campusvirtual.escuelaing.edu.co:80/moodle/course/view.php?id=892");
        
        FileWriter filewriter = new FileWriter("resultado.html");
        PrintWriter printw = new PrintWriter(filewriter);        
        URL page = new URL(url);
        String content = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(page.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                content.concat(inputLine);
            }
        }catch (IOException x) {
            System.err.println(x);
        }
        /**
        System.out.println("El protocolo es: " + page.getProtocol());
        System.out.println("La autoridad es: "+ page.getAuthority());
        System.out.println("El host es: "+ page.getHost());
        System.out.println("El puerto es: "+ page.getPort());
        System.out.println("El path es: "+page.getPath());
        System.out.println("La consulta es: "+page.getQuery());
        System.out.println("El nombre del archivo es: "+page.getFile());
        System.out.println("La referencia es: "+page.getRef());
        * */
        printw.println("<html>");
        printw.println("<head><title>Documentacion URL</title></head>");  
        printw.println("<body>");
        printw.println("<center><h4> El protocolo es: "+page.getProtocol()+"</h4></center>");
        printw.println("<center><h4> La autoridad es:  "+page.getAuthority()+"</h4></center>");
        printw.println("<center><h4>El host es: "+page.getHost()+"</h4></center>");
        printw.println("<center><h4> El puerto es: "+page.getPort()+"</h4></center>");
        printw.println("<center><h4>El path es:  "+page.getPath()+"</h4></center>");
        printw.println("<center><h4>La consulta es:  "+page.getQuery()+"</h4></center>");
        printw.println("<center><h4> El nombre del archivo es:  "+page.getFile()+"</h4></center>");
        printw.println("<center><h4>La referencia es:  "+page.getRef()+"</h4></center>");
        

        printw.println("</body>");
        printw.println("</html>");
        printw.close();
    }

}
