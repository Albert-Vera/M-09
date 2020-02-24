package Runable_Callable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Jugar  {
    public Jugar() {
    }

    public static void main(String[] args) throws InterruptedException {

        // Es creen dos jugadors
        Jugador jugador1 = new Jugador("Joan");
        Jugador jugador2 = new Jugador("Pere");

        // Instanciem el processos de donar i llegir punts amb els jugadors
        // Un procés controla només un jugador

        pDonarPuntsJugador donar = new pDonarPuntsJugador (jugador1);
        pLlegirPuntsJugadors llegir = new pLlegirPuntsJugadors(jugador1);
        pDonarPuntsJugador donar2 = new pDonarPuntsJugador(jugador2);
        pLlegirPuntsJugadors llegir2 = new pLlegirPuntsJugadors(jugador2);

        // Executem el 4 processos
        ScheduledExecutorService schExService = Executors.newScheduledThreadPool(3);
        schExService.scheduleWithFixedDelay(donar, 2, 2, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(llegir,4, 4, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(donar2, 5, 1, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(llegir2, 3, 5, TimeUnit.SECONDS);

        // Esperem a que passin els 25s o bé a que acabin tots
        schExService.awaitTermination(25, TimeUnit.SECONDS);
        schExService.shutdownNow();

        System.out.println("En " + jugador1.getNom() + " ha acabat amb " + jugador1.getPunts() + " punts");
        System.out.println("En " + jugador2.getNom() + " ha acabat amb " + jugador2.getPunts() + " punts");

    }
}
