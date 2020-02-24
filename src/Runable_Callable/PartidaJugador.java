package Runable_Callable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PartidaJugador  {

    public static void main(String[] args) {

        //final Runnable kennyRogers = (Runnable) new Jugador("Kenny");
        Jugador kennyRogers = new Jugador("Kenny");
        MonitorarJugador mKenny = new MonitorarJugador(kennyRogers);
        Jugador paulNewman = new Jugador("Paul");
        MonitorarJugador mPaul = new MonitorarJugador(paulNewman);
        Jugador albert = new Jugador("Albert");
        MonitorarJugador mAlbert = new MonitorarJugador(albert);


        final Runnable k = new ExecutaFil();
        final Runnable p = new ExecutaFil();
        final Runnable a = new ExecutaFil();

        ScheduledExecutorService schExService = Executors.newScheduledThreadPool(3);
        schExService.scheduleWithFixedDelay( k,2,1, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(mKenny,3,1,TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay( p,3,1,TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(mPaul,3,1,TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay( a,2,1,TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(mAlbert,3,1,TimeUnit.SECONDS);
        schExService.execute(k);
        schExService.execute(p);
        schExService.execute(a);
        // Esperem a que passin el 25s o né a que acabin de juga
        try{
            schExService.awaitTermination(5, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        schExService.shutdownNow();

        System.out.println("\nTotal " +  kennyRogers.getNom() + ":" + kennyRogers.getPunts());
        System.out.println("Total "+ paulNewman.getNom() + ":" + paulNewman.getPunts());
        System.out.println("Total "+ albert.getNom() + ":" + albert.getPunts());
    }

    static class ExecutaFil implements Runnable {
        Jugador jugador;
        @Override
        public void run() {
            jugador.setPunts(3);
        }
    }
}
