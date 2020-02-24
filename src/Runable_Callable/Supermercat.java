package Runable_Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Supermercat {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        int numClients = 9; int numCaixes = 4, productes = 5;
        List<Integer> preus = new ArrayList<>();
        Runnable proces = null ;

        while ( numClients > 0) {

            for (int x = 1; x < numCaixes; x++) {

                for (int i = 0; i < productes; i++) {
                    preus.add((int) (Math.random() * 10) + 1);
                }
                numClients --;
                proces = new Client(x, preus);
                executor.execute(proces);
            }
        }
        executor.shutdown();
        executor.awaitTermination(numCaixes, TimeUnit.SECONDS);
    }
}
