package Joc_TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor_Ahorcado {
    int port;
    String paraula;
    El_Ahorcado ahorcado = new El_Ahorcado();

    public Servidor_Ahorcado(int port ) {
        this.port = port;
        paraula = ahorcado.generarParaula();
    }
    public void listen() {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while(true) { //esperar connexió del client i llançar thread
                clientSocket = serverSocket.accept();
                //Llançar Thread per establir la comunicació
                Thread_Servidor_Ahorcado FilServidor = new Thread_Servidor_Ahorcado(clientSocket, paraula);
                Thread client = new Thread(FilServidor);
                client.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor_Ahorcado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {

//        if (args.length != 1) {
//            System.err.println("Usage: java Servidor_Ahorcado <port number>");
//            System.exit(1);
//        }
//        int port = Integer.parseInt(args[0]);
        Servidor_Ahorcado servidor = new Servidor_Ahorcado(5000);
        servidor.listen();

    }
}
