package Urls.UDP;

import java.io.IOException;
import java.net.*;

public class Client_UDP {
    public static void main(String[] args) {
        final int portServidor = 25565;
        byte[] buffer = new byte[1024];

        try{
            InetAddress direccioServidor = InetAddress.getByName("192.168.22.102");
            DatagramSocket socketUDP = new DatagramSocket();
            buffer = dadesAEnviar();
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccioServidor, portServidor);
            System.out.println("Envio el datagrama");
            socketUDP.send(pregunta);

            DatagramPacket resposta = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(resposta);
            rebenResposta(resposta);
            socketUDP.close();


        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void rebenResposta(DatagramPacket resposta) {
        System.out.println("rebent informació del servidor....\n");
        String misatgeResposta = new String(resposta.getData());
        System.out.println("mis: " + misatgeResposta);
    }

    private static byte[] dadesAEnviar() {
        byte[] buffer;
        String misatge = "Hello World desde el client !";
        buffer = misatge.getBytes();
        return buffer;
    }
}
