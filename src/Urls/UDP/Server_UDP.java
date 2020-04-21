package Urls.UDP;

import org.jsoup.select.Evaluator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server_UDP {


    public static void main(String[] args) {

        Server_UDP server = new Server_UDP();
        final int port = 5000;
        byte[] buffer = new byte[1024];

        try {
            System.out.println("Iniciant el servidor UDP");
            DatagramSocket socketUDP = new DatagramSocket(port);
            while (true) {
                DatagramPacket peticio = new DatagramPacket(buffer, buffer.length);
                socketUDP.receive(peticio);

                server.rebenPeticio(peticio);

                int portClient = peticio.getPort();
                InetAddress direccio = peticio.getAddress();

                buffer = server.generarResposta();

                DatagramPacket resposta = new DatagramPacket(buffer, buffer.length, direccio, portClient);
                System.out.println("Envio la informació del servidor cap al client");
                socketUDP.send(resposta);
            }        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void rebenPeticio(DatagramPacket peticio){
        String misatge = new String(peticio.getData());
        System.out.println(misatge);
        System.out.println("Recibo info del Client ");
    }
    byte[] generarResposta(){

        String misatge = "! Hello World desde el Servidor";
        byte[] buffer = misatge.getBytes();
        return buffer;
    }
}
