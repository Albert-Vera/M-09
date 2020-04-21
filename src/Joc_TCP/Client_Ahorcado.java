package Joc_TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client_Ahorcado extends Thread {
    String hostname, paraulaSecreta;
    int port;
    boolean continueConnected;
    int intents = 7;

    public Client_Ahorcado(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
        continueConnected = true;
        intents = 7;
    }

    public void run() {
        String serverData;
        String request;
        Socket socket;
        BufferedReader in;
        PrintStream out;
        try {
            socket = new Socket(InetAddress.getByName(hostname), port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream());
            while(continueConnected){
                serverData = in.readLine();
                paraulaSecreta = in.readLine();
                //processament de les dades rebudes i obtenció d'una nova petició
                request = getRequest(serverData, paraulaSecreta);
                //enviament dades
                out.println(request);
                out.println(intents);
                out.flush();
            }
            close(socket);
        } catch (UnknownHostException ex) {
            System.out.println("Error de connexió. No existeix el host: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de connexió indefinit: " + ex.getMessage());
        }
    }
    public String getRequest( String serverData, String paraulaSecreta) {
        String ret;
        String paraulaBusqueda = "";
        char a;
        imprimirSortidaParaula(serverData);
        if( serverData.equals("Correcte") || serverData.equals("Finito")) {
            continueConnected = false;
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("\n\n" +
                    "Et queden " + intents + " intents.");
            System.out.print("Pensa en una paraula de " + paraulaSecreta.length() + " lletras ");
            System.out.print("\n\nIntrodueix una lletra: ");
            while (true) {
                ret = in.next();
                if (ret.length() == 1) break;
                else System.out.print("Collons !!! te he dit una lletra !!!\n\nIntrodueix una lletra: ");
            }
            if ( !comprovaEncert(ret, paraulaSecreta) ) intents--;
            a = ret.charAt(0);
            paraulaBusqueda = generarParaulaDeBusqueda(a, serverData);
        }
        return paraulaBusqueda;
    }
    void imprimirSortidaParaula(String serverData){
        if ( serverData.equals("Finito")) {
            System.out.println("\nH a s  P e r d u t ");
            System.out.print("\n  L a  P a r a u l a  e r a:   ");
            for (int i = 0; i < paraulaSecreta.length(); i++) {
                System.out.print(paraulaSecreta.charAt(i) + " ");
            }
        }else if (serverData.equals("Correcte")){
            System.out.println("\nH a s  g u a n y a t !");
            System.out.println("C a m p e ó n !");
        } else{
            System.out.print("\n\t\t\tCOINCIDÈNCIES:  ");
            for (int i = 0; i < serverData.length(); i++) {
                System.out.print(serverData.charAt(i) + "  ");
            }
        }
    }
    private char[] paraula_a_Char(String paraula){
        char[] lletras;
        lletras = new char[paraula.length()];
        for(int i = 0; i < paraula.length(); i++){
            lletras[i] = paraula.charAt(i);
        }
        return lletras;
    }
    public boolean comprovaEncert(String paraulaEntrant, String paraulaSecreta ){
        char a = paraulaEntrant.charAt(0);
        char [] b = paraula_a_Char(paraulaSecreta);
        for (int i = 0; i < paraulaSecreta.length(); i++) {
            if ( a == b[i]) return true; // coincideix lletra introduida
        }
        return false;
    }
    public String generarParaulaDeBusqueda(char lletraEntran, String paraula){

        if (paraula.equalsIgnoreCase("Benvingut al joc!")){
            paraula = "";
            for (int i = 0; i < paraulaSecreta.length(); i++) {
                paraula += lletraEntran;
            }
        }else{
            paraula = paraula.replace('-', lletraEntran);// les no coincidents les omple de guions
        }
        return paraula;
    }
    public boolean mustFinish(String dades) {
        if (dades.equals("exit")) return false;
        return true;
    }
    private void close(Socket socket){
        try {
            //tancament de tots els recursos
            if(socket!=null && !socket.isClosed()){
                if(!socket.isInputShutdown()){
                    socket.shutdownInput();
                }
                if(!socket.isOutputShutdown()){
                    socket.shutdownOutput();
                }
                socket.close();
            }
        } catch (IOException ex) {
            //enregistrem l'error amb un objecte Logger
            Logger.getLogger(Client_Ahorcado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
//        if (args.length != 2) {
//            System.err.println(
//                "Usage: java Client_Ahorcado <host name> <port number>");
//            System.exit(1);
//        }
//         String hostName = args[0];
//         int portNumber = Integer.parseInt(args[1]);
        Client_Ahorcado clientTcp = new Client_Ahorcado("localhost",5000);
        clientTcp.start();
    }
}
