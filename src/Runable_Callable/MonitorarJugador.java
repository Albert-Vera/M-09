package Runable_Callable;

public class MonitorarJugador implements Runnable {

    private Jugador jugador;

    public MonitorarJugador(Jugador j) {
        this.jugador = j;
    }

    @Override
    public void run() {
        System.out.println(jugador.getNom() + " acumula: " + jugador.getPunts());
    }
}
