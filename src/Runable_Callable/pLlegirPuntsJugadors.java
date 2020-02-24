package Runable_Callable;

public class pLlegirPuntsJugadors implements Runnable {

    Jugador jugador;

    public pLlegirPuntsJugadors(Jugador j) {
        this.jugador = j;
    }

    @Override
    public void run() {
        System.out.println("El jugador " + jugador.getNom() + " porta " + jugador.getPunts());
    }
}
