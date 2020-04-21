package Examen_UF2.exercici_3;

import Runable_Callable.Callable.AlumneP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Exercici_3 {

    public static void main(String[] args) throws InterruptedException {

        int concursants = 10;
        String persona = "concursan: ";

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Menjador> comeHuevos = new ArrayList<Menjador>();

        for (int i=0;i<concursants;i++) {
            Menjador men = new Menjador(persona +i);
            comeHuevos.add(men);
        }

        List <Future<Integer>> llistaResultats;

        llistaResultats = executor.invokeAll(comeHuevos);
        executor.shutdown();


        for (int i = 0; i < llistaResultats.size(); i++) {
            Future<Integer> resultat = llistaResultats.get(i);
            try {
                System.out.println(comeHuevos.get(i).getNom() + ": " + resultat.get());
            } catch (InterruptedException | ExecutionException e) {
                e.getStackTrace();
            }
        }

        //System.out.println("Han trigat: " + (te - ti)/1000 + " segons");
    }
}
