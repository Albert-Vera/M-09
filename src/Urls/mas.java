package Urls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class mas {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.chuidiang.com");
        URLConnection uc = url.openConnection();
        uc.connect();

        //Creamos el objeto con el que vamos a leer
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String inputLine;
        String contenido = "";
        while ((inputLine = in.readLine()) != null) {
            contenido += inputLine + "\n";
            //if (inputLine.contains("HREF")) System.out.println(inputLine);
        }
        in.close();

        System.out.println(contenido);
    }
}
