package Joc_TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Thread_Servidor_Ahorcado implements Runnable {
    Socket clientSocket = null;
    BufferedReader in = null;
    PrintStream out = null;
    String msgEntrant;
    String msgSortint;
    String paraulaSecreta;
    El_Ahorcado ahorcado = new El_Ahorcado();
    boolean acabat;
    String intentsJugador;

    public Thread_Servidor_Ahorcado(Socket clientSocket, String paraulaSecreta) throws IOException {
        this.clientSocket = clientSocket;
        this.paraulaSecreta = paraulaSecreta;
        acabat = false;
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out= new PrintStream(clientSocket.getOutputStream());
    }
    @Override
    public void run() {
        try {
            while(!acabat) {
                msgSortint = generaResposta(msgEntrant);
                out.println(msgSortint);
                out.println(paraulaSecreta);
                out.flush();
                msgEntrant = in.readLine();
                intentsJugador = in.readLine();
            }
        }catch(IOException e){
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println("Aconseguit en " + (7 - Integer.parseInt(intentsJugador)) + " errors");
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String generaResposta(String paraulaEntrant) {
        String ret;
        if(paraulaEntrant == null) ret="Benvingut al joc!";
        else {
            if ( intentsJugador.equals("0")) {
                acabat = true;
                return "Finito";
            }
            ret = this.ahorcado.comprova_Paraula(paraulaEntrant, paraulaSecreta);
            if(ret.equalsIgnoreCase("Correcte")) {
                acabat = true;
            }else ret = ahorcado.respostaSiNoEncerta(paraulaEntrant, paraulaSecreta);
        }
        return ret;
    }
}
