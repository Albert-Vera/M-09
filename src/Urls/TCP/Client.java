package Urls.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {

        final String host = "https://docs.google.com/spreadsheets/d/1FqJmVgC-OXn5BMx1216YW92LOTdX_CgRcuUlQ3IvLDQ/edit#gid=946984702";
        final int port = 5000;
        DataInputStream in;
        DataOutputStream out;

        try{
            Socket sc = new Socket(host, port);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("Hola ");

            String mensaje = in.readUTF();

            System.out.println(mensaje);
            sc.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
