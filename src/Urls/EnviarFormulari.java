package Urls;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;


public class EnviarFormulari {

    private static Object mas;

    public static void main(String[] args) throws IOException {


        final String host = "https://www.linkedin.com/";

        URL url = new URL(host);
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);


        //OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
       // out.write(byteData);

        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        out.writeBytes("entry.835030737=albert&entry.1616686619=Si&");

        DataInputStream in = new DataInputStream(conn.getInputStream());

        String resposta = in.readUTF();
        System.out.println("resposta: " + resposta);

    }
}
