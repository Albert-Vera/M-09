package Urls.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        final int port = 5000;

        try{
            servidor = new ServerSocket(port);
            System.out.println("Servidor iniciat...");

            while (true){
                sc = servidor.accept();  // aqui espera a que arribi una petició
                System.out.println("Client Conectat...");
                in = new DataInputStream(sc.getInputStream());
                out= new DataOutputStream(sc.getOutputStream());

                String misatge = in.readUTF(); // espera a leer
                System.out.println(misatge);

                out.writeUTF("Hola mundo desde el sevidor....");

                sc.close();
                System.out.println("Cliente desconectado");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
