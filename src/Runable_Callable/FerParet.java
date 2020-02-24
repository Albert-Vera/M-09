package Runable_Callable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FerParet {

    public static void main(String[] args) throws Exception {
        //Definim l'executor dels processos
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        int numPaletes = 5, ti, te, numMaons = 10;

        //instanciem els paletes
        Paleta[] P = new Paleta[numPaletes];

        //comencem a contar el temps
        ti = (int) System.currentTimeMillis();
        //Donem nom als paletes i els posem a fer fer la paret
        for (int i=0;i<numPaletes;i++) {
            P[i] = new Paleta("Paleta-"+i,numMaons);
            executor.execute(P[i]);
        }
        executor.shutdown();
        executor.awaitTermination(numMaons, TimeUnit.SECONDS);

        //Han acabat i agafem el temps final
        te = (int) System.currentTimeMillis();

        System.out.println("Han trigat: " + (te - ti)/1000 + " segons");






    }
}