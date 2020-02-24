package Runable_Callable;

public class pDonarPuntsJugador implements Runnable {

    Jugador jugador;

    public pDonarPuntsJugador(Jugador j) {
        this.jugador = j;
    }

    @Override
    public void run() {
        int p = (int) ((Math.random())*100);
        jugador.setPunts(p);
        System.out.println("donant punts a en " + jugador.getNom() + ":" + p);
    }
}
